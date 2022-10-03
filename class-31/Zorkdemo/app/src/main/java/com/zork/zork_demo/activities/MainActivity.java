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


        // Hardcode signup
//        Amplify.Auth.signUp("alex.white@codefellows.com",
//                "p@ssw0rd",  // Cognito's default password policy is 8 characters, no other requirements
//                AuthSignUpOptions.builder()
//                        .userAttribute(AuthUserAttributeKey.email(), "alex.white@codefellows.com")
//                        .userAttribute(AuthUserAttributeKey.nickname(), "Firefly")
//                        .build(),
//                success -> Log.i(TAG, "Signup success! " + success),
//                failure -> Log.i(TAG,"Signup failed with username " + "alex.white@codefellows.com" + "with message: " + failure)
//                );

        // User verify
//            Amplify.Auth.confirmSignUp("alex.white@codefellows.com",
//                    "147600",
//                    success -> Log.i(TAG, "Verification succeeded: " + success),
//                    failure -> Log.i(TAG, "Verification Failed: " + failure)
//                    );
        // user Login
//            Amplify.Auth.signIn("alex.white@codefellows.com",
//                        "p@ssw0rd",
//                    success -> Log.i(TAG, "Login succeeded: " + success.toString()),
//                    failure -> Log.i(TAG, "Login failed: " + failure.toString())
//                    );
//
//        Amplify.Auth.fetchAuthSession(
//                result -> Log.i("AmplifyQuickstart", result.toString()),
//                error -> Log.e("AmplifyQuickstart", error.toString())
//        );

        // LOGOUT
//        Amplify.Auth.signOut(
//                () ->
//                {
//                    Log.i(TAG, "Logout succeeded!");
//                },
//                failure ->
//                {
//                    Log.i(TAG, "Logout failed: " + failure.toString());
//                }
//        );



        // initiliaze SP
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUpUserProfileImageButton();
        setUpOrderFormButton();
        setUpPokemanBttn();
        setUpAddAPokemanBttn();
        setUpLoginSignUpBttns();
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