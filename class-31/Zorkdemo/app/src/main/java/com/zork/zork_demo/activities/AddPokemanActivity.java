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
import com.amplifyframework.core.model.temporal.Temporal;
import com.zork.zork_demo.R;
import com.amplifyframework.datastore.generated.model.*;


import java.util.Date;

public class AddPokemanActivity extends AppCompatActivity {
    public static final String Tag = "AddPokemanActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokeman);

        //setup our DB!
        // Initialize the DB


        setUpTypeSpinner();
        setUpSubmitBttn();


    }

    private void setUpTypeSpinner(){
        Spinner pokemanTypeSpinner = findViewById(R.id.AddPokemanTypeSpinner);
        pokemanTypeSpinner.setAdapter(new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                PokemanTypeEnum.values()
        ));
    }

    private void setUpSubmitBttn(){
        Spinner pokemanTypeSpinner = findViewById(R.id.AddPokemanTypeSpinner);
        Button saveNewPokemanBttn = findViewById(R.id.AddPokemanSubmitBttn);
        saveNewPokemanBttn.setOnClickListener(view -> {
            // gather all data from inputs
            String pokemanName = ((EditText) findViewById(R.id.AddPokemonNameET)).getText().toString();
            String pokemanHeight = ((EditText) findViewById(R.id.AddPokemanHeightET)).getText().toString();
            Integer height = Integer.parseInt(pokemanHeight);
        // create a new date object
            String currentDateString = com.amazonaws.util.DateUtils.formatISO8601Date(new Date());

        // create a new Pokeman Obj
            Pokeman newPokeman = Pokeman.builder()
                    .name(pokemanName)
                    .type((PokemanTypeEnum) pokemanTypeSpinner.getSelectedItem())
                    .height(height)
                    .dateCreated(new Temporal.DateTime(currentDateString))
                    .build();

        // Insert into DB
            Amplify.API.mutate(
                    ModelMutation.create(newPokeman),
                    successResponse -> Log.i(Tag, "AddPokemanActivity: made a Pokeman Successfully"),
                    failureResponse -> Log.i(Tag, "AddpokemanActivity: failed with thgis response: " + failureResponse)
            );

        // Redirect to Main
            Intent goToPokemonActivity = new Intent(AddPokemanActivity.this, PokemanActivity.class);
            startActivity(goToPokemonActivity);

        });
    }

}