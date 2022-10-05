package com.zork.zork_demo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
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
    //TODO: Step 1: create the location client
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_super_fur_boy);
        trainerFuture = new CompletableFuture<>();

        //TODO: Step2: setup locationClient && request permissions
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);  // hardcoded to 1; you can pick anything between 1 and 65535
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        fusedLocationClient.flushLocations();

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//
//        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> { // "location" here could be null if no one else has request a location prior!
//            // Try running Google Maps first and clicking your current location if you have a null callback here, or a null object error when getting the location!
//           if(location == null) {
//               Log.e(Tag, "Location callback was null!");
//           }
//           String currentLatitude = Double.toString(location.getLatitude());
//           String currentLongitude = Double.toString(location.getLongitude());
//           Log.i(Tag, "Our latitude: " + location.getLatitude());
//           Log.i(Tag, "Our longitude: " + location.getLongitude());
//        });

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, new CancellationToken() {
            @NonNull
            @Override
            public CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener onTokenCanceledListener) {
                return null;
            }

            @Override
            public boolean isCancellationRequested() {
                return false;
            }
        }).addOnSuccessListener(location -> {
            if(location == null) {
               Log.e(Tag, "Location callback was null!");
           }
           Log.i(Tag, "Our latitude: " + location.getLatitude());
           Log.i(Tag, "Our longitude: " + location.getLongitude());
        });

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