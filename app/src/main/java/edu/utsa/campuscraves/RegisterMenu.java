package edu.utsa.campuscraves;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;

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
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               finish();
            }
        });
    }
}
