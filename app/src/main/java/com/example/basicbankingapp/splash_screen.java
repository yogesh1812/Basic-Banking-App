package com.example.basicbankingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends Activity {

    TextView designed, name, app_name;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        logo = findViewById(R.id.logo);
        designed = findViewById(R.id.designed);
        name = findViewById(R.id.name);
        app_name = findViewById(R.id.app_name);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startEnterAnimation();
            }
        }, 100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }, 3500);
    }

    private void startEnterAnimation() {
        logo.setVisibility(View.VISIBLE);
        designed.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        app_name.setVisibility(View.VISIBLE);
    }
}

