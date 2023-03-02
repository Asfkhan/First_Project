package com.myproject.websitemanager.webpage2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.myproject.websitemanager.R;
import com.myproject.websitemanager.view_main_activity.View_MainActivity;

public class WebPage2 extends AppCompatActivity {

    public WebPage2() {
    }

    public WebPage2(int contentLayoutId) {
        super(contentLayoutId);
    }

    public TextView getNewheading() {
        return newheading;
    }

    LinearLayout headingSectionLayout;
    Intent intent;
    LinearLayout linearLayout;
    ImageView newbanner,newpost1,newpost2;
    TextView newheading,description1,description2,newAboutUs,newContact,newGmail,newInsta,newTwitter,newWhatsapp;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Save Changes")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    Intent iback = new Intent(WebPage2.this, View_MainActivity.class);
                    startActivity(iback);
                }).setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.cancel());
        builder.create();
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webpage2);
        newbanner = findViewById(R.id.newBanner_id);
        newpost1 = findViewById(R.id.post1_id);
        newpost2 = findViewById(R.id.post2_id);
        newheading = findViewById(R.id.webpage2heading_id);
        linearLayout = findViewById(R.id.show_hidden_layout_WebPage2_id);
       // layoutinflated();
            Bundle bundle = getIntent().getExtras();
            String value = bundle.getString("topText");
            TextView newtoptext = findViewById(R.id.toptext_webpage2_id);
            newtoptext.setSelected(true);
            newtoptext.setText(value);


              Intent intent1 = getIntent();
                String headingvalue = intent1.getStringExtra("Heading");
                  newheading.setText(headingvalue);

                Bundle headBundle = getIntent().getExtras();
                int headindSize = headBundle.getInt("HeadingSize");
                newheading.setTextSize(headindSize);

                Bundle headcolorBundle = getIntent().getExtras();
                int headingcolor = headcolorBundle.getInt("HeadingColor");
                newheading.setTextColor(headingcolor);

        Bundle headSectioncolorBundle = getIntent().getExtras();
        int headingSectioncolor = headSectioncolorBundle.getInt("HeadingSectionColor");
        headingSectionLayout = findViewById(R.id.webpage2_heading_section_id);
        headingSectionLayout.setBackgroundColor(headingSectioncolor);

        Bundle tableSectioncolorBundle = getIntent().getExtras();
        int tableSectioncolor = tableSectioncolorBundle.getInt("TableSectionColor");
        LinearLayout tableLayout = findViewById(R.id.new_Webpage_TableSection_id);
        tableLayout.setBackgroundColor(tableSectioncolor);


        Bundle webpage2SectionColorBundle = getIntent().getExtras();
        int newlayout1Color = webpage2SectionColorBundle.getInt("Layout1Color");
        CardView layout1 = findViewById(R.id.section1_id);
        layout1.setBackgroundColor(newlayout1Color);

        Bundle webpage2Section2ColorBundle = getIntent().getExtras();
        int newlayout2Color = webpage2Section2ColorBundle.getInt("Layout2Color");
        CardView layout2 = findViewById(R.id.section2_id);
        layout2.setBackgroundColor(newlayout2Color);

        intent = getIntent();
        Uri uri1 = intent.getParcelableExtra("BannerIMG");
        newbanner.setImageURI(uri1);

        intent = getIntent();
        Uri uri2 = intent.getParcelableExtra("POST1");
        newpost1.setImageURI(uri2);

        Bundle dp1bundle = getIntent().getExtras();
        description1 = findViewById(R.id.newDescription1_id);
        String newdp1value = dp1bundle.getString("DESC1");
        description1.setText(newdp1value);


        intent = getIntent();
        Uri uri3 = intent.getParcelableExtra("POST2");
        newpost2.setImageURI(uri3);

        Bundle dp2Bundle = getIntent().getExtras();
        description2 = findViewById(R.id.newDescription2_id);
        String newdp2value = dp2Bundle.getString("DESC2");
        description2.setText(newdp2value);

        Bundle abouusBundle = getIntent().getExtras();
        newAboutUs = findViewById(R.id.new_about_us_id);
        String newAboutuSvalue = abouusBundle.getString("AboutUs");
        newAboutUs.setText(newAboutuSvalue);

        Bundle contactBundle = getIntent().getExtras();
        newContact = findViewById(R.id.new_contact_id);
        String newContactValue = contactBundle.getString("ContactUs");
        newContact.setText(newContactValue);

        Bundle gmailBundle = getIntent().getExtras();
        newGmail = findViewById(R.id.new_gmail_id);
        String newGmailValue = gmailBundle.getString("Gmail");
        newGmail.setText(newGmailValue);

        Bundle instaBundle = getIntent().getExtras();
        newInsta = findViewById(R.id.new_Insta_link_id);
        String newInstaValue = instaBundle.getString("Instagram");
        newInsta.setText(newInstaValue);

        Bundle twitterBundle = getIntent().getExtras();
        newTwitter = findViewById(R.id.new_twitter_link_id);
        String newTwitterValue = twitterBundle.getString("Twitter");
        newTwitter.setText(newTwitterValue);

        Bundle whatsappBundle = getIntent().getExtras();
        newWhatsapp = findViewById(R.id.new_whatsapp_link_id);
        String newWhatsappValue = whatsappBundle.getString("Whatsapp");
        newWhatsapp.setText(newWhatsappValue);


    }

   /* private void layoutinflated() {
        View view1 = getLayoutInflater().inflate(R.layout.webpage,findViewById(R.id.show_hidden_layout_id));
        TextView txtFont = view1.findViewById(R.id.webpage1Themefont);
        WebPage webPage = new WebPage();
        Typeface typeface = webPage.getHeadtext().getTypeface();
        txtFont.setTypeface(typeface);
        newheading.setText(txtFont.getText());
    }*/


}