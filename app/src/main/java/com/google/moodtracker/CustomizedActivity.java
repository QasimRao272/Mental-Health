package com.google.moodtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomizedActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mPager;
    private int[] layouts = {R.layout.intro_screen1, R.layout.intro_screen2, R.layout.intro_screen3, R.layout.intro_screen4};
    private MPagerAdapter mPagerAdapter;
    private LinearLayout Dots_layout;
    private ImageView[] dots;
    private Button bnNext;
    private TextView bnkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (new PrefrenceManager(this).checkPrefrence()) {
            loadHome();
        }

        setContentView(R.layout.activity_customized);

        // In Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        mPager = findViewById(R.id.view_pager);
        mPagerAdapter = new MPagerAdapter(layouts, this);
        mPager.setAdapter(mPagerAdapter);

        Dots_layout = findViewById(R.id.dotsLayout);
        bnNext = findViewById(R.id.bnNext);
        bnkip = findViewById(R.id.bnSkip);
        bnkip.setOnClickListener(this);
        bnNext.setOnClickListener(this);

        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int current_position) {
        if (Dots_layout != null) {
            Dots_layout.removeAllViews();

            dots = new ImageView[layouts.length];

            for (int i = 0; i < layouts.length; i++) {

                dots[i] = new ImageView(this);
                if (i == current_position) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
                } else {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
                }
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4, 0, 4, 0);
                Dots_layout.addView(dots[i], params);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bnNext:
                loadNextSlide();
                break;
            case R.id.bnSkip:
                //loadHome();
                backSlide();
                new PrefrenceManager(this).writePrefrence();
                break;
        }
    }

    private void loadHome() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    private void backSlide() {
        int next_slide = mPager.getCurrentItem() - 1;
        if (next_slide < layouts.length) {
            mPager.setCurrentItem(next_slide);
        }
        if (next_slide == 0) {
            bnkip.setVisibility(View.INVISIBLE);
        }
    }

    private void loadNextSlide() {
        int next_slide = mPager.getCurrentItem() + 1;
        bnkip.setVisibility(View.VISIBLE);
        if (next_slide < layouts.length) {
            mPager.setCurrentItem(next_slide);
        } else {
            loadHome();
            new PrefrenceManager(this).writePrefrence();
        }
    }
}