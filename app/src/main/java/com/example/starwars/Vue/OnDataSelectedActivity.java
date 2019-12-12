package com.example.starwars.Vue;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.starwars.Controller.TitleDisplayHandler;
import com.example.starwars.Model.Films;
import com.example.starwars.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class OnDataSelectedActivity extends AppCompatActivity {
    private TitleDisplayHandler tdh;
    private ArrayList<Films> films = new ArrayList<>();
    private TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ondataselected);
        TabPageAdapter viewPagerAdapter = new TabPageAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        //this.films = tdh.getResults();


    }
}
