package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.zork.zork_demo.R;
import com.zork.zork_demo.database.GameDatabase;
import com.zork.zork_demo.models.Pokeman;

import java.util.Date;

public class AddPokemanActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "zork_game_db";
    GameDatabase gameDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokeman);

        //setup our DB!
        // Initialize the DB
        gameDatabase = Room.databaseBuilder(
                getApplicationContext(),
                GameDatabase.class,
                DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();


        setUpTypeSpinner();
        setUpSubmitBttn();


    }

    private void setUpTypeSpinner(){
        Spinner pokemanTypeSpinner = findViewById(R.id.AddPokemanTypeSpinner);
        pokemanTypeSpinner.setAdapter(new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                Pokeman.PokemanTypeEnum.values()
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
            java.util.Date newDate = new Date();
        // from string the enum
            Pokeman.PokemanTypeEnum pokemanTypeEnum = Pokeman.PokemanTypeEnum.fromString(pokemanTypeSpinner.getSelectedItem().toString());

        // create a new Pokeman Obj
            Pokeman newPokeman = new Pokeman(pokemanName, pokemanTypeEnum, height, newDate);
        // Insert into DB
            gameDatabase.pokemanDao().insertAPokeman(newPokeman);
        // Redirect to Main
            Intent goToPokemonActivity = new Intent(AddPokemanActivity.this, PokemanActivity.class);
            startActivity(goToPokemonActivity);

        });
    }

}