package com.myproject.websitemanager.view_webpage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myproject.websitemanager.DataStoredClass;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.myinterface.ItemClickedSelected;

import java.util.List;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.SliderViewHolder>
{
   private final Context context;
   private int row = -1;
   private final List<DataStoredClass> storedClassList;

    public LayoutAdapter(Context context, List<DataStoredClass> storedClassList) {
        this.context = context;
        this.storedClassList = storedClassList;
    }


    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row_layout,parent,false);
        return new SliderViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        Glide.with(context).load(storedClassList.get(position).getBannerimg()).into(holder.imageview);
        holder.textView.setText(storedClassList.get(position).getGmaildedittxt_var());

        holder.setItemClickedSelected((view, position1) -> {
            row = position1;
            notifyItemChanged(position);
        });
        if(row == position){
                    Intent i = new Intent(context, View_Webpage.class);
                    i.putExtra("TopText",storedClassList.get(holder.getAdapterPosition()).getToptexteditTxt());
                    i.putExtra("Head",storedClassList.get(holder.getAdapterPosition()).getHeadingeditText());
                    i.putExtra("HeadingSize",storedClassList.get(holder.getAdapterPosition()).getHeadingfontSize());
                    i.putExtra("HeadingColor",storedClassList.get(holder.getAdapterPosition()).getHeadingTextColor());
                    i.putExtra("HeadingSectionColor",storedClassList.get(holder.getAdapterPosition()).getHeadingSectionColor());
                    i.putExtra("BannerImg",storedClassList.get(holder.getAdapterPosition()).getBannerimg());
                    i.putExtra("TableSectionColor",storedClassList.get(holder.getAdapterPosition()).getTableSectionColor());
                    i.putExtra("Post1",storedClassList.get(holder.getAdapterPosition()).getPost1img());
                    i.putExtra("Layout1Color",storedClassList.get(holder.getAdapterPosition()).getLayout1Color());
                    i.putExtra("Description1",storedClassList.get(holder.getAdapterPosition()).getDescripeditText());
                    i.putExtra("Post2",storedClassList.get(holder.getAdapterPosition()).getPost2img());
                    i.putExtra("Layout2Color",storedClassList.get(holder.getAdapterPosition()).getLayout2Color());
                    i.putExtra("Description2",storedClassList.get(holder.getAdapterPosition()).getDescription2edit());
                    i.putExtra("AboutUs",storedClassList.get(holder.getAdapterPosition()).getAbout_edittxt_variable());
                    i.putExtra("ContactUs",storedClassList.get(holder.getAdapterPosition()).getContact_us_editxt_var());
                    i.putExtra("Gmail",storedClassList.get(holder.getAdapterPosition()).getGmaildedittxt_var());
                    i.putExtra("Insta",storedClassList.get(holder.getAdapterPosition()).getInstaLinks());
                    i.putExtra("Twit",storedClassList.get(holder.getAdapterPosition()).getTwitterLinks());
                    i.putExtra("Whats",storedClassList.get(holder.getAdapterPosition()).getWhatsAppLinks());
                    context.startActivity(i);
            holder.itemView.setBackgroundResource(R.drawable.layoutsliderbackground);
        }
        else{
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }

    }

    @Override
    public int getItemCount() {
        return storedClassList.size();
    }

    static class SliderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private final ImageView imageview;
        private final TextView textView;

        ItemClickedSelected itemClickedSelected;

        public void setItemClickedSelected(ItemClickedSelected itemClickedSelected) {
            this.itemClickedSelected = itemClickedSelected;
        }




        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.generated_page_img_id);
            textView = itemView.findViewById(R.id.page_title_id);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            itemClickedSelected.onClick(v,getBindingAdapterPosition());
        }
    }

}
