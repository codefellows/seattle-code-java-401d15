package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.amplifyframework.analytics.AnalyticsEvent;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.zork.zork_demo.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    public static final String APP_NAME = "Zorkmaster";
    public static final String DATABASE_NAME = "zork_game_db";
    public static final String PRODUCT_NAME_EXTRA_TAG = "productName";
    public static final String TAG = "MainActivity";
    SharedPreferences preferences;
    public AuthUser currentUser = null;
    private final MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentUser = Amplify.Auth.getCurrentUser();

        AnalyticsEvent event = AnalyticsEvent.builder()
                .name(APP_NAME + ": app opened")
                .addProperty("Time", Long.toString(new Date().getTime()))
                .addProperty("trackingEvent", "main activity started")
                .build();

        Amplify.Analytics.recordEvent(event);




        // initiliaze SP
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUpUserProfileImageButton();
        setUpOrderFormButton();
        setUpPokemanBttn();
        setUpAddAPokemanBttn();
        setUpLoginSignUpBttns();
        setUpImageBttn();
        setUpSpeakBttn();
    }

    private void setUpSpeakBttn(){
        String speak1 = "I like to eat, eat, eat, eepples and baneenees";
        Amplify.Predictions.convertTextToSpeech(
                speak1,
                success -> playAudio(success.getAudioData()),
                failure -> Log.e(TAG, "Audio conversion of text failed" + failure)
        );

    }

    private void playAudio(InputStream data){
        File mp3File = new File(getCacheDir(), "audio.mp3");

        try (OutputStream out = new FileOutputStream(mp3File)){
            byte[] buffer = new byte[8 * 1_024];
            int bytesRead;
            while ((bytesRead = data.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            mp.reset();
            mp.setOnPreparedListener(MediaPlayer::start);
            mp.setDataSource(new FileInputStream(mp3File).getFD());
            mp.prepareAsync();

        } catch (IOException ioe) {
            Log.e(TAG, "Error writing auidio file" + ioe);
        }
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