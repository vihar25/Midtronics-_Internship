package com.example.midtronicsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryDetailsActivity extends AppCompatActivity {
    private TextView resultTextView, countryTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        //Create an intent object
        Intent intent = getIntent();
        //get the value of country name passed from the previous intent
        String value = intent.getStringExtra("key");
        //Create objects of both text views from XML
        resultTextView = findViewById(R.id.textViewCountryDetails);
        countryTextView = findViewById(R.id.countryTextView);
        //define the URL of the HTTP GET Request and construct it dynamically with the country name
        String url = "https://restcountries.eu/rest/v1/name/" + value;
        RequestQueue ExampleRequestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest ExampleRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Process the JSON
                try{
                    // Loop through the array elements
                    for(int i=0;i<response.length();i++){
                        // Get current json object
                        JSONObject details = response.getJSONObject(i);

                        // Get the current student (json object) data
                        String countryName = details.getString("name");
                        String capital = details.getString("capital");
                        String region = details.getString("region");
                        String sub_region = details.getString("subregion");
                        Long population = details.getLong("population");
                        Long area = details.getLong("area");

                        // Display the formatted json data in text view
                        countryTextView.append(countryName);
                        resultTextView.append("Capital: " + capital + "\n\n" +"Region: " + region);
                        resultTextView.append("\n\nSub-Region: " + sub_region + "\n\n" +"Population: " + population + "\n\n" +"Area: " + area);
                        resultTextView.append("\n\n---------------------------------");
                        resultTextView.append("\n\n\n");
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //This code is executed if there is an error.
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        //now we will make the HTTP GET call to get the details of this country
        ExampleRequestQueue.add(ExampleRequest);
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