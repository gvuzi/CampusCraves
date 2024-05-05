package edu.utsa.campuscraves;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends ComponentActivity {

    private String cuisineTypeInput;
    private String dietaryPrefInput;
    private String ratingsInput;
    private String serviceTypeInput;

    //ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        setupDropdown();
        //setupRestaurants();
        setupButtons();
    }

    public void setupDropdown() {
        Spinner cuisineTypeDropdown = findViewById(R.id.cuisineTypeInput);
        Spinner dietaryPrefDropdown = findViewById(R.id.dietaryPrefInput);
        Spinner ratingsDropdown = findViewById(R.id.ratingsInput);
        Spinner serviceTypeDropdown = findViewById(R.id.serviceTypeInput);

        ArrayList<String> cuisineTypeList = new ArrayList<>();
        ArrayList<String> dietaryPrefList = new ArrayList<>();
        ArrayList<String> ratingsList = new ArrayList<>();
        ArrayList<String> serviceTypeList = new ArrayList<>();

        cuisineTypeList.add("");
        cuisineTypeList.add("American");
        cuisineTypeList.add("Italian");
        cuisineTypeList.add("Mexican");
        cuisineTypeList.add("Asian");

        dietaryPrefList.add("");
        dietaryPrefList.add("Vegetarian");
        dietaryPrefList.add("Vegan");
        dietaryPrefList.add("Gluten-free");

        ratingsList.add("");
        ratingsList.add("5 stars");
        ratingsList.add("4 stars and above");
        ratingsList.add("3 stars and above");
        ratingsList.add("2 stars and above");
        ratingsList.add("1 star and above");

        serviceTypeList.add("");
        serviceTypeList.add("Takeout");
        serviceTypeList.add("Delivery");
        serviceTypeList.add("Online Ordering");
        serviceTypeList.add("Dine-in");

        cuisineTypeDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cuisineTypeInput = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        dietaryPrefDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dietaryPrefInput = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ratingsDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ratingsInput = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        serviceTypeDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                serviceTypeInput = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> cuisineTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cuisineTypeList);
        cuisineTypeAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        cuisineTypeDropdown.setAdapter(cuisineTypeAdapter);

        ArrayAdapter<String> dietaryPrefAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dietaryPrefList);
        dietaryPrefAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        dietaryPrefDropdown.setAdapter(dietaryPrefAdapter);

        ArrayAdapter<String> ratingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ratingsList);
        ratingsAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        ratingsDropdown.setAdapter(ratingsAdapter);

        ArrayAdapter<String> serviceTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, serviceTypeList);
        serviceTypeAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        serviceTypeDropdown.setAdapter(serviceTypeAdapter);
    }



    public void setupButtons() {
        Button searchButton = (Button) findViewById(R.id.searchButton);
        ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
        ImageButton reviewsButton = (ImageButton) findViewById(R.id.reviewsButton);
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchPage.this, PostSearchList.class);
                intent.putExtra("cuisineTypeInput", cuisineTypeInput);
                intent.putExtra("dietaryPrefInput", dietaryPrefInput);
                intent.putExtra("ratingsInput", ratingsInput);
                intent.putExtra("serviceTypeInput", serviceTypeInput);
                startActivity(intent);
            }
        });
    }



}
