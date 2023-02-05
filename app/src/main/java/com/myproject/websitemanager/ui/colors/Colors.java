package com.myproject.websitemanager.ui.colors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.myproject.websitemanager.R;
import com.myproject.websitemanager.color_opt_activity.Color_opt_activity;


public class Colors extends Fragment {

View view;
Activity aage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        aage = getActivity();
        view =  inflater.inflate(R.layout.fragment_colors, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btn = aage.findViewById(R.id.coloractivityid);
        btn.setOnClickListener(view -> {
            Intent aagechl = new Intent(aage,Color_opt_activity.class);
            startActivity(aagechl);
        });
    }
}