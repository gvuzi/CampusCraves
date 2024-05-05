package edu.utsa.campuscraves;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.ComponentActivity;

import java.util.ArrayList;

public class RestaurantInformation extends ComponentActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_information);
        setRestaurantInfo();
        setupButtons();
    }

    public void setupButtons() {
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
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
}
