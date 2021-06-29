package com.example.tablayout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DynamicFragment extends Fragment {
    String name;

    public static DynamicFragment newInstance() {
        return new DynamicFragment();
    }

    // adding the layout with inflater
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
//        initViews(view);
        return view;
    }

    // initialise the categories
//    private void initViews(View view) {
//        TextView textView = view.findViewById(R.id.commonTextView);
//        if(getArguments() != null){
//            textView.setText(String.valueOf("Category :  " + getArguments().getInt("position")));
//        }
//    }

    public void setMediaId(String tab) {
        this.name = name;
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//    }
//
//    // pause function call
//    @Override
//    public void onPause() {
//        super.onPause();
//    }
//
//    // resume function call
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//    // stop when we close
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
//
//    // destroy the view
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
}