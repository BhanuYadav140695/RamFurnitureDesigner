package com.example.ramfurnituredesigner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class UserRegistration extends AppCompatActivity {

    EditText personName , EmailId , PhoneNumber , PersonAddress , PersonPassword;
    ImageView PersonImage;
    ImageButton UploadPersonImage;
    Button RegisterUser;
    private final int CamerarequestCode = 200 , gallaryrequestCode = 300;

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

        UploadPersonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CamerarequestCode);

            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == CamerarequestCode){
                Bitmap img = (Bitmap) (data.getExtras().get("Data"));
                PersonImage.setImageBitmap(img);
            }
        }

    }
}