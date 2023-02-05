package com.myproject.websitemanager.ui.home.createwebsiteactivity.ui.webpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.myproject.websitemanager.R;
import com.myproject.websitemanager.databinding.FragmentCreateWebpageBinding;

import java.util.ArrayList;
import java.util.List;

public class WebPage extends Fragment {
    View root;
    private FragmentCreateWebpageBinding binding;
    private ViewPager2 viewPager2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreateWebpageBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        viewPager2 = binding.viewPagerImageSlider;
        List<SliderLayoutView> sliderLayoutViews = new ArrayList<>();
        sliderLayoutViews.add(new SliderLayoutView(R.drawable.layoutsliderbackground));
        sliderLayoutViews.add(new SliderLayoutView(R.drawable.layoutsliderbackground));
        sliderLayoutViews.add(new SliderLayoutView(R.drawable.layoutsliderbackground));
        sliderLayoutViews.add(new SliderLayoutView(R.drawable.layoutsliderbackground));
        viewPager2.setAdapter(new sliderLayoutAdapter(sliderLayoutViews,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position) ;
                page.setScaleY(0.15f + r * 0.85f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}