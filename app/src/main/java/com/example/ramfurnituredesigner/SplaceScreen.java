package com.example.ramfurnituredesigner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

public class SplaceScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splace_screen);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Thread thread = new Thread(){
            public  void run(){
                try {

                    sleep(4000);

                }catch (Exception e){
                            e.getStackTrace();
                }finally{
                    Intent intent = new Intent(SplaceScreen.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}