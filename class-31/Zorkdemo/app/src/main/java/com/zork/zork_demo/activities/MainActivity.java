package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zork.zork_demo.R;


public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "zork_game_db";
    public static final String PRODUCT_NAME_EXTRA_TAG = "productName";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiliaze SP
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUpUserProfileImageButton();
        setUpOrderFormButton();
        setUpPokemanBttn();
        setUpAddAPokemanBttn();
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