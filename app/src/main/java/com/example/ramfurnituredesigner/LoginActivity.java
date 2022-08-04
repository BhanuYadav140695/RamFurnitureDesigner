package com.example.ramfurnituredesigner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText userName , PassCode;
    Button  button;
    private FirebaseAuth mAuth;
    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Loock Screen Rotaion
        getSupportActionBar().hide(); // Hiding Action Bar

        mAuth = FirebaseAuth.getInstance();



        button = findViewById(R.id.Login);
        userName = findViewById(R.id.User_Name);
        PassCode = findViewById(R.id.pascode);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               LoginUser();
            }
        });



    }

    private void LoginUser() {
        String Email = userName.getText().toString().trim();
        String passcode = PassCode.getText().toString().trim();


        if(!TextUtils.isEmpty(Email) || !TextUtils.isEmpty(passcode)){

            mAuth.signInWithEmailAndPassword(Email  , passcode)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            startActivity(new Intent(LoginActivity.this , MainActivity.class));
                            finish();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });


            Toast.makeText(getApplicationContext(), Email+" "+passcode, Toast.LENGTH_SHORT).show();

        }else{
            userName.setError("These field should not be Empty:");
            PassCode.setError("These field should not be Empty");
        }

    }
}