package com.zork.zork_demo.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Trainer;
import com.zork.zork_demo.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

public class ImageSuperFurBoyActivity extends AppCompatActivity {
    public static final String TAG = "ImageSUperFurBoyActivity";
    ActivityResultLauncher<Intent> activityResultLauncher;  // at top of class
    private String s3ImageKey = "";  // At the top of the class; holds the image S3 key if one currently exists in this activity, or the empty String if there is no image picked in this activity currently

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_super_fur_boy);

        // WARNING: The ActivityResultLauncher MUST be initialized in onCreate(), not in onResume() or a click handler! Otherwise it will fail
        activityResultLauncher = getImagePickingActivityResultLauncher();

        setUpAddImageBttn();
        setUpSaveBttn();
    }

    private void setUpSaveBttn(){
        findViewById(R.id.ImageSuperFurBoyActivitySaveBttn).setOnClickListener(view -> {
            saveTrainer(s3ImageKey);
        });
    }

    private void saveTrainer(String s3key){
        // Update/save the trainer object with an Image key

        Trainer trainerToSave = Trainer.builder()
                .name("Yari")
                .productImageS3Key(s3key)
                .build();

        // Amplify call to API
        Amplify.API.mutate(
                ModelMutation.create(trainerToSave),
                success -> Log.i(TAG, "Successfully created new trainer with s3ImageKey: " + s3key),
                failure -> Log.i(TAG, "Failed to create a new Trainer with message: " + failure.getMessage())
        );
    }

    private void setUpAddImageBttn(){
        //bttn listener
        findViewById(R.id.AddImageFurBoyBttn).setOnClickListener(b -> {
            launchImageSelectionIntent();
        });

    }

    private void launchImageSelectionIntent(){
        // Part 1: launch activity to pick an image!

        Intent imageFilePickingIntent = new Intent(Intent.ACTION_GET_CONTENT);
        imageFilePickingIntent.setType("*/*"); // only allow one kind or category of file; if you don't have this, you get a very cryptic error about "No activity found to handle Intent"
        imageFilePickingIntent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"image/jpeg", "image/png"});

        // Launch Android's built-in file picking activity using our newly created ActivityResultLauncher below
        activityResultLauncher.launch(imageFilePickingIntent);
    }

    private ActivityResultLauncher<Intent> getImagePickingActivityResultLauncher(){
        ActivityResultLauncher<Intent> imagePickingActivityResultLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            // Part 2 Android calls your callback with the picked image
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                Uri pickedImageFileUri = result.getData().getData();
                                try {
                                    InputStream pickedImageInputStream = getContentResolver().openInputStream(pickedImageFileUri);
                                    String pickedImageFilename = getFileNameFromUri(pickedImageFileUri);
                                    // upload to S3
                                    uploadInputStreamToS3(pickedImageInputStream, pickedImageFilename, pickedImageFileUri);
                                } catch (FileNotFoundException fnfe) {
                                    Log.e(TAG, "Could not get file from file picker! " + fnfe.getMessage(), fnfe);
                                }
                            }
                        }
                );
        return imagePickingActivityResultLauncher;
    }

    private void uploadInputStreamToS3(InputStream pickedImageInputStream, String pickedImageFileName, Uri pickedImageFileUri){
        Amplify.Storage.uploadInputStream(
                pickedImageFileName, //S3 Key
                pickedImageInputStream,
                success -> {
                    Log.i(TAG, "Succeeded in getting file uploaded to S3! Key is: " + success.getKey());
                    s3ImageKey = success.getKey();  // non-empty s3ImageKey globally indicates there is an image picked in this activity currently
                    //TODO
                    // saveModel() -> SuperFurBoy
                    // connect to our Imaged
                    ImageView sfbImageView = findViewById(R.id.ImageSuperFurBoyImageView);
                    // make a copy of InputStream -> InputStreams cannot be reused
                    InputStream pickedImageInputStreamCopy = null;
                    try {
                        pickedImageInputStreamCopy = getContentResolver().openInputStream(pickedImageFileUri);
                    } catch (FileNotFoundException fnfe) {
                        Log.e(TAG, "Could not get file stream from URI! " + fnfe.getMessage(), fnfe);
                    }
                    sfbImageView.setImageBitmap(BitmapFactory.decodeStream(pickedImageInputStreamCopy));
                },
                failure -> Log.e(TAG, "Failure in uploading file to S3 with filename: " + pickedImageFileName + " with error: " + failure.getMessage())
        );

    }

    // Taken from https://stackoverflow.com/a/25005243/16889809
    @SuppressLint("Range")
    public String getFileNameFromUri(Uri uri){
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}