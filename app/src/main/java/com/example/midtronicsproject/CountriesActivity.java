package com.example.midtronicsproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import java.io.Console;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        //define the array variable to hold the country names
        String[] mCountryArray;
        //read the country names from xml into the array variable
        mCountryArray = getResources().getStringArray(R.array.countries_array);
        //now we will loop through the array and dynamically create a button for each country and add it to the view
        for (int i=0; i<mCountryArray.length; i++)
        {
            final String name = mCountryArray[i];
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.topMargin = 10;
            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();
            btn.setText(name);
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent myIntent = new Intent(CountriesActivity.this, CountryDetailsActivity.class);
                    myIntent.putExtra("key", name); //Optional parameters
                    CountriesActivity.this.startActivity(myIntent);
                }
            });
            LinearLayout linear = findViewById(R.id.btnContainer);
            linear.addView(btn, params);
        }
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