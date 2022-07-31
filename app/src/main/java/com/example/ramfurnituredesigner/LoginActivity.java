package com.example.ramfurnituredesigner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button  button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Loock Screen Rotaion
        getSupportActionBar().hide(); // Hiding Action Bar

        button = findViewById(R.id.Login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this , UserRegistration.class));
            }
        });

    }
}