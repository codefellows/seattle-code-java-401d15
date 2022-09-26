package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.zork.zork_demo.R;
import com.zork.zork_demo.adapter.PokemanListRecyclerViewAdapter;
import com.zork.zork_demo.models.Pokeman;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PokemanActivity extends AppCompatActivity {
    public static final String POKEMAN_NAME_EXTRA_TAG = "pokeMan";
    public static final String DATABASE_NAME = "zork_game_db";
//    GameDatabase gameDatabase;
    List<Pokeman> pokemans = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokeman);
        pokemans = new ArrayList<>();
        setUpPokemanRecyclerView();

    // use the ORM calls here(DynamoDB)
    }

    @Override
    protected void onResume() {
        super.onResume();
//        pokemans.clear();

    }

    private void setUpPokemanRecyclerView(){
        RecyclerView pokemanRecyclerView = findViewById(R.id.PokemanRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        pokemanRecyclerView.setLayoutManager(layoutManager);

        pokemans.add(new Pokeman("Charmander", Pokeman.PokemanTypeEnum.FIRE, 20, new Date()));


        PokemanListRecyclerViewAdapter adapter = new PokemanListRecyclerViewAdapter(pokemans, this);
        pokemanRecyclerView.setAdapter(adapter);

    }
}