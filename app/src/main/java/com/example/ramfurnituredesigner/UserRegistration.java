package com.example.ramfurnituredesigner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class UserRegistration extends AppCompatActivity {

    EditText personName , EmailId , PhoneNumber , PersonAddress , PersonPassword;
    ImageView PersonImage;
    ImageButton UploadPersonImage;
    Button RegisterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Loock Screen Rotaion
        getSupportActionBar().hide(); // Hiding Action Bar

        personName = findViewById(R.id.PersonName);
        EmailId = findViewById(R.id.EmailAddress);
        PhoneNumber = findViewById(R.id.editTextPhone);
        PersonAddress = findViewById(R.id.editTextTextPostalAddress);
        PersonPassword = findViewById(R.id.editTextTextPassword);
        PersonImage = findViewById(R.id.UserPhoto);
        UploadPersonImage = findViewById(R.id.imageButton);
        RegisterUser = findViewById(R.id.SignIn);





    }
}