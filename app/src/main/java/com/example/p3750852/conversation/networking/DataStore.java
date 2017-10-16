package com.example.p3750852.conversation.networking;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by P3750852 on 2017.08.10..
 */

public class DataStore {
    static SharedPreferences prefs;

    public static void init (Context context) {
        prefs = context.getSharedPreferences("pingPrefs", Context.MODE_PRIVATE);
    }

    public void saveToken (String token) {
        prefs.edit().putString("token", token).apply();

    }

    public String getToken () {
        return prefs.getString("token", null);
    }
}
