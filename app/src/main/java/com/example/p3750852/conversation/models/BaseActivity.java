package com.example.p3750852.conversation.models;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by P3750852 on 2017.08.24..
 */

public class BaseActivity extends Activity{
    public void showToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
