package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.zork.zork_demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";
    public static final String SIGNUP_EMAIL_TAG = "Signup_Email_Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setUpSignUpForm();
    }
    // gather all the info: email and password
    // call to Cognito to create a new user

    private void setUpSignUpForm(){

        findViewById(R.id.SignUpBttn).setOnClickListener(view -> {
            String userEmail = ((EditText)findViewById(R.id.SignUpEmailET)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.SignUpPasswordET)).getText().toString();
            Amplify.Auth.signUp(userEmail,
                    userPassword,
                    AuthSignUpOptions.builder()
                            .userAttribute(AuthUserAttributeKey.email(), userEmail)
                            .build(),
                    success -> {
                        Log.i(TAG, "Signup success! " + success);
                        Intent goToVerifyActivity = new Intent(SignUpActivity.this, VerifyActivity.class);
                        goToVerifyActivity.putExtra(SIGNUP_EMAIL_TAG, userEmail);
                        startActivity(goToVerifyActivity);
                    },
                    failure -> {
                        Log.i(TAG,"Signup failed with username " + userEmail + "with message: " + failure);
                        runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show());
                    }
                    );

        });

    }

}