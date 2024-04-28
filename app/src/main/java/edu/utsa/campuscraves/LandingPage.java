package edu.utsa.campuscraves;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.content.res.AssetManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.Scanner;


public class LandingPage extends ComponentActivity{
    private Button button;
    AssetManager assets;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.landing_page);
            assets = getAssets();
            setupButtons();
        }

        public void setupButtons() {
            button = (Button) findViewById(R.id.Enter);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(LandingPage.this, LoginMenu.class);
                    startActivity(intent);
                }
            });
        }
}




