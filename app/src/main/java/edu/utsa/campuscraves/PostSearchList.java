package edu.utsa.campuscraves;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostSearchList extends ComponentActivity implements RestaurantListInterface{
    ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
    ArrayList<Restaurant> filteredList = new ArrayList<Restaurant>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_search_list);
        RecyclerView recyclerView = findViewById(R.id.restaurantList);
        setupRestaurants();
        setupButtons();
        filteredList = sortRestaurants();
        RestaurantListViewAdapter adapter = new RestaurantListViewAdapter(this, filteredList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
    }

    public void setupRestaurants() {

        //implementing Panda Express
        ArrayList<String> dietaryPrefsPandaExpress = new ArrayList<>();
        dietaryPrefsPandaExpress.add("None");

        ArrayList<String> serviceTypesPandaExpress = new ArrayList<>();
        serviceTypesPandaExpress.add("Dine-in");
        serviceTypesPandaExpress.add("Takeout");

        Restaurant pandaExpress = new Restaurant(1,"Panda Express", 0.0, "Asian",dietaryPrefsPandaExpress, serviceTypesPandaExpress,
                "One UTSA Circle\nSan Antonio, TX\n78249", "Monday: 10:30AM-7PM\n" + "Tuesday: 10:30AM-7PM\n" + "Wednesday: 10:30AM-7PM\n" +
                "Thursday: 10:30AM-7PM\n" + "Friday: 10:30AM-2:30PM\n" + "Saturday: Closed\n" + "Sunday: Closed", "210-458-6972", "https://www.pandaexpress.com/",
                R.drawable.pandaexpress);

        restaurantList.add(pandaExpress);

        //implementing Subway
        ArrayList<String> dietaryPrefsSubway = new ArrayList<>();
        dietaryPrefsSubway.add("Vegetarian");
        dietaryPrefsSubway.add("Vegan");

        ArrayList<String> serviceTypesSubway = new ArrayList<>();
        serviceTypesSubway.add("Dine-in");
        serviceTypesSubway.add("Takeout");
        serviceTypesSubway.add("Online Ordering");

        Restaurant Subway = new Restaurant(2, "Subway", 0.0, "American", dietaryPrefsSubway, serviceTypesSubway, "John Peace Library\n1 UTSA Circle\nSan Antonio, TX\n78249",
                "Monday: 7AM-8PM\n" + "Tuesday: 7AM-8PM\n" + "Wednesday: 7AM-8PM\n" +
                        "Thursday: 7AM-8PM\n" + "Friday: 7AM-5PM\n" + "Saturday: 12-7PM\n" + "Sunday: Closed", "210-458-4209", "https://www.subway.com/en-us",
                R.drawable.subwaylogo);

        restaurantList.add(Subway);

        //implementing Chick-fil-A
        ArrayList<String> dietaryPrefsChickFilA = new ArrayList<>();
        dietaryPrefsChickFilA.add("Vegetarian");
        dietaryPrefsChickFilA.add("Vegan");
        dietaryPrefsChickFilA.add("Gluten-free");

        ArrayList<String> serviceTypesChickFilA = new ArrayList<>();
        serviceTypesChickFilA.add("Dine-in");
        serviceTypesChickFilA.add("Takeout");
        serviceTypesChickFilA.add("Online Ordering");

        Restaurant ChickFilA = new Restaurant(3, "Chick-Fil-A", 0.0, "American", dietaryPrefsChickFilA, serviceTypesChickFilA, "John Peace Library\n 1 UTSA Circle\nSan Antonio, TX\n78249",
                "Monday: 10:30AM-7:30PM\n" + "Tuesday: 10:30AM-7:30PM\n" + "Wednesday: 10:30AM-7:30PM\n" +
                        "Thursday: 10:30AM-7:30PM\n" + "Friday: 10:30AM-7:30PM\n" + "Saturday: 10:30AM-4PM\n" + "Sunday: Closed", "210-458-4206", "https://www.chick-fil-a.com/",
                R.drawable.chickfila_logo);

        restaurantList.add(ChickFilA);

        //implementing Freebirds
        ArrayList<String> dietaryPrefsFreebirds = new ArrayList<>();
        dietaryPrefsFreebirds.add("Vegetarian");
        dietaryPrefsFreebirds.add("Vegan");

        ArrayList<String> serviceTypesFreebirds = new ArrayList<>();
        serviceTypesFreebirds.add("Dine-in");
        serviceTypesFreebirds.add("Takeout");

        Restaurant Freebirds = new Restaurant(4, "Freebirds", 0.0, "Mexican", dietaryPrefsFreebirds, serviceTypesFreebirds, "H-E-B University Center\n1 UTSA Circle\nSan Antonio, TX\n78249",
                "Monday: 10:30AM-7PM\n" + "Tuesday: 10:30AM-7PM\n" + "Wednesday: 10:30AM-7PM\n" +
                        "Thursday: 10:30AM-7PM\n" + "Friday: Closed\n" + "Saturday: Closed\n" + "Sunday: Closed", "210-461-4307", "https://www.freebirds.com/",
                R.drawable.freebirds_logo);

        restaurantList.add(Freebirds);

        //implementing Pizza Hut
        ArrayList<String> dietaryPrefsPizzahut = new ArrayList<>();
        dietaryPrefsPizzahut.add("Vegetarian");
        dietaryPrefsPizzahut.add("Vegan");
        dietaryPrefsPizzahut.add("Gluten-free");

        ArrayList<String> serviceTypesPizzahut = new ArrayList<>();
        serviceTypesPizzahut.add("Takeout");

        Restaurant Pizzahut = new Restaurant(5, "Pizza Hut", 0.0, "American", dietaryPrefsPizzahut, serviceTypesPizzahut, "Business Building\n1 UTSA Circle\nSan Antonio, TX\n78249",
                "Monday: 10:30AM-7PM\n" + "Tuesday: 10:30AM-7PM\n" + "Wednesday: 10:30AM-7PM\n" +
                        "Thursday: 10:30AM-7PM\n" + "Friday: 10:30AM-3PM\n" + "Saturday: Closed\n" + "Sunday: Closed", "N/A", "https://www.pizzahut.com/",
                R.drawable.pizzahut_logo);

        restaurantList.add(Pizzahut);


        //implementing McDonalds
        ArrayList<String> dietaryPrefsMcdonalds = new ArrayList<>();
        dietaryPrefsMcdonalds.add("None");


        ArrayList<String> serviceTypesMcdonalds = new ArrayList<>();
        serviceTypesMcdonalds.add("Dine-in");
        serviceTypesMcdonalds.add("Takeout");
        serviceTypesMcdonalds.add("Online Ordering");

        Restaurant Mcdonalds = new Restaurant(6, "McDonalds", 0.0, "American", dietaryPrefsMcdonalds, serviceTypesMcdonalds, "7257 N Loop 1604 W\nSan Antonio, TX\n78249",
                "Monday: 6AM-11PM\n" + "Tuesday: 6AM-11PM\n" + "Wednesday: 6AM-11PM\n" +
                        "Thursday: 6AM-12AM\n" + "Friday: 6AM-12AM\n" + "Saturday: 6AM-12AM\n" + "Sunday: 6AM-11PM", "210-877-2801", "https://www.mcdonalds.com/us/en-us.html",
                R.drawable.mcdonalds_logo);

        restaurantList.add(Mcdonalds);

        //implementing Taco Bell
        ArrayList<String> dietaryPrefsTacoBell = new ArrayList<>();
        dietaryPrefsTacoBell.add("Vegetarian");
        dietaryPrefsTacoBell.add("Vegan");
        dietaryPrefsTacoBell.add("Gluten-free");


        ArrayList<String> serviceTypesTacoBell = new ArrayList<>();
        serviceTypesTacoBell.add("Dine-in");
        serviceTypesTacoBell.add("Takeout");
        serviceTypesTacoBell.add("Online Ordering");

        Restaurant TacoBell = new Restaurant(7, "Taco Bell", 0.0, "Mexican", dietaryPrefsTacoBell, serviceTypesTacoBell, "7323 N Loop 1604 W\nSan Antonio, TX\n78249",
                "Monday: 9AM-3AM\n" + "Tuesday: 9AM-3AM\n" + "Wednesday: 9AM-3AM\n" +
                        "Thursday: 9AM-3AM\n" + "Friday: 9AM-3AM\n" + "Saturday: 9AM-3AM\n" + "Sunday: 9AM-3AM", "210-372-9757", "https://www.tacobell.com/",
                R.drawable.tacobell_logo);

        restaurantList.add(TacoBell);



    }

    @Override
    public void onRestaurantClick(int position) {
        Intent intent = new Intent(PostSearchList.this, RestaurantInformation.class);
        intent.putExtra("restaurantName", restaurantList.get(position).getName());
        intent.putExtra("restaurantRating", restaurantList.get(position).getRating());
        intent.putExtra("restaurantCuisineType", restaurantList.get(position).getCuisineType());
        intent.putStringArrayListExtra("restaurantDietaryPref", restaurantList.get(position).getDietaryPreferences());
        intent.putStringArrayListExtra("restaurantServiceType", restaurantList.get(position).getServiceType());
        intent.putExtra("restaurantWebsite", restaurantList.get(position).getWebsite());
        intent.putExtra("restaurantAddress", restaurantList.get(position).getAddress());
        intent.putExtra("restaurantHours", restaurantList.get(position).getStoreHours());
        intent.putExtra("restaurantPhoneNum", restaurantList.get(position).getPhoneNumber());
        intent.putExtra("restaurantImage", restaurantList.get(position).getImage());

        startActivity(intent);
    }

    private ArrayList<Restaurant> sortRestaurants() {
        String cuisineTypeInput = getIntent().getStringExtra("cuisineTypeInput");
        String dietaryPrefInput = getIntent().getStringExtra("dietaryPrefInput");
        String ratingsInput = getIntent().getStringExtra("ratingsInput");
        String serviceTypeInput = getIntent().getStringExtra("serviceTypeInput");
        double minimumRating = convertRatingsInput(ratingsInput);

        for (int i = 0; i < restaurantList.size(); i++) {
            Restaurant restaurant = restaurantList.get(i);
            boolean cuisineMatch = cuisineTypeInput.equalsIgnoreCase(restaurant.getCuisineType()) || cuisineTypeInput.equals("");
            boolean dietaryPrefMatch = restaurant.getDietaryPreferences().contains(dietaryPrefInput) || dietaryPrefInput.equals("");
            boolean ratingsMatch = restaurant.getRating() >= minimumRating || ratingsInput.equals("");
            boolean serviceTypeMatch = restaurant.getServiceType().contains(serviceTypeInput) || serviceTypeInput.equals("");


            if (cuisineMatch && dietaryPrefMatch && ratingsMatch && serviceTypeMatch) {
                filteredList.add(restaurant);
            }
        }

        return filteredList;
    }

    private double convertRatingsInput(String ratingsInput) {
        switch (ratingsInput) {
            case "5 stars":
                return 5.0;
            case "4 stars and above":
                return 4.0;
            case "3 stars and above":
                return 3.0;
            case "2 stars and above":
                return 2.0;
            case "1 star and above":
                return 1.0;
            default:
                return 0.0;
        }
    }

    private void setupButtons() {
        ImageButton homeButton = (ImageButton) findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
 }
