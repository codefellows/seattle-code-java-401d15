package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.zork.zork_demo.R;
import com.amplifyframework.datastore.generated.model.*;


import java.util.Date;

public class AddSuperFurBoyActivity extends AppCompatActivity {
    public static final String Tag = "AddSuperFurBoyActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_super_fur_boy);

        setUpTypeSpinner();
        setUpSubmitBttn();


    }

    private void setUpTypeSpinner(){
        Spinner pokemanTypeSpinner = findViewById(R.id.AddSuperFurBoyTypeSpinner);
        pokemanTypeSpinner.setAdapter(new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                PokemanTypeEnum.values()
        ));
    }

    private void setUpSubmitBttn(){
        Spinner superFurBoyTypeSpinner = findViewById(R.id.AddSuperFurBoyTypeSpinner);
        Button saveNewSuperFurBoyBttn = findViewById(R.id.AddSuperFurBoySubmitBttn);
        saveNewSuperFurBoyBttn.setOnClickListener(view -> {
            // gather all data from inputs
            String superFurBoyName = ((EditText) findViewById(R.id.AddSuperFurBoyNameET)).getText().toString();
            String superFurBoyHeight = ((EditText) findViewById(R.id.AddSuperFurBoyHeightET)).getText().toString();
            Integer height = Integer.parseInt(superFurBoyHeight);
        // create a new date object
            String currentDateString = com.amazonaws.util.DateUtils.formatISO8601Date(new Date());

        // create a new SuperFurBoy Obj
            SuperFurBoy newSuperFurBoy = SuperFurBoy.builder()
                    .name(superFurBoyName)
                    .type((PokemanTypeEnum) superFurBoyTypeSpinner.getSelectedItem())
                    .height(height)
                    .build();

        // Insert into DB
            Amplify.API.mutate(
                    ModelMutation.create(newSuperFurBoy),
                    successResponse -> Log.i(Tag, "AddSuperFurBoyActivity: made a SuperFurBoy Successfully"),
                    failureResponse -> Log.i(Tag, "AddSuperFurBoyActivity: failed with this response: " + failureResponse)
            );

        // Redirect to Main
            Intent goToPokemonActivity = new Intent(AddSuperFurBoyActivity.this, SuperFurBoyActivity.class);
            startActivity(goToPokemonActivity);

        });
    }

}