package com.myproject.websitemanager.saved_user_adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.websitemanager.MainActivity;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.signup_page.SavedUserImages;

import java.util.List;

public class SavedUserAdapter extends RecyclerView.Adapter<SavedUserAdapter.UserHolder>{
    Context context;
    List<SavedUserImages> savedUserImagesList;
    int row = -1;

    public SavedUserAdapter(Context context, List<SavedUserImages> savedUserImagesList) {
        this.context = context;
        this.savedUserImagesList = savedUserImagesList;
    }

    @NonNull
        @Override
        public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_header_main,parent,false);
            return new UserHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UserHolder holder, int position) {
            if(row == position){
                Intent i = new Intent(context, MainActivity.class);
           //     i.putExtra("UserIMG",savedUserImagesList.get(holder.getAdapterPosition()).getUserimg());
                //   i.putExtra("UserName",savedUserImagesList.get(holder.getPosition()).getUserName());
                context.startActivity(i);
            }
        }

        @Override
        public int getItemCount() {
            return savedUserImagesList.size();
        }

        static class UserHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView user;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.userimg_id);
            user = itemView.findViewById(R.id.userName_id);
        }
    }
}
