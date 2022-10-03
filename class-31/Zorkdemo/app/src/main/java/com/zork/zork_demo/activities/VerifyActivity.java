package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;
import com.zork.zork_demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class VerifyActivity extends AppCompatActivity {
    public static final String TAG = "VerifyAccountActivity";
    public static final String VERIFY_ACCOUNT_EMAIL_TAG = "Verify_Account_Email_Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        setUpVerifyForm();
    }

    // accept extra from calling activity
    // gather info -> verification code
    //verify call to Cognito

    private void setUpVerifyForm(){
        Intent callingIntent = getIntent();
        String userEmail = callingIntent.getStringExtra(SignUpActivity.SIGNUP_EMAIL_TAG);
        findViewById(R.id.VerifyBttn).setOnClickListener(view -> {
            String verificationCode = ((EditText) findViewById(R.id.VerifyCodeET)).getText().toString();

            Amplify.Auth.confirmSignUp(
                    userEmail,
                    verificationCode,
                    success -> {
                        Log.i(TAG, "Verification succeeded: " + success.toString());
                        Intent goToLogInActivity = new Intent(VerifyActivity.this, LoginActivity.class);
                        goToLogInActivity.putExtra(VERIFY_ACCOUNT_EMAIL_TAG, userEmail);
                        startActivity(goToLogInActivity);
                    },
                    failure -> {
                        Log.i(TAG, "Verification failed with username: " + "ed@codefellows.com" + " with this message: " + failure.toString());
                        runOnUiThread(() -> Toast.makeText(VerifyActivity.this, "Verify account failed!", Toast.LENGTH_SHORT));}
            );
        });
    }
}