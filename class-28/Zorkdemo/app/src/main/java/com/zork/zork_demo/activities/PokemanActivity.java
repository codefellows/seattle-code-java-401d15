package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.zork.zork_demo.R;
import com.zork.zork_demo.adapter.PokemanListRecyclerViewAdapter;
import com.zork.zork_demo.models.Pokeman;

import java.util.ArrayList;
import java.util.List;

public class PokemanActivity extends AppCompatActivity {
    public static final String POKEMAN_NAME_EXTRA_TAG = "pokeMan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokeman);
        setUpPokemanRecyclerView();
    }

    // TODO: Step 1-1: Add a RecyclerView to the Activity in the WSYIWYG editor
    private void setUpPokemanRecyclerView(){
    // TODO: Step 1-2: Grab the RecyclerView
        RecyclerView pokemanRecyclerView = findViewById(R.id.PokemanRecyclerView);
        // TODO: Step 1-3: Set the layout manager of the RecyclerView to a LinearLayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //TODO: Step 1-3 set the layput manager
        pokemanRecyclerView.setLayoutManager(layoutManager);

        // TODO: Step 2-2: Make some data items
        List<Pokeman> pokemans = new ArrayList<>();

        pokemans.add(new Pokeman("Charmander", "Fire"));
        pokemans.add(new Pokeman("Sharkpedo", "Water"));
        pokemans.add(new Pokeman("Abra", "Psychic"));
        pokemans.add(new Pokeman("Psyduck", "Psychic"));
        pokemans.add(new Pokeman("Snorlax", "Normal"));
        pokemans.add(new Pokeman("Meowth", "Normal"));
        pokemans.add(new Pokeman("Onix", "Rock"));
        pokemans.add(new Pokeman("Steelix", "Steel"));
        pokemans.add(new Pokeman("Lugia", "Psychic"));
        pokemans.add(new Pokeman("Squirtle", "Water"));

        // TODO: Step 1-5: Create and attach the RecyclerView.Adapter
        // TODO: Step 2-3: Hand in data items(pokemans array)
        // TODO: Step: 3-2 Give context to our adapter
        PokemanListRecyclerViewAdapter adapter = new PokemanListRecyclerViewAdapter(pokemans, this);
        // TODO Step: 1-5: set the adapter recyclerview
        pokemanRecyclerView.setAdapter(adapter);

    }
}