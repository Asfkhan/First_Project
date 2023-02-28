package com.myproject.websitemanager.view_webpage;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.myproject.websitemanager.R;

public class View_Webpage extends AppCompatActivity {
    private TextView toptexteditTxt;
    private TextView headingeditText;
    private TextView descrip1editText;
    private TextView description2edit;
    private TextView about_edittxt_variable;
    private TextView contact_us_editxt_var;
    private TextView gmaildedittxt_var;
    private ImageView bannerimg;
    private ImageView post1img;
    private ImageView post2img;

    private TextView instaLinks;

    private TextView twitterLinks;

    private TextView whatsAppLinks;

    private LinearLayout section;


    private LinearLayout linearLayout;
    private CardView layout1,layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_webpage);

        toptexteditTxt = findViewById(R.id.view_topTxt_id);
        headingeditText = findViewById(R.id.view_heading_id);
        linearLayout = findViewById(R.id.view_heading_section_id);
        bannerimg = findViewById(R.id.view_banner_id);
        section = findViewById(R.id.view_table_section_id);
        post1img = findViewById(R.id.view_post1_id);
        layout1 = findViewById(R.id.view_layout1Color);
        descrip1editText = findViewById(R.id.view_description1_id);
        layout2 = findViewById(R.id.view_layout2_color);
        post2img = findViewById(R.id.view_post2_id);
        description2edit = findViewById(R.id.view_description2_id);
        about_edittxt_variable = findViewById(R.id.view_about_us_txt_id);
        contact_us_editxt_var = findViewById(R.id.view_contact_us_txt_id);
        gmaildedittxt_var = findViewById(R.id.view_gmail_txt_id);
        instaLinks = findViewById(R.id.view_insta_id);
        twitterLinks = findViewById(R.id.view_twitter_id);
        whatsAppLinks  = findViewById(R.id.view_whatsapp_id);

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
            instaLinks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url(bundle.getString("Insta"));
                }
            });
            twitterLinks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url(bundle.getString("Twit"));
                }
            });
            whatsAppLinks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url(bundle.getString("Whats"));
                }
            });

        }

    }

    private void url(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}