package com.google.moodtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.moodtracker.fragments.FragmentCalender;
import com.google.moodtracker.fragments.FragmentEntries;
import com.google.moodtracker.fragments.FragmentMore;
import com.google.moodtracker.fragments.FragmentStats;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_calender;
    //private TextView tvEntries, tvCalender, tvMore, tvStats;
    TextView txt_calender;

    private LinearLayout tvEntries, tvCalender, tvMore, tvStats;
    FloatingActionButton fab_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/

        /* img_plus = findViewById(R.id.img_plus);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);*/

        FragmentEntries frag_name = new FragmentEntries();
        FragmentManager manager = this.getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentcontainer, frag_name, frag_name.getTag()).commit();

        img_calender = findViewById(R.id.img_calender);
        tvEntries = findViewById(R.id.tvEntries);
        tvCalender = findViewById(R.id.tvCalender);
        tvMore = findViewById(R.id.tvMore);
        tvStats = findViewById(R.id.tvStats);
        fab_plus = findViewById(R.id.fab_plus);
        txt_calender = findViewById(R.id.txt_calender);

        img_calender.setOnClickListener(this);
        tvEntries.setOnClickListener(this);
        tvCalender.setOnClickListener(this);
        tvMore.setOnClickListener(this);
        tvStats.setOnClickListener(this);
        fab_plus.setOnClickListener(this);
        txt_calender.setOnClickListener(this);

        /*img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WhatHveYouBeenUpToActivity.class);
                startActivity(intent);
            }
        });*/



    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvEntries:
                FragmentEntries fragment_1 = new FragmentEntries();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragmentcontainer, fragment_1, fragment_1.getTag()).commit();
                break;

            case R.id.tvStats:
                FragmentStats fragmentStats = new FragmentStats();
                FragmentManager manager2 = getSupportFragmentManager();
                manager2.beginTransaction().replace(R.id.fragmentcontainer, fragmentStats, fragmentStats.getTag()).commit();
                break;

            case R.id.tvCalender:

                break;

            case R.id.tvMore:
                FragmentMore fragmentMore = new FragmentMore();
                FragmentManager manager4 = getSupportFragmentManager();
                manager4.beginTransaction().replace(R.id.fragmentcontainer, fragmentMore, fragmentMore.getTag()).commit();
                break;

            case R.id.fab_plus:
                Intent intent = new Intent(MainActivity.this, HowAreYouActivity.class);
                startActivity(intent);
                break;

            case R.id.img_calender:
                FragmentCalender fragmentCalender = new FragmentCalender();
                FragmentManager manager3 = getSupportFragmentManager();
                manager3.beginTransaction().replace(R.id.fragmentcontainer, fragmentCalender, fragmentCalender.getTag()).commit();
                break;

            case R.id.txt_calender:
                FragmentCalender fragmentCalender5 = new FragmentCalender();
                FragmentManager manager5 = getSupportFragmentManager();
                manager5.beginTransaction().replace(R.id.fragmentcontainer, fragmentCalender5, fragmentCalender5.getTag()).commit();
                break;
        }
    }

    /*private BottomNavigationView.OnNavigationItemSelectedListener navListener =
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
            };*/

}