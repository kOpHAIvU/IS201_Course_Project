package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.app.R;
import com.example.app.model.View_Pager_Adapter;
import com.google.android.material.tabs.TabLayout;

public class Activity_Main_Screen extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        /*Intent intent = getIntent();
        String value = intent.getStringExtra("chucvu");*/

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPage);

        tabLayout.setupWithViewPager(viewPager);

        View_Pager_Adapter viewPagerAdapter = new View_Pager_Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new Fragment_Information(), "                  Thông tin                  ");
        viewPagerAdapter.addFragment(new Fragment_Setting(), "                  Cài đặt                  ");
        viewPager.setAdapter(viewPagerAdapter);
    }
}