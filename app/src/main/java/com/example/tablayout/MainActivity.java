package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout mTabLayout;
    String[] tabItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


    }

    private void initViews() {
        // initialise the layout
        viewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tabs);
        // setOffscreenPageLimit means number
        // of tabs to be shown in one page
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // setCurrentItem as the tab position
                viewPager.setCurrentItem(tab.getPosition());
//                Toast.makeText(getApplicationContext(), "Fuck off",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setDynamicFragmentToTabLayout();
    }

    private void setDynamicFragmentToTabLayout() {
        tabItems = getResources().getStringArray(R.array.tabItem);
        // here we have given 10 as the tab number
        // you can give any number here
        for (String tab : tabItems) {
            // set the tab name as "Page: " + i
            mTabLayout.addTab(mTabLayout.newTab().setText(tab));
        }
        DynamicFragmentAdapter mDynamicFragmentAdapter = new DynamicFragmentAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mDynamicFragmentAdapter.setAdapterAdditionals(mTabLayout, tabItems);

        // set the adapter
        viewPager.setAdapter(mDynamicFragmentAdapter);
        // set the current item as 0 (when app opens for first time)
        viewPager.setCurrentItem(0);


    }
}