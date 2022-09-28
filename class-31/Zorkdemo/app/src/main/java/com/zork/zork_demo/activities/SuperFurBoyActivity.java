package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.*;
import com.zork.zork_demo.R;
import com.zork.zork_demo.adapter.SuperFurBoyListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SuperFurBoyActivity extends AppCompatActivity {
    public static final String SUPER_FUR_BOY_NAME_EXTRA_TAG = "superFurBoy";
    public static final String Tag = "SuperFurBoyActivity";

    List<SuperFurBoy> superFurBoys = null;
    SuperFurBoyListRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_fur_boy);
        superFurBoys = new ArrayList<>();
        setUpSuperFurBoyRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: Let's try this with CompletableFuture next time == async/await

        Amplify.API.query(
                // list gives ALL items, get() gives you 1
                ModelQuery.list(SuperFurBoy.class),
                successResponse -> {
                    Log.i(Tag, "Read Super Fur Boys successfully!");
                    superFurBoys.clear();
                    for (SuperFurBoy dataSuperFurBoy : successResponse.getData()){
                        superFurBoys.add(dataSuperFurBoy);
                    }
                    runOnUiThread(() -> {
                        adapter.notifyDataSetChanged();
                    });
                },
                failureResponse -> Log.i(Tag, "Did not reads SFB's successfully")
        );

    }

    private void setUpSuperFurBoyRecyclerView(){
        RecyclerView SuperFurBoyRecyclerView = findViewById(R.id.SuperFurBoyRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        SuperFurBoyRecyclerView.setLayoutManager(layoutManager);
        adapter = new SuperFurBoyListRecyclerViewAdapter(superFurBoys, this);
        SuperFurBoyRecyclerView.setAdapter(adapter);
    }
}