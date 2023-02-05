package com.myproject.websitemanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder>
{
     MyColorList[] colordata;
    public myAdapter(MyColorList[] colordata) {
        this.colordata = colordata;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infla = LayoutInflater.from(parent.getContext());
        View view = infla.inflate(R.layout.single_row_layout,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        final MyColorList rowdata = colordata[position];
        holder.colorrow.setText(colordata[position].getColorDiscription());
        holder.img.setImageResource(colordata[position].getColorpreview());

    }

    @Override
    public int getItemCount() {
        return colordata.length;
    }

    class holder extends RecyclerView.ViewHolder {
        public LinearLayoutCompat linearLayoutCompat;
        ImageView img;
        TextView colorrow;
        public holder(@NonNull View itemView) {

            super(itemView);
             this.img = itemView.findViewById(R.id.colorimgid);
             this.colorrow = itemView.findViewById(R.id.color_txt_id);
            linearLayoutCompat = itemView.findViewById(R.id.linearlayoutid);
        }
    }
}
