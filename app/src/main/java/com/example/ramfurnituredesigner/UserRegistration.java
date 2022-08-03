package com.example.ramfurnituredesigner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserRegistration extends AppCompatActivity {

    EditText personName , EmailId , PhoneNumber , PersonAddress , PersonPassword;
    ImageView PersonImage;
    ImageButton UploadPersonImage;
    Button RegisterUser;
    private final int Request_Code = 200;
    private final String[] Permission = {

            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE

    };
    Uri OutputFile;

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



                AskPermission();


            }
        });




    }

    private void AskPermission() {

        if(ContextCompat.checkSelfPermission(this , Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, Permission,Request_Code);

        }else{
            Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,Request_Code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Request_Code) {
            if (grantResults.length < 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED) {

                Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,requestCode);

            } else {




            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




            if(requestCode == Request_Code){
                Bitmap img = (Bitmap) data.getExtras().get("data");
                PersonImage.setImageBitmap(img);
            }



    }
}