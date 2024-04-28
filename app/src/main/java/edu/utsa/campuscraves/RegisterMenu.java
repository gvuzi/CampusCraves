package edu.utsa.campuscraves;

import android.content.Intent;
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

public class RegisterMenu extends ComponentActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_menu);
        setupButtons();
    }

    public void setupButtons() {
        Button registerButton = (Button) findViewById(R.id.registerButton);
        Button signInButton = (Button) findViewById(R.id.signInButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int id = -1;
                EditText firstNameInput = (EditText) findViewById(R.id.registerFirstName);
                EditText lastNameInput = (EditText) findViewById(R.id.registerLastName);
                EditText usernameInput = (EditText) findViewById(R.id.registerUsername);
                EditText passwordInput = (EditText) findViewById(R.id.registerPassword);

                if (isInputEmpty()) {
                    id = createLogin();
                    if (id > 0) {
                        createAccount(id);
                    }
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



        signInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               finish();
            }
        });
    }

    private boolean isInputEmpty() {
        EditText firstNameInput = (EditText) findViewById(R.id.registerFirstName);
        EditText lastNameInput = (EditText) findViewById(R.id.registerLastName);
        EditText usernameInput = (EditText) findViewById(R.id.registerUsername);
        EditText passwordInput = (EditText) findViewById(R.id.registerPassword);

        return !firstNameInput.getText().toString().isEmpty() && !lastNameInput.getText().toString().isEmpty() &&
                !usernameInput.getText().toString().isEmpty() && !passwordInput.getText().toString().isEmpty();
    }

    private int createLogin() {
        EditText usernameInput = (EditText) findViewById(R.id.registerUsername);
        EditText passwordInput = (EditText) findViewById(R.id.registerPassword);
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        File f = new File(getFilesDir().getAbsolutePath() + "/login.txt");
        OutputStreamWriter w = null;
        Scanner scan;
        int id = -1;
        String str = null;
        String[] arr;

        if (!f.exists()) {
            id = 1;
            try {
                w = new OutputStreamWriter(openFileOutput("login.txt", MODE_PRIVATE));
                w.write(id + "," + username + "," + password);
                w.close();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            try {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNextLine()) {
                    str = scan.nextLine();
                }
                if (str != null) {
                    arr = str.split(",");
                    if (arr.length == 3) {
                        id = Integer.parseInt(arr[0]) + 1;
                    }
                }
                scan.close();

                w = new OutputStreamWriter(openFileOutput("login.txt", MODE_APPEND));
                w.append("\n" + id + "," + username + "," + password);
                w.close();

            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return id;
    }

    private void createAccount(int id) {
        EditText firstNameInput = (EditText) findViewById(R.id.registerFirstName);
        EditText lastNameInput = (EditText) findViewById(R.id.registerLastName);
        String firstName = firstNameInput.getText().toString();
        String lastName = lastNameInput.getText().toString();

        File f = new File(getFilesDir().getAbsolutePath() + "/accounts.txt");
        OutputStreamWriter w = null;

        if (!f.exists()) {
            try {
                w = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_PRIVATE));
                w.write(id + "," + firstName + "," + lastName);
                w.close();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            try {
                w = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_APPEND));
                w.append("\n" + id + "," + firstName + "," + lastName);
                w.close();
            }
            catch(IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }
}
