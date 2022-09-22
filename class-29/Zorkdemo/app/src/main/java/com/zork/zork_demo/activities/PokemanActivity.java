package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import com.zork.zork_demo.R;
import com.zork.zork_demo.adapter.PokemanListRecyclerViewAdapter;
import com.zork.zork_demo.database.GameDatabase;
import com.zork.zork_demo.models.Pokeman;

import java.util.ArrayList;
import java.util.List;

public class PokemanActivity extends AppCompatActivity {
    public static final String POKEMAN_NAME_EXTRA_TAG = "pokeMan";
    public static final String DATABASE_NAME = "zork_game_db";
    GameDatabase gameDatabase;
    List<Pokeman> pokemans = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokeman);

        //setup our DB!
        // Initialize the DB
        gameDatabase = Room.databaseBuilder(
                getApplicationContext(),
                GameDatabase.class,
                DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        pokemans = gameDatabase.pokemanDao().findAll();
        setUpPokemanRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pokemans.clear();
        pokemans.addAll(gameDatabase.pokemanDao().findAll());

    }

    private void setUpPokemanRecyclerView(){
        RecyclerView pokemanRecyclerView = findViewById(R.id.PokemanRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        pokemanRecyclerView.setLayoutManager(layoutManager);

        PokemanListRecyclerViewAdapter adapter = new PokemanListRecyclerViewAdapter(pokemans, this);
        pokemanRecyclerView.setAdapter(adapter);

    }
}