package edu.utsa.campuscraves;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;

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
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(LoginMenu.this, RegisterMenu.class);
                    startActivity(intent);
            }
        });
    }
}
