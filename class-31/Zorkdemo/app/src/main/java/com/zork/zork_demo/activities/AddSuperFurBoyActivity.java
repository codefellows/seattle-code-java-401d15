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
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.zork.zork_demo.R;
import com.amplifyframework.datastore.generated.model.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AddSuperFurBoyActivity extends AppCompatActivity {
    public static final String Tag = "AddSuperFurBoyActivity";

    Spinner trainerSpinner = null;
    CompletableFuture<List<Trainer>> trainerFuture = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_super_fur_boy);
        trainerFuture = new CompletableFuture<>();


        setUpTypeSpinner();
        setUpTrainerSpinner();
        setUpSubmitBttn();
    }

    private void setUpTrainerSpinner(){
        // query our trainers
        trainerSpinner = findViewById(R.id.AddSuperFurBoySpinner);
        Amplify.API.query(
                ModelQuery.list(Trainer.class),
                success -> {
                    Log.i(Tag, "Read trainers succcessfully");
                    ArrayList<String> trainerNames = new ArrayList<>();
                    ArrayList<Trainer> trainers = new ArrayList<>();
                    for (Trainer trainer : success.getData()){
                        trainers.add(trainer);
                        trainerNames.add(trainer.getName());
                    }
                    trainerFuture.complete(trainers);
                    runOnUiThread(() -> trainerSpinner.setAdapter(new ArrayAdapter<>(
                            this,
                            android.R.layout.simple_spinner_item,
                            trainerNames)));
                },
                failure -> {
                    trainerFuture.complete(null); // Don't forget to complete a CompletableFuture on every code path!
                    Log.i(Tag, "Did not read trainers successfully");
                }
        );
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
            String selectedTrainerString = trainerSpinner.getSelectedItem().toString();
            List<Trainer> trainers = null;
            try {
                trainers = trainerFuture.get();
            } catch (InterruptedException ie) {
                Log.e(Tag, "Interupted Exception while getting trainers");
                Thread.currentThread().interrupt();
            } catch (ExecutionException ee) {
                Log.e(Tag, "ExecutionException while getting trainers" + ee.getMessage());
            }

            Trainer selectedTrainer = trainers.stream().filter(t -> t.getName().equals(selectedTrainerString)).findAny().orElseThrow(RuntimeException::new);
            // gather all data from inputs
            String superFurBoyName = ((EditText) findViewById(R.id.AddSuperFurBoyNameET)).getText().toString();
            String superFurBoyHeight = ((EditText) findViewById(R.id.AddSuperFurBoyHeightET)).getText().toString();
            Integer height = Integer.parseInt(superFurBoyHeight);

        // create a new SuperFurBoy Obj
            SuperFurBoy newSuperFurBoy = SuperFurBoy.builder()
                    .name(superFurBoyName)
                    .type((PokemanTypeEnum) superFurBoyTypeSpinner.getSelectedItem())
                    .height(height)
                    .trainer(selectedTrainer)
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