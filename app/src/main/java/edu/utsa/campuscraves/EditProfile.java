package edu.utsa.campuscraves;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class EditProfile extends ComponentActivity {

    public void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedID", MODE_PRIVATE);
        int userID = sharedPreferences.getInt("userID", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        loadUserInfo();
        setupButtons();
    }

    private void setupButtons() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedID", MODE_PRIVATE);
        int userID = sharedPreferences.getInt("userID", 0);
        Button logoutButton = (Button) findViewById(R.id.logoutButton);
        Button saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNameInput = (EditText) findViewById(R.id.editFirstName);
                EditText lastNameInput = (EditText) findViewById(R.id.editLastName);
                EditText usernameInput = (EditText) findViewById(R.id.editUsername);
                EditText passwordInput = (EditText) findViewById(R.id.editPassword);
                if (!firstNameInput.getText().toString().isEmpty() && !lastNameInput.getText().toString().isEmpty() &&
                        !usernameInput.getText().toString().isEmpty() && !passwordInput.getText().toString().isEmpty()) {
                    saveAccount();
                    finish();
                }
                else {
                    firstNameInput.setText("");
                    lastNameInput.setText("");
                    usernameInput.setText("");
                    passwordInput.setText("");

                    firstNameInput.setError("All fields must be filled out.");
                    lastNameInput.setError("All fields must be filled out.");
                    usernameInput.setError("All fields must be filled out.");
                    passwordInput.setError("All fields must be filled out.");
                }
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this, LandingPage.class);
                startActivity(intent);
            }
        });
    }

    private void loadUserInfo() {
        Scanner scan;
        String str = null;
        String[] arr;

        SharedPreferences sharedPreferences = getSharedPreferences("sharedID", MODE_PRIVATE);
        int userID = sharedPreferences.getInt("userID", 0);

        EditText firstNameInput = (EditText) findViewById(R.id.editFirstName);
        EditText lastNameInput = (EditText) findViewById(R.id.editLastName);
        EditText usernameInput = (EditText) findViewById(R.id.editUsername);
        EditText passwordInput = (EditText) findViewById(R.id.editPassword);

        //grabs first & last name
        try {
            scan = new Scanner(openFileInput("accounts.txt"));
            while (scan.hasNextLine()) {
                str = scan.nextLine();
                arr = str.split(",");
                if (arr.length == 3) {
                    int retrievedID = Integer.parseInt(arr[0]);
                    String retrievedFirstName = arr[1];
                    String retrievedLastName = arr[2];
                    if (retrievedID == userID) {
                        firstNameInput.setText(retrievedFirstName);
                        lastNameInput.setText(retrievedLastName);
                    }
                }

            }

            scan.close();
        } catch(IOException e){
            Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        //grabs username and password
        try {
            scan = new Scanner(openFileInput("login.txt"));
            while (scan.hasNextLine()) {
                str = scan.nextLine();
                arr = str.split(",");
                if (arr.length == 3) {
                    int retrievedID = Integer.parseInt(arr[0]);
                    String retrievedUsername = arr[1];
                    String retrievedPassword = arr[2];
                    if (retrievedID == userID) {
                        usernameInput.setText(retrievedUsername);
                        passwordInput.setText(retrievedPassword);
                    }
                }

            }
            scan.close();
            } catch(IOException e){
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        private void saveAccount() {
            EditText firstNameInput = (EditText) findViewById(R.id.editFirstName);
            EditText lastNameInput = (EditText) findViewById(R.id.editLastName);
            EditText usernameInput = (EditText) findViewById(R.id.editUsername);
            EditText passwordInput = (EditText) findViewById(R.id.editPassword);

            String firstName = firstNameInput.getText().toString();
            String lastName = lastNameInput.getText().toString();
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("sharedID", MODE_PRIVATE);
            int userID = sharedPreferences.getInt("userID", 0);
            OutputStreamWriter w = null;

            updateID();

            try {
                w = new OutputStreamWriter(openFileOutput("login.txt", MODE_APPEND));
                w.append("\n" + userID + "," + username + "," + password);
                w.close();
            }
            catch (Exception e){
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            try {
                w = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_APPEND));
                w.append("\n" + userID + "," + firstName + "," + lastName);
                w.close();
            }
            catch (Exception e){
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }


        }

        private void updateID() {
            SharedPreferences sharedPreferences = getSharedPreferences("sharedID", MODE_PRIVATE);
            int userID = sharedPreferences.getInt("userID", 0);
            Scanner scan;
            String str = null;
            String[] arr;
            try {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNextLine()) {
                    str = scan.nextLine();
                }
                if (str != null) {
                    arr = str.split(",");
                    if (arr.length == 3) {
                        userID = Integer.parseInt(arr[0]) + 1; //setting user's ID to max+1
                    }
                }
                scan.close();

            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }



            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("userID", userID);
            editor.apply();

        }
    }

