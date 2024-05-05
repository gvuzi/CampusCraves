package edu.utsa.campuscraves;

import java.util.ArrayList;
import java.util.ArrayList;

public class Restaurant {
    private int id;
    private int image;
    private String name;
    private double rating;
    private String cuisineType;
    private ArrayList<String> dietaryPreferences;
    private ArrayList<String> serviceType;
    private String address;
    private String storeHours;
    private String phoneNumber;
    private String website;


    public Restaurant(int id, String name, double rating, String cuisineType, ArrayList<String> dietaryPreferences, ArrayList<String> serviceType, String address, String storeHours, String phoneNumber, String website, int image) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.cuisineType = cuisineType;
        this.dietaryPreferences = dietaryPreferences;
        this.serviceType = serviceType;
        this.address = address;
        this.storeHours = storeHours;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image ) {
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public ArrayList<String> getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(ArrayList<String> dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public ArrayList<String> getServiceType() {
        return serviceType;
    }

    public void setServiceType(ArrayList<String> serviceType) {
        this.serviceType = serviceType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoreHours() {
        return storeHours;
    }

    public void setStoreHours(String storeHours) {
        this.storeHours = storeHours;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
