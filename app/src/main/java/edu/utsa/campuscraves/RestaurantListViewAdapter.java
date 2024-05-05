package edu.utsa.campuscraves;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantListViewAdapter extends RecyclerView.Adapter<RestaurantListViewAdapter.MyViewHolder>{

    private RestaurantListInterface restaurantListInterface;
    Context context;
    ArrayList<Restaurant> filteredRestaurants;

    public RestaurantListViewAdapter(Context context, ArrayList<Restaurant> filteredRestaurants, RestaurantListInterface restaurantListInterface) {
        this.context = context;
        this.filteredRestaurants = filteredRestaurants;
        this.restaurantListInterface = restaurantListInterface;
    }
    @NonNull
    @Override
    public RestaurantListViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.restaurant_list_layout, parent, false);
        return new RestaurantListViewAdapter.MyViewHolder(view, restaurantListInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantListViewAdapter.MyViewHolder holder, int position) {
        ArrayList<String> dietaryPrefs = filteredRestaurants.get(position).getDietaryPreferences();
        StringBuilder dietaryPrefsString = new StringBuilder();
        for (int i = 0; i < dietaryPrefs.size(); i++) {
            String pref = dietaryPrefs.get(i);
            dietaryPrefsString.append(pref);
            if (i < dietaryPrefs.size() - 1) {
                dietaryPrefsString.append(", ");
            }
            }

        ArrayList<String> serviceType = filteredRestaurants.get(position).getServiceType();
        StringBuilder serviceTypeString = new StringBuilder();
        for (int i = 0; i < serviceType.size(); i++) {
            String pref = serviceType.get(i);
            serviceTypeString.append(pref);
            if (i < serviceType.size() - 1) {
                serviceTypeString.append(", ");
            }
        }
                holder.restaurantName.setText(filteredRestaurants.get(position).getName());
                holder.restaurantRating.setText(String.valueOf(filteredRestaurants.get(position).getRating()));
                holder.restaurantCuisineType.setText(filteredRestaurants.get(position).getCuisineType());
                holder.restaurantDietaryPref.setText(dietaryPrefsString.toString());
                holder.restaurantServiceType.setText(serviceTypeString.toString());
    }

    @Override
    public int getItemCount() {
        return filteredRestaurants.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView restaurantName, restaurantRating, restaurantCuisineType, restaurantDietaryPref, restaurantServiceType;
        public MyViewHolder(@NonNull View itemView, RestaurantListInterface restaurantListInterface) {
            super(itemView);

            restaurantName = itemView.findViewById(R.id.restaurantName);
            restaurantRating = itemView.findViewById(R.id.restaurantRating);
            restaurantCuisineType = itemView.findViewById(R.id.restaurantCuisineType);
            restaurantDietaryPref = itemView.findViewById(R.id.restaurantDietaryPref);
            restaurantServiceType = itemView.findViewById(R.id.restaurantServiceType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (restaurantListInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            restaurantListInterface.onRestaurantClick(pos);
                        }
                    }
                }
            });

        }
    }

}
