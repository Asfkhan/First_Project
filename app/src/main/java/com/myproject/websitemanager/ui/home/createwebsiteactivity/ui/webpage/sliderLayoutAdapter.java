package com.myproject.websitemanager.ui.home.createwebsiteactivity.ui.webpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.myproject.websitemanager.R;

import java.util.List;

public class sliderLayoutAdapter extends RecyclerView.Adapter<sliderLayoutAdapter.SliderViewHolder>
{
    private List<SliderLayoutView> sliderLayout;
    private ViewPager2 viewPager2;

    sliderLayoutAdapter(List<SliderLayoutView> sliderLayout, ViewPager2 viewPager2) {
        this.sliderLayout = sliderLayout;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(

                LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_layout_container,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setLayoutview(sliderLayout.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderLayout.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView layoutview;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutview = itemView.findViewById(R.id.layoutslide);
        }
        void setLayoutview(SliderLayoutView sliderLayoutView){
            layoutview.setImageResource(sliderLayoutView.getCanvaslayout());
        }
    }

}
