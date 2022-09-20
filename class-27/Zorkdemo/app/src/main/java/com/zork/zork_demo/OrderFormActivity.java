package com.zork.zork_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
            productNameString = callingIntent.getStringExtra(MainActivity.PRODUCT_NAME_EXTRA_TAG);
        TextView orderFormProductName = findViewById(R.id.OrderFormProductNameTV);
        orderFormProductName.setText(productNameString);
        }
    }
}