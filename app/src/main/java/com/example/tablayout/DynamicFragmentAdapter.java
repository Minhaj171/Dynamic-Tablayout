package com.example.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
* Created by MD Minhajul Islam on 6/28/2021.
*/
public class DynamicFragmentAdapter extends FragmentPagerAdapter {
    private int mNumOfTabs;
    TabLayout mTabLayout;
    String[] tabItems;

    DynamicFragmentAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    public void setAdapterAdditionals(TabLayout mTabLayout, String[] tabItems){
        this.mTabLayout = mTabLayout;
        this.tabItems = tabItems;
    }


    // get the current item with position number
    @NonNull
    @Override
    public Fragment getItem(int position) {
//        Bundle b = new Bundle();
//        b.putInt("position", position);
//        Fragment frag = DynamicFragment.newInstance();
//        frag.setArguments(b);
//        return frag;
        String selectedGroup = mTabLayout.getTabAt(position).getText().toString();
        for (String group : tabItems) {
            if (group.equals(selectedGroup)) {
                DynamicFragment dynamicFragment = new DynamicFragment();
                dynamicFragment.setMediaId(group);
                return dynamicFragment;
            }
        }
        return null;
    }

    // get total number of tabs
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
