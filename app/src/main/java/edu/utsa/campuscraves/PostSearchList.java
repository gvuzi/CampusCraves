package edu.utsa.campuscraves;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostSearchList extends ComponentActivity {
    ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_search_list);
        RecyclerView recyclerView = findViewById(R.id.restaurantList);
        setupRestaurants();
        RestaurantListViewAdapter adapter = new RestaurantListViewAdapter(this, restaurantList);
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
                "One UTSA Circle, San Antonio, TX 78249", "Monday: 10:30AM-7PM\n" + "Tuesday: 10:30AM-7PM\n" + "Wednesday: 10:30AM-7PM\n" +
                "Thursday: 10:30AM-7PM\n" + "Friday: 10:30AM-2:30PM\n" + "Saturday: Closed\n" + "Sunday:Closed", "210-458-6972", "pandaexpress.com",
                "https://scontent-dfw5-2.xx.fbcdn.net/v/t39.30808-6/305569458_10167100738410093_3526238491316120511_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_ohc=sChDqpWvwFcAb5vJxnt&_nc_ht=scontent-dfw5-2.xx&oh=00_AfB8X8qEVVtnquFvCHXHggU7IR03h7wYRwnUopuE9uAofg&oe=6634B978");

        restaurantList.add(pandaExpress);
    }

}
