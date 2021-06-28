package com.example.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentStatePagerAdapter;

/**
* Created by MD Minhajul Islam on 6/28/2021.
*/public class DynamicFragmentAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    DynamicFragmentAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    // get the current item with position number
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putInt("position", position);
        Fragment frag = DynamicFragment.newInstance();
        frag.setArguments(b);
        return frag;
    }

    // get total number of tabs
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
