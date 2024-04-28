package edu.utsa.campuscraves;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.ComponentActivity;

import java.util.ArrayList;

public class SearchPage extends ComponentActivity {

    private String cuisineTypeInput;
    private String dietaryPrefInput;
    private String ratingsInput;
    private String serviceTypeInput;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        //setupButtons();
        setupDropdown();


        //setupButtons();


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

        cuisineTypeList.add("Select an option...");
        cuisineTypeList.add("American");
        cuisineTypeList.add("Italian");
        cuisineTypeList.add("Mexican");
        cuisineTypeList.add("Asian");

        dietaryPrefList.add("Select an option...");
        dietaryPrefList.add("Vegetarian");
        dietaryPrefList.add("Vegan");
        dietaryPrefList.add("Gluten-free");

        ratingsList.add("Select an option...");
        ratingsList.add("5 stars");
        ratingsList.add("4 stars and above");
        ratingsList.add("3 stars and above");
        ratingsList.add("2 stars and above");
        ratingsList.add("1 star and above");

        serviceTypeList.add("Select an option...");
        serviceTypeList.add("Takeout");
        serviceTypeList.add("Delivery");
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
}
