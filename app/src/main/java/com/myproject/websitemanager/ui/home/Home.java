package com.myproject.websitemanager.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.myproject.websitemanager.R;
import com.myproject.websitemanager.ui.home.createwebsiteactivity.CreateWebsite;
import com.myproject.websitemanager.view_main_activity.View_MainActivity;


public class Home extends Fragment {

    Activity customizelayoutactivity;
    View view;
    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        Button create =customizelayoutactivity.findViewById(R.id.createwebsiteid);
        create.setOnClickListener(view -> {
            Intent create1 = new Intent(getActivity(), CreateWebsite.class);
            startActivity(create1);
            customizelayoutactivity.finish();
        });
        Button viewWebpage =customizelayoutactivity.findViewById(R.id.webpage2_view_btn_id);
        viewWebpage.setOnClickListener(view -> {
            Intent viewwebpage = new Intent(getActivity(), View_MainActivity.class);
            startActivity(viewwebpage);
            customizelayoutactivity.finish();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       customizelayoutactivity = getActivity();
        view = inflater.inflate(R.layout.fragment_home2, container, false);
        return view;

    }
}