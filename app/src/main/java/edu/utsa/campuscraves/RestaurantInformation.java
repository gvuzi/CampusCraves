package edu.utsa.campuscraves;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantInformation extends ComponentActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_information);
        setRestaurantInfo();
        setupButtons();
    }

    public void setupButtons() {
        Button backButton = (Button) findViewById(R.id.backButton);
        Button addToList = (Button) findViewById(R.id.addToListButton);
        ImageButton homeButton = (ImageButton) findViewById(R.id.homeButton);
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileButton);

        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToList();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantInformation.this, SearchPage.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantInformation.this, EditProfile.class);
                startActivity(intent);
            }
        });


    }

    public void setRestaurantInfo() {
        String restaurantName = getIntent().getStringExtra("restaurantName");
        Double restaurantRating = getIntent().getDoubleExtra("restaurantRating", 0.0);
        String restaurantRatingFinal = String.valueOf(restaurantRating);
        String restaurantCuisineType = getIntent().getStringExtra("restaurantCuisineType");
        ArrayList<String> restaurantDietaryPref = getIntent().getStringArrayListExtra("restaurantDietaryPref");
        ArrayList<String> restaurantServiceType = getIntent().getStringArrayListExtra("restaurantServiceType");

        StringBuilder dietaryPrefsString = new StringBuilder();
        for (int i = 0; i < restaurantDietaryPref.size(); i++) {
            String pref = restaurantDietaryPref.get(i);
            dietaryPrefsString.append(pref);
            if (i < restaurantDietaryPref.size() - 1) {
                dietaryPrefsString.append(", ");
            }
        }



        StringBuilder serviceTypeString = new StringBuilder();
        for (int i = 0; i < restaurantServiceType.size(); i++) {
            String pref = restaurantServiceType.get(i);
            serviceTypeString.append(pref);
            if (i < restaurantServiceType.size() - 1) {
                serviceTypeString.append(", ");
            }
        }



        String restaurantWebsite = getIntent().getStringExtra("restaurantWebsite");
        String restaurantAddress = getIntent().getStringExtra("restaurantAddress");
        String restaurantHours = getIntent().getStringExtra("restaurantHours");
        String restaurantPhoneNum = getIntent().getStringExtra("restaurantPhoneNum");
        int restaurantImage = getIntent().getIntExtra("restaurantImage", 0);

        TextView restaurantNameTextView = findViewById(R.id.restaurantName);
        TextView restaurantRatingTextView = findViewById(R.id.restaurantRating);
        TextView restaurantCuisineTypeTextView = findViewById(R.id.restaurantCuisineType);
        TextView restaurantDietaryPrefTextView = findViewById(R.id.restaurantDietaryPref);
        TextView restaurantServiceTypeTextView = findViewById(R.id.restaurantServiceType);
        TextView restaurantWebsiteTextView = findViewById(R.id.restaurantWebsite);
        TextView restaurantAddressTextView = findViewById(R.id.restaurantAddress);
        TextView restaurantHoursTextView = findViewById(R.id.restaurantHours);
        TextView restaurantPhoneNumTextView = findViewById(R.id.restaurantPhoneNum);
        ImageView restaurantImageView = findViewById(R.id.restaurantImage);

        restaurantNameTextView.setText(restaurantName);
        restaurantRatingTextView.setText(restaurantRatingFinal);
        restaurantCuisineTypeTextView.setText(restaurantCuisineType);
        restaurantDietaryPrefTextView.setText(restaurantDietaryPref.toString());
        restaurantServiceTypeTextView.setText(serviceTypeString.toString());
        restaurantWebsiteTextView.setText(restaurantWebsite);
        restaurantAddressTextView.setText(restaurantAddress);
        restaurantHoursTextView.setText(restaurantHours);
        restaurantPhoneNumTextView.setText(restaurantPhoneNum);
        restaurantImageView.setImageResource(restaurantImage);
    }

    private void addToList() {
        OutputStreamWriter w = null;
        Scanner scan;
        String str = null;
        String[] arr;

        int restaurantID = getIntent().getIntExtra("restaurantID", 0);
        String restaurantName = getIntent().getStringExtra("restaurantName");
        SharedPreferences sharedPreferences = getSharedPreferences("sharedID", MODE_PRIVATE);
        int userID = sharedPreferences.getInt("userID", 0);
        File f = new File(getFilesDir().getAbsolutePath() + "/list.txt");

        if (!f.exists()) {
            try {
                w = new OutputStreamWriter(openFileOutput("list.txt", MODE_PRIVATE));
                w.write(userID + "," + restaurantID);
                w.close();
                Toast.makeText(getBaseContext(), "Successfully added " + restaurantName + " to list", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            try {
                w = new OutputStreamWriter(openFileOutput("list.txt", MODE_APPEND));
                w.append("\n" + userID + "," + restaurantID);
                w.close();
                Toast.makeText(getBaseContext(), "Successfully added " + restaurantName + " to list", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
