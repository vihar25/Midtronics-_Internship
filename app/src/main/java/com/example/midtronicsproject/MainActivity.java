package com.example.midtronicsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This function will get called when Countries button is clicked and user will be navigated to the appropriate intent
    public void goToCountriesActivity (View view){
        Intent intent = new Intent (this, CountriesActivity.class);
        startActivity(intent);
    }

    //This function will get called when Profile button is clicked and user will be navigated to the appropriate intent
    public void goToProfileActivity (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}