package com.example.practiceapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practiceapp.databinding.ActivityHomeBinding;
import com.example.practiceapp.home.CommunityFragment;
import com.example.practiceapp.home.HomeFragment;
import com.example.practiceapp.home.InfoFragment;
import com.example.practiceapp.home.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavi);

        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new HomeFragment()).commit();

        HomeFragment homeFragment = new HomeFragment();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item1:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new HomeFragment()).commit();
                    return true;
                case R.id.item2:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new CommunityFragment()).commit();
                    return true;
                case R.id.item3:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new SearchFragment()).commit();
                    return true;
                case R.id.item4:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new InfoFragment()).commit();
                    return true;
            }
            return false;
        });
    }
}