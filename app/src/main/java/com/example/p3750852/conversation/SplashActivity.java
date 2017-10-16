package com.example.p3750852.conversation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.p3750852.conversation.models.Login;

/**
 * Created by P3750852 on 2017.08.24..
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SharedPreferences s = getApplicationContext().getSharedPreferences(Login.emailAd, MODE_PRIVATE);
        String email = s.getString(Login.emailAddress, "");
        if (email.equals("")) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        } else {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }
    }
}
