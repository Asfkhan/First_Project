package com.myproject.websitemanager.ui.home.createwebsiteactivity.ui.create_color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.websitemanager.R;
import com.myproject.websitemanager.webpage.CommonWebPage;

import java.util.List;

public class CreateColorAdapter extends RecyclerView.Adapter<Myholder> {
    int row = 1;
    ScrollView color;
    List<CreateColorModel> createColorModel;

    public CreateColorAdapter(ScrollView color, List<CreateColorModel> createColorModel) {
        this.color = color;
        this.createColorModel = createColorModel;
    }


    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myholder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.webpage,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.scrllbgcolor(createColorModel.get(position));
                CommonWebPage.backgroundcolor = createColorModel.get(position);
                notifyDataSetChanged();
            }

    @Override
    public int getItemCount() {
        return createColorModel.size();
    }
}
    class Myholder extends RecyclerView.ViewHolder {
        ScrollView colors;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            colors = itemView.findViewById(R.id.webpage_scroll_background_id);
        }
        void scrllbgcolor(CreateColorModel createColorModel){
            colors.setBackgroundColor(createColorModel.getScrollviewbackgroundcolor());
        }
    }



