package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zork.zork_demo.R;

public class UserProfileActivity extends AppCompatActivity {
    // setup shared Pref
    SharedPreferences sharedPreferences;
    // preferences tags
    public static final String USER_NAME_TAG = "userName";
    public static final String USER_EMAIL_TAG = "userEmail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String userName = sharedPreferences.getString(USER_NAME_TAG, "");
        // if it has value, let's display that to the page
        if(!userName.isEmpty()){
            EditText userNameEdited = findViewById(R.id.UserProfileEditTextPersonName);
            userNameEdited.setText(userName);
        }
        setUpSubmitButton();
    }

    private void setUpSubmitButton(){
        // grab the button element
        Button submitButton = findViewById(R.id.UserProfileSubmitBttn);
        // setup the onclick listener
        submitButton.setOnClickListener(view -> {
            //Setup SP to edit. It is implicitly read only
            SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();
            String nameInput = ((EditText) findViewById(R.id.UserProfileEditTextPersonName)).getText().toString();
            String emailInput = ((EditText) findViewById(R.id.UserProfileEditTextEmailAddress)).getText().toString();
            // save to sharedPref
            preferenceEditor.putString(USER_NAME_TAG, nameInput);
            preferenceEditor.putString(USER_EMAIL_TAG, emailInput);
            preferenceEditor.apply(); // TODO: Nothing saves unless you do this, DONT FORGET!!

            Toast.makeText(UserProfileActivity.this, "Settins saved", Toast.LENGTH_SHORT).show();
        });
    }

    //  collect user input
    // save input into sharedPreferences
}