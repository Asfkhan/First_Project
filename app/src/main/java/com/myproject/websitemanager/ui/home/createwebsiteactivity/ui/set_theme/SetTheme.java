package com.myproject.websitemanager.ui.home.createwebsiteactivity.ui.set_theme;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.myproject.websitemanager.R;
import com.myproject.websitemanager.myAdapter;
import com.myproject.websitemanager.webpage.WebPageModel;

import java.util.ArrayList;
import java.util.List;

public class SetTheme extends Fragment {
    View root;
    Activity selectedactivity;
    List<WebPageModel> webPageModels = new ArrayList<>();
  //  WebPageModel selectedtheme = new WebPageModel();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.set_theme, container, false);
        selectedactivity = getActivity();
        ViewPager2 viewPager2 = root.findViewById(R.id.viewPagerImageSlider);
             webPageModels.add(new WebPageModel(R.drawable.template1,"Helmet Store",true));
            webPageModels.add(new WebPageModel(R.drawable.template2,"Shopping Store",true));
             webPageModels.add(new WebPageModel(R.drawable.template3,"Business Profile",true));
             webPageModels.add(new WebPageModel(R.drawable.template4,"Entertainment Page",true));
           webPageModels.add(new WebPageModel(R.drawable.template5,"PortFolio",true));
            webPageModels.add(new WebPageModel(R.drawable.template6,"NGO Page",true));
            webPageModels.add(new WebPageModel(R.drawable.template7,"Education Page",true));
            webPageModels.add(new WebPageModel(R.drawable.template8,"Profile Page",true));
           webPageModels.add(new WebPageModel(R.drawable.template9,"Retailer Shop",true));
           webPageModels.add(new WebPageModel(R.drawable.template10,"Event Page",true));
          webPageModels.add(new WebPageModel(R.drawable.template11,"Hiring People Page",true));
           webPageModels.add(new WebPageModel(R.drawable.template12,"Album Page",true));
         webPageModels.add(new WebPageModel(R.drawable.template13,"HouseHold",true));
          webPageModels.add(new WebPageModel(R.drawable.template14,"Canteen Menu",true));
         webPageModels.add(new WebPageModel(R.drawable.template15,"Workers Profile",true));
         viewPager2.setAdapter(new myAdapter(webPageModels, viewPager2));

         return root;
         }



         /*  private void getdata()
    {
        for(int i = 0;i<=15;i++)
        {
            WebPageModel selectedtheme = new WebPageModel();
            selectedtheme.setThemename("Helmet Store"+i);
            selectedtheme.setIsclicked(i % 2 == 0);
            webPageModels.add(selectedtheme);
        }
    }
    }*/

  //  private void getdata() {
    //    WebPageModel selectedtheme  = new WebPageModel();
      //  selectedtheme.setThemename("Helmet Store");
       // webPageModels.add(selectedtheme);
   // }
}