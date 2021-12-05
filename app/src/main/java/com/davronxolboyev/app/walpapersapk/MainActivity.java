package com.davronxolboyev.app.walpapersapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.davronxolboyev.app.walpapersapk.adapter.FragmentAdapter;
import com.davronxolboyev.app.walpapersapk.fragments.FavouritePage;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tableLayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;
    public static int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout = findViewById(R.id.table_layout);
        pager2 = findViewById(R.id.viewPager2);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);
        tableLayout.addTab(tableLayout.newTab().setText("Offline"));
        tableLayout.addTab(tableLayout.newTab().setText("Online"));
        tableLayout.addTab(tableLayout.newTab().setText("Favourite"));


        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
                k = tab.getPosition();
                Log.d("PAGE : k=", "" + k);
                if (k == 2) FavouritePage.showImages();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tableLayout.selectTab(tableLayout.getTabAt(position));
                k = position;
                if (k == 2) FavouritePage.showImages();
            }
        });
    }

}