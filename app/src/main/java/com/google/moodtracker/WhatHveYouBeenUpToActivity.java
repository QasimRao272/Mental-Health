package com.google.moodtracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WhatHveYouBeenUpToActivity extends AppCompatActivity {
    String img;
    ImageView imgEmoji, btn_save, arow_left;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_have_you_been_upto);

        SharedPreferences prefs = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String val = prefs.getString("WhatHaveYouBeenUpTo", "No");
        /*if (val.equals("Yes")) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }*/

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }*/

        imgEmoji = findViewById(R.id.imgEmoji);
        btn_save = findViewById(R.id.btn_save);
        arow_left = findViewById(R.id.arow_left);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
       // editor = pref.edit();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WhatHveYouBeenUpToActivity.this, MainActivity.class);
               // editor.putString("WhatHaveYouBeenUpTo", "Yes");
               // editor.apply();
                startActivity(intent);
                finish();
            }
        });

        arow_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WhatHveYouBeenUpToActivity.this, HowAreYouActivity.class);
                startActivity(intent);
            }
        });

        img = getIntent().getStringExtra("img");

        if (img != null) {
            if (img.equals("awful")) {
                imgEmoji.setImageResource(R.mipmap.awful);
            } else if (img.equals("bad")) {
                imgEmoji.setImageResource(R.mipmap.sad);

            } else if (img.equals("good")) {
                imgEmoji.setImageResource(R.mipmap.good);

            } else if (img.equals("rad")) {
                imgEmoji.setImageResource(R.mipmap.rad);

            } else if (img.equals("meh")) {
                imgEmoji.setImageResource(R.mipmap.meh);

            }
        }
    }
}
