package com.google.moodtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HowAreYouActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBad, imgGood, imgAwful, imgRad, imgMeh;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_are_you);

        SharedPreferences prefs = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String val = prefs.getString("HowAreYou", "No");
        if (val.equals("Yes")) {
            startActivity(new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class));
            finish();
        }

        imgAwful = findViewById(R.id.img_awful);
        imgBad = findViewById(R.id.img_bad);
        imgGood = findViewById(R.id.img_good);
        imgRad = findViewById(R.id.img_rad);
        imgMeh = findViewById(R.id.img_meh);

        imgAwful.setOnClickListener(this);
        imgBad.setOnClickListener(this);
        imgGood.setOnClickListener(this);
        imgRad.setOnClickListener(this);
        imgMeh.setOnClickListener(this);

        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_awful:
                //imgAwful.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.firstColor));
                Intent intent = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent.putExtra("img", "awful");
                editor.putString("HowAreYou", "Yes");
                editor.apply();
                startActivity(intent);
                finish();
                break;
            case R.id.img_bad:
                Intent intent2 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent2.putExtra("img", "bad");
                editor.putString("HowAreYou", "Yes");
                editor.apply();
                startActivity(intent2);
                finish();
                break;
            case R.id.img_good:
                Intent intent3 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent3.putExtra("img", "good");
                editor.putString("HowAreYou", "Yes");
                editor.apply();
                startActivity(intent3);
                finish();
                break;
            case R.id.img_rad:
                Intent intent4 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent4.putExtra("img", "rad");
                editor.putString("HowAreYou", "Yes");
                editor.apply();
                startActivity(intent4);
                finish();
                break;
            case R.id.img_meh:
                Intent intent5 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent5.putExtra("img", "meh");
                editor.putString("HowAreYou", "Yes");
                editor.apply();
                startActivity(intent5);
                finish();
                break;
        }
    }
}
