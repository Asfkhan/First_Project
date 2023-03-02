package com.myproject.websitemanager.view_webpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.myproject.websitemanager.R;

public class View_Webpage extends AppCompatActivity {

AlertDialog myalertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_webpage);
        TextView toptexteditTxt = findViewById(R.id.view_topTxt_id);
        TextView headingeditText = findViewById(R.id.view_heading_id);
        LinearLayout linearLayout = findViewById(R.id.view_heading_section_id);
        ImageView bannerimg = findViewById(R.id.view_banner_id);
        LinearLayout section = findViewById(R.id.view_table_section_id);
        ImageView post1img = findViewById(R.id.view_post1_id);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout layout1 = findViewById(R.id.view_layout1Color);
        TextView descrip1editText = findViewById(R.id.view_description1_id);
        LinearLayout layout2 = findViewById(R.id.view_layout2_color);
        ImageView post2img = findViewById(R.id.view_post2_id);
        TextView description2edit = findViewById(R.id.view_description2_id);
        TextView about_edittxt_variable = findViewById(R.id.view_about_us_txt_id);
        TextView contact_us_editxt_var = findViewById(R.id.view_contact_us_txt_id);
        TextView gmaildedittxt_var = findViewById(R.id.view_gmail_txt_id);
        TextView instaLinks = findViewById(R.id.view_insta_id);
        TextView twitterLinks = findViewById(R.id.view_twitter_id);
        TextView whatsAppLinks = findViewById(R.id.view_whatsapp_id);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            toptexteditTxt.setSelected(true);
            toptexteditTxt.setText(bundle.getString("TopText"));
            headingeditText.setText(bundle.getString("Head"));
          //  headingeditText.setTypeface(tf,Integer.parseInt(bundle.getString("HeadingFont")));
            headingeditText.setTextSize(Integer.parseInt(bundle.getString("HeadingSize")));
            headingeditText.setTextColor(Integer.parseInt(bundle.getString("HeadingColor")));
            linearLayout.setBackgroundColor(Integer.parseInt(bundle.getString("HeadingSectionColor")));
            Glide.with(this).load(bundle.getString("BannerImg")).into(bannerimg);
            Glide.with(this).load(bundle.getString("Post1")).into(post1img);
            section.setBackgroundColor(Integer.parseInt(bundle.getString("TableSectionColor")));
            layout1.setBackgroundColor(Integer.parseInt(bundle.getString("Layout1Color")));
            layout2.setBackgroundColor(Integer.parseInt(bundle.getString("Layout2Color")));
            descrip1editText.setText(bundle.getString("Description1"));
            Glide.with(this).load(bundle.getString("Post2")).into(post2img);
            description2edit.setText(bundle.getString("Description2"));
            about_edittxt_variable.setText(bundle.getString("AboutUs"));
            contact_us_editxt_var.setText(bundle.getString("ContactUs"));
            gmaildedittxt_var.setText(bundle.getString("Gmail"));
            instaLinks.setOnClickListener(v -> url(bundle.getString("Insta")));
            twitterLinks.setOnClickListener(v -> url(bundle.getString("Twit")));
            whatsAppLinks.setOnClickListener(v -> url(bundle.getString("Whats")));

        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(View_Webpage.this);
        View mview = getLayoutInflater().inflate(R.layout.dialog_website_manage,findViewById(R.id.spinner2));
        // = mview.findViewById(R.id.heading_edit_id);
        builder.setView(mview);
        builder.setTitle("Your Heading Text")
                .setPositiveButton("Done", (dialogInterface, i) -> dialogInterface.dismiss());
        myalertDialog = builder.create();
        myalertDialog.show();
        super.onBackPressed();
    }

    private void url(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}