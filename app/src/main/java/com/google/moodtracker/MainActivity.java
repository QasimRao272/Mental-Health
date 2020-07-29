package com.google.moodtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.moodtracker.fragments.FragmentCalender;
import com.google.moodtracker.fragments.FragmentEntries;
import com.google.moodtracker.fragments.FragmentMore;
import com.google.moodtracker.fragments.FragmentStats;

public class MainActivity extends AppCompatActivity {

    ImageView img_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // In Activity's onCreate() for instance
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/

        img_plus = findViewById(R.id.img_plus);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        FragmentEntries frag_name = new FragmentEntries();
        FragmentManager manager = this.getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentcontainer, frag_name, frag_name.getTag()).commit();

        img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WhatHveYouBeenUpToActivity.class);
                startActivity(intent);
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.entries:
                            FragmentEntries fragment_1 = new FragmentEntries();
                            FragmentManager manager = getSupportFragmentManager();
                            manager.beginTransaction().replace(R.id.fragmentcontainer, fragment_1, fragment_1.getTag()).commit();
                            break;
                        case R.id.stats:
                            FragmentStats fragmentStats = new FragmentStats();
                            FragmentManager manager2 = getSupportFragmentManager();
                            manager2.beginTransaction().replace(R.id.fragmentcontainer, fragmentStats, fragmentStats.getTag()).commit();
                            break;
                        case R.id.calendar:
                            FragmentCalender fragmentCalender = new FragmentCalender();
                            FragmentManager manager3 = getSupportFragmentManager();
                            manager3.beginTransaction().replace(R.id.fragmentcontainer, fragmentCalender, fragmentCalender.getTag()).commit();
                            break;
                        case R.id.more:
                            FragmentMore fragmentMore = new FragmentMore();
                            FragmentManager manager4 = getSupportFragmentManager();
                            manager4.beginTransaction().replace(R.id.fragmentcontainer, fragmentMore, fragmentMore.getTag()).commit();
                            break;
                        case R.id.transparant:
                            Intent intent = new Intent(MainActivity.this, WhatHveYouBeenUpToActivity.class);
                            startActivity(intent);
                            break;
                    }
                    return true;
                }
            };

}