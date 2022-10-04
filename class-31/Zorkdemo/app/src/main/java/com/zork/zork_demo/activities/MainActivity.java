package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.zork.zork_demo.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "zork_game_db";
    public static final String PRODUCT_NAME_EXTRA_TAG = "productName";
    public static final String TAG = "MainActivity";
    SharedPreferences preferences;
    public AuthUser currentUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentUser = Amplify.Auth.getCurrentUser();

        // manual upload to S3
        // Manually create an S3 file for testing

//        String testFilename = "testFileName";
//        File testFile = new File(getApplicationContext().getFilesDir(), testFilename);
//
//        try
//        {
//            BufferedWriter testFileBufferedWriter = new BufferedWriter(new FileWriter(testFile));
//            testFileBufferedWriter.append("Some test text here\nAnother line of test text");
//            testFileBufferedWriter.close();  // Make sure to do this or the text may not be saved!
//        } catch (IOException ioe)
//        {
//            Log.e(TAG, "Could not write file locally with filename: " + testFilename);
//        }
//
//        String testFileS3Key = "someFileOnS3.txt";
//
//        Amplify.Storage.uploadFile(
//                testFileS3Key,
//                testFile,
//                success ->
//                {
//                    Log.i(TAG, "S3 upload succeeded! Key is: " + success.getKey());
//                },
//                failure ->
//                {
//                    Log.i(TAG, "S3 upload failed! " + failure.getMessage());
//                }
//        );

        // initiliaze SP
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUpUserProfileImageButton();
        setUpOrderFormButton();
        setUpPokemanBttn();
        setUpAddAPokemanBttn();
        setUpLoginSignUpBttns();
        setUpImageBttn();
    }


    private void setUpImageBttn(){
        findViewById(R.id.MainAddSFBImageBttn).setOnClickListener(v -> {
            Intent goToAddImageActivity = new Intent(MainActivity.this, ImageSuperFurBoyActivity.class);
            startActivity(goToAddImageActivity);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //get user name
        String userName = preferences.getString(UserProfileActivity.USER_NAME_TAG, "No name");
        //display name to page
        TextView userNameEdited = findViewById(R.id.MainActivityUserNameTV);
        userNameEdited.setText(userName);
    }

    // login bttn
    private void setUpLoginSignUpBttns(){
        Button loginBttn = findViewById(R.id.MainLoginBttn);
        Button signUpBttn = findViewById(R.id.MainSignUpBttn);

        if (currentUser == null) {
            loginBttn.setVisibility(View.VISIBLE);
            signUpBttn.setVisibility(View.VISIBLE);
        } else {
            loginBttn.setVisibility(View.INVISIBLE);
            signUpBttn.setVisibility(View.INVISIBLE);
        }
        loginBttn.setOnClickListener(view -> {
            Intent goToLoginActivity = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(goToLoginActivity);
        });

        signUpBttn.setOnClickListener(view -> {
            Intent goToSignUpActivity = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(goToSignUpActivity);
        });

    }

    private void setUpAddAPokemanBttn(){
        findViewById(R.id.mainActivityAddPokemanBttn).setOnClickListener(view -> {
            Intent goToAddAPokemanActivity = new Intent(MainActivity.this, AddSuperFurBoyActivity.class);
            startActivity(goToAddAPokemanActivity);
        });
    }

    private void setUpPokemanBttn(){
        findViewById(R.id.MainActivityPokemanBttn).setOnClickListener(view -> {
            Intent goToPokemanActivity = new Intent(MainActivity.this, SuperFurBoyActivity.class);
            startActivity(goToPokemanActivity);
        });
    }

    private void setUpUserProfileImageButton(){
        ImageView userImage = findViewById(R.id.mainActivityUserProfileImageView);
        userImage.setOnClickListener(view -> {
            Intent goToUserProfileActivity = new Intent(MainActivity.this, UserProfileActivity.class);
            startActivity(goToUserProfileActivity);
        });
    }

    private void setUpOrderFormButton(){
        Button orderFormBttn = MainActivity.this.findViewById(R.id.mainActivityToOrderFormBttn);
        // setting up routing logic with intents. Intents are the highway between activities
        // send you along with data
        orderFormBttn.setOnClickListener(view -> {
            // set up the intent (Current context.this, class to go to Class.class)
            Intent goToOrderFormActivity = new Intent(MainActivity.this, OrderFormActivity.class);
            // Include extra(s) with the intent
            goToOrderFormActivity.putExtra(PRODUCT_NAME_EXTRA_TAG, "Zork's Duffles");
            // Launch the intent
            startActivity(goToOrderFormActivity);
        });
    }
}