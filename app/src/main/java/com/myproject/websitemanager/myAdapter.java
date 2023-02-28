package com.myproject.websitemanager;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.myproject.websitemanager.myinterface.ItemClickedSelected;
import com.myproject.websitemanager.webpage.CommonWebPage;
import com.myproject.websitemanager.webpage.WebPage;
import com.myproject.websitemanager.webpage.WebPageModel;

import java.util.List;


public class myAdapter extends RecyclerView.Adapter<CustomViewHolder>
{
    int row = -1;
    List<WebPageModel> webPageModels;
    private ViewPager2 viewPager2;

    public myAdapter(List<WebPageModel> webPageModels, ViewPager2 viewPager2) {
        this.webPageModels = webPageModels;
        this.viewPager2 = viewPager2;
    }



    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.themeview.setImageResource(webPageModels.get(position).getThemeimage());
        holder.themetext.setText(webPageModels.get(position).getThemename());
        holder.setItemClickedSelected(new ItemClickedSelected() {
            @Override
            public void onClick(View view, int position) {
                row = position;
                CommonWebPage.currentitem = webPageModels.get(position);
                notifyDataSetChanged();

            }
        });
            if(row == position){
                AppCompatActivity activity = (AppCompatActivity)viewPager2.getContext();
                Intent i = new Intent(activity, WebPage.class);
                activity.startActivity(i);
                holder.itemView.setBackgroundResource(R.drawable.layoutsliderbackground);
                holder.themetext.setTextColor(Color.WHITE);


            }
            else{
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                holder.themetext.setTextColor(Color.parseColor("#FFFFFFFF"));

            }
    }

    @Override
    public int getItemCount() {
        return webPageModels.size();
    }
}
class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public ImageView themeview;
    public TextView themetext;
    public ViewPager2 viewPager2;
    ItemClickedSelected itemClickedSelected;

    public void setItemClickedSelected(ItemClickedSelected itemClickedSelected) {
        this.itemClickedSelected = itemClickedSelected;
    }

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        themetext = itemView.findViewById(R.id.themename_id);
        themeview = itemView.findViewById(R.id.layoutslide);
        itemView.setOnClickListener(this);
    }
    /*void settheme(WebPageModel webPageModel){
        themeview.setImageResource(webPageModel.getThemeimage());
        themetext.setText(webPageModel.getThemename());

    }*/

    @Override
    public void onClick(View view) {
        itemClickedSelected.onClick(view,getBindingAdapterPosition());
    }
}