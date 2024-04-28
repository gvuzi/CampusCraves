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
import java.util.Scanner;

public class LoginMenu extends ComponentActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_menu);
        setupButtons();
    }

    public void setupButtons() {
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button registerButton = (Button) findViewById(R.id.registerNewAccount);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText usernameInput = (EditText) findViewById(R.id.loginUsername);
                EditText passwordInput = (EditText) findViewById(R.id.loginPassword);
                int id = authenticate(usernameInput.getText().toString(), passwordInput.getText().toString());
                if (id > 0) {
                    Toast.makeText(getBaseContext(), "account is registered", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(LoginMenu.this, ProfileActivity.class);
                    //intent.putExtra("id", id);
                    //startActivity(intent);
                } else {
                    usernameInput.setText("");
                    passwordInput.setText("");
                    usernameInput.setError("Incorrect username and password combination.");
                    passwordInput.setError("Incorrect username and password combination.");
                }
            }

        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(LoginMenu.this, RegisterMenu.class);
                    startActivity(intent);
            }
        });
    }

    private int authenticate(String username, String password) {
        Scanner scan;
        String str = "";
        String[] userInfo = null;
        boolean authenticated = false;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath() + "/login.txt");

        try {
            if(f.exists()) {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    userInfo = str.split(",");
                    if (username.equalsIgnoreCase(userInfo[1]) && password.equals(userInfo[2])) {
                        authenticated = true;
                        id = Integer.parseInt(userInfo[0]);
                        break;
                    }
                }
                scan.close();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        return id;
    }
}
