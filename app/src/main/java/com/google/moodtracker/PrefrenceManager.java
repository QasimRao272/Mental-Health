package com.google.moodtracker;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefrenceManager {
    SharedPreferences sharedPreferences;
    Context context;

    private static final String FIRST_LAUNCH = "firstLaunch";
    int MODE = 0;
    private static final String PREFERENCE = "Javapapers";

    public PrefrenceManager(Context context) {

        this.context = context;
        getSharedPrefrence();
    }

    private void getSharedPrefrence() {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.my_prefrence), Context.MODE_PRIVATE);
    }

    public void writePrefrence() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_prefrence_key), "INIT_OK");
        editor.commit();
    }

    public boolean checkPrefrence() {
        boolean status = false;
        if (sharedPreferences.getString(context.getString(R.string.my_prefrence_key), "null").equals("null")) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }

    public void clearPrefrence() {
        sharedPreferences.edit().clear().commit();
    }
}







