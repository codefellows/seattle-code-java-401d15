package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.*;
import com.zork.zork_demo.R;
import com.zork.zork_demo.adapter.PokemanListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PokemanActivity extends AppCompatActivity {
    public static final String POKEMAN_NAME_EXTRA_TAG = "pokeMan";
    public static final String Tag = "PokemanActivity";

//    GameDatabase gameDatabase;
    List<Pokeman> pokemans = null;
    PokemanListRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokeman);
        pokemans = new ArrayList<>();
        setUpPokemanRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: Let's try this with CompletableFuture next time == async/await

        Amplify.API.query(
                // list gives ALL items, get() gives you 1
                ModelQuery.list(Pokeman.class),
                successResponse -> {
                    Log.i(Tag, "Read Pokemans successfully!");
                    pokemans.clear();
                    for (Pokeman dataBasePokeman : successResponse.getData()){
                        pokemans.add(dataBasePokeman);
                    }
                    runOnUiThread(() -> {
                        adapter.notifyDataSetChanged();
                    });
                },
                failureResponse -> Log.i(Tag, "Did not reads Pokemans successfully")
        );
    }

    private void setUpPokemanRecyclerView(){
        RecyclerView pokemanRecyclerView = findViewById(R.id.PokemanRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        pokemanRecyclerView.setLayoutManager(layoutManager);
        adapter = new PokemanListRecyclerViewAdapter(pokemans, this);
        pokemanRecyclerView.setAdapter(adapter);
    }
}