package com.google.moodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class LanguageActivity extends AppCompatActivity {
    ImageView image_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String val = prefs.getString("language_activity", "No");
        if (val.equals("Yes")) {
            startActivity(new Intent(getApplicationContext(), HelpUsImprove.class));
            finish();
        }

        setContentView(R.layout.activity_language);

        // In Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        image_next = findViewById(R.id.image_next);
        image_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("language_activity", "Yes");
                editor.apply();

                startActivity(new Intent(getApplicationContext(), HelpUsImprove.class));
                finish();
            }
        });
    }
}
