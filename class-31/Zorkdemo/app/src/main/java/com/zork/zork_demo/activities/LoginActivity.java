package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;
import com.zork.zork_demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpLoginForm();
    }

    // accept intent w/ extra from verify activity
    // setup on click listener for login bttn
    // gather email and password
    // make a login call to Cognito

    private void setUpLoginForm(){
        Intent callingIntent = getIntent();
        String userEmail = callingIntent.getStringExtra(VerifyActivity.VERIFY_ACCOUNT_EMAIL_TAG);
        EditText emailET = findViewById(R.id.LoginEmailET);
        emailET.setText(userEmail);
        findViewById(R.id.LoginBttn).setOnClickListener(view -> {
            String userSelectedEmail = emailET.getText().toString();
            String userPassword = ((EditText) findViewById(R.id.LoginPasswordET)).getText().toString();

            Amplify.Auth.signIn(
                    userSelectedEmail,
                    userPassword,
                    success -> {
                        Log.i(TAG, "Login succeeded: " + success);
                        Intent goToProductListIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(goToProductListIntent);
                    },
                    failure -> {
                        Log.i(TAG, "Login failed: " + failure);
                        runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show());
                    }
            );
        });
    }

}