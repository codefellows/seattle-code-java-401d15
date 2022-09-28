package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.AmplifyModelProvider;
import com.amplifyframework.datastore.generated.model.PokemanTypeEnum;
import com.amplifyframework.datastore.generated.model.SuperFurBoy;
import com.amplifyframework.datastore.generated.model.Trainer;
import com.zork.zork_demo.R;


public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "zork_game_db";
    public static final String PRODUCT_NAME_EXTRA_TAG = "productName";
    public static final String TAG = "MainActivity";
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

//         Hardcoding Trainers

//        Trainer newTrainer = Trainer.builder()
//                .name("Stanley")
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(newTrainer),
//                success -> Log.i(TAG, "Worked"),
//                failure -> Log.i(TAG, "Didn't work")
//        );
//
//        Trainer newTrainer1 = Trainer.builder()
//                .name("Rexie")
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(newTrainer1),
//                success -> Log.i(TAG, "Worked"),
//                failure -> Log.i(TAG, "Didn't work")
//        );
//
//        Trainer newTrainer2 = Trainer.builder()
//                .name("Mandy")
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(newTrainer2),
//                success -> Log.i(TAG, "Worked"),
//                failure -> Log.i(TAG, "Didn't work")
//        );
//        SuperFurBoy newSFB = SuperFurBoy.builder()
//                .name("Fire Zork")
//                .type(PokemanTypeEnum.Fire)
//                .height(20)
//                .trainer(newTrainer)
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(newSFB),
//                s -> Log.i(TAG, ""),
//                f -> Log.i(TAG, "")
//        );
//
//        SuperFurBoy newSFB1 = SuperFurBoy.builder()
//                .name("Electric Zork")
//                .type(PokemanTypeEnum.Electric)
//                .height(20)
//                .trainer(newTrainer1)
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(newSFB1),
//                s -> Log.i(TAG, ""),
//                f -> Log.i(TAG, "")
//        );
//
//        SuperFurBoy newSFB2 = SuperFurBoy.builder()
//                .name("Water Zork")
//                .type(PokemanTypeEnum.Water)
//                .height(20)
//                .trainer(newTrainer2)
//                .build();
//        Amplify.API.mutate(
//                ModelMutation.create(newSFB2),
//                s -> Log.i(TAG, ""),
//                f -> Log.i(TAG, "")
//        );
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