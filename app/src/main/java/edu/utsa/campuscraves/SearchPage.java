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

    /*public void setupRestaurants() {

        //implementing Panda Express
        ArrayList<String> dietaryPrefsPandaExpress = new ArrayList<>();
        dietaryPrefsPandaExpress.add("None");

        ArrayList<String> serviceTypesPandaExpress = new ArrayList<>();
        serviceTypesPandaExpress.add("Dine-in");

        Restaurant pandaExpress = new Restaurant(1,"Panda Express", 0.0, "Asian",dietaryPrefsPandaExpress, serviceTypesPandaExpress,
                "One UTSA Circle, San Antonio, TX 78249", "Monday: 10:30AM-7PM\n" + "Tuesday: 10:30AM-7PM\n" + "Wednesday: 10:30AM-7PM\n" +
                "Thursday: 10:30AM-7PM\n" + "Friday: 10:30AM-2:30PM\n" + "Saturday: Closed\n" + "Sunday:Closed", "210-458-6972", "pandaexpress.com",
                "https://scontent-dfw5-2.xx.fbcdn.net/v/t39.30808-6/305569458_10167100738410093_3526238491316120511_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_ohc=sChDqpWvwFcAb5vJxnt&_nc_ht=scontent-dfw5-2.xx&oh=00_AfB8X8qEVVtnquFvCHXHggU7IR03h7wYRwnUopuE9uAofg&oe=6634B978");

        restaurantList.add(pandaExpress);
    }*/

    public void setupButtons() {
        Button searchButton = (Button) findViewById(R.id.searchButton);
        ImageButton listButton = (ImageButton) findViewById(R.id.listButton);
        ImageButton reviewsButton = (ImageButton) findViewById(R.id.reviewsButton);
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SearchPage.this, PostSearchList.class);
                startActivity(intent);
            }
        });
    }



}
