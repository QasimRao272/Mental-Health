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
import android.widget.Button;

public class HelpUsImprove extends AppCompatActivity {

    Button btn_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String val = prefs.getString("help_us_improve", "No");
        if (val.equals("Yes")) {
            startActivity(new Intent(getApplicationContext(), CustomizedActivity.class));
            finish();
        }

        setContentView(R.layout.activity_help_us_improve);
        btn_agree = findViewById(R.id.btn_agree);

        // In Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("help_us_improve", "Yes");
                editor.apply();

                Intent intent = new Intent(HelpUsImprove.this, CustomizedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
