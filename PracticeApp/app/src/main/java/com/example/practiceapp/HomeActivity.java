package com.example.practiceapp.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practiceapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity  {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new HomeFragment()).commit();

        HomeFragment homeFragment = new HomeFragment();

        binding.bottomNavi.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case :
                    getSupportFragmentManager().beginTransaction().replace(R
                            .id.main_frame, homeFragment).commit();
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