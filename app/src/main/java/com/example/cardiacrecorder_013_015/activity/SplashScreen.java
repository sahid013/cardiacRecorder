package com.example.cardiacrecorder_013_015.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardiacrecorder_013_015.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //This is splash screen will shown up for 2sec after launching the app
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, com.example.cardiacrecorder_013_015.activity.MainActivity.class));
            finish();
        }, 2000);
    }
}