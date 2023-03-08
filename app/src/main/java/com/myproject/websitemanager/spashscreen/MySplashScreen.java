package com.myproject.websitemanager.spashscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.myproject.websitemanager.R;
import com.myproject.websitemanager.login_page.LoginPage;

@SuppressLint("CustomSplashScreen")
public class MySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        try {
            Handler handler = new Handler();
            handler.postDelayed(() -> startActivity(new Intent(getApplicationContext(), LoginPage.class)),1000);
        }catch (Exception e){
            Toast.makeText(this, " " + e, Toast.LENGTH_SHORT).show();
        }
        }

}