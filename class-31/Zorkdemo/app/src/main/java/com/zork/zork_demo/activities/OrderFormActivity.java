package com.zork.zork_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zork.zork_demo.R;

public class OrderFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);
        setUpProductName();
    }

    private void setUpProductName(){
        Intent callingIntent = getIntent();
        String productNameString = "";
        if(callingIntent != null){
            productNameString = callingIntent.getStringExtra(SuperFurBoyActivity.SUPER_FUR_BOY_NAME_EXTRA_TAG);
        TextView orderFormProductName = findViewById(R.id.OrderFormProductNameTV);
        orderFormProductName.setText(productNameString);
        }
    }
}