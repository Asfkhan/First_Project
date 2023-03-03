package com.myproject.websitemanager.webpage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.myproject.websitemanager.DataStoredClass;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.ui.home.createwebsiteactivity.CreateWebsite;
import com.myproject.websitemanager.webpage2.WebPage2;

import yuku.ambilwarna.AmbilWarnaDialog;

public class WebPage extends AppCompatActivity {
    private TextView headtext,font_no,toptextview;
    private ScrollView scrollView;
    int headingcolor = Color.YELLOW;
    private ImageView bannerImg,post1,post2;
   private AlertDialog myalertDialog;
  private LinearLayout hidden_layout;
   private SeekBar seekBar ;






    EditText toptexteditTxt,headingeditText,
            descripeditText,description2edit,about_edittxt_variable,
            contact_us_editxt_var, gmaildedittxt_var,instaEditText_Var
    ,twitterEditText_var,whatsappEditText_var;
    AmbilWarnaDialog headtxtDialog,headsectiondialog,tablesectiondialog;
    Bundle headintxtcolorBundle = new Bundle();
    Bundle headinSectionColorBundle = new Bundle();

    Bundle tableSectionColorBundle = new Bundle();

    Bundle webpageSection1ColorBundle = new Bundle();

    Bundle webpageSection2ColorBundle = new Bundle();
    Uri uri2,uri1,uri3;
    LinearLayout sociallayout,hiddenSocialLayout;
    String bannerImgURL,post1imgURL,post2imgURL;
    LinearLayout headinglayout;

 //   Bundle headFontBundle = new Bundle();
    ConstraintLayout tableLayout;
    String headingTxtColor,headingSize,headingSectionColor,tableSectionColor,newlayout1Color
            ,newlayout2Color;
    Bundle headingtxtBundle = new Bundle();

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Save Changes")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    Intent iback = new Intent(WebPage.this, CreateWebsite.class);
                    startActivity(iback);
                }).setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.cancel());
        builder.create();
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webpage);

        ActivityResultLauncher<Intent> activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    if (data != null) {
                        uri1 = data.getData();
                    }
                    bannerImg.setImageURI(uri1);

                }
                else
                {
                    Toast.makeText(WebPage.this, "NO Image Selected", Toast.LENGTH_LONG).show();
                }
        });


        ActivityResultLauncher<Intent> activityResultLauncher2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == Activity.RESULT_OK){
                Intent data = result.getData();
                if (data != null) {
                    uri2 = data.getData();
                }
                post1.setImageURI(uri2);
            }
            else
            {
                Toast.makeText(WebPage.this, "NO Image Selected", Toast.LENGTH_LONG).show();
            }
        });

        ActivityResultLauncher<Intent> activityResultLauncher3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == Activity.RESULT_OK){
                Intent data = result.getData();
                if (data != null) {
                    uri3 = data.getData();
                }
                post2.setImageURI(uri3);
            }
            else
            {
                Toast.makeText(WebPage.this, "NO Image Selected", Toast.LENGTH_LONG).show();
            }
        });


        sociallayout =findViewById(R.id.social_link_layout_id);
        hiddenSocialLayout = findViewById(R.id.hidden_social_Link_layout_id);

        sociallayout.setOnClickListener(v -> {
           int magic  =  hiddenSocialLayout.getVisibility();
           if(magic == View.VISIBLE){
               hiddenSocialLayout.setVisibility(View.GONE);
           }
           else{
               hiddenSocialLayout.setVisibility(View.VISIBLE);
           }

        });


        Button createbtn = findViewById(R.id.create_btn_id);
        createbtn.setOnClickListener(v -> {
            Dialog dialog = new Dialog(WebPage.this);
            dialog.setContentView(R.layout.progress_dialog);
            /*if(dialog.getWindow()!=null){
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }*/
            dialog.show();
            try {
                saveData();
                Bundle bundle = new Bundle();
                String toptextview = toptexteditTxt.getText().toString();
                bundle.putString("topText", toptextview);

                String headingtextFont = headingeditText.getText().toString();
                headingtxtBundle.putString("Heading",headingtextFont);

                Bundle headingtextsizebundle = new Bundle();
                headingtextsizebundle.putInt("HeadingSize", seekBar.getProgress());

                Bundle description1bundle = new Bundle();
                String newdp1 =descripeditText.getText().toString();
                description1bundle.putString("DESC1",newdp1);

                Bundle dp2bundle = new Bundle();
                String dp2 = description2edit.getText().toString();
                dp2bundle.putString("DESC2",dp2);

                Bundle aboutusbundle = new Bundle();
                String aboutusnew = about_edittxt_variable.getText().toString();
                aboutusbundle.putString("AboutUs",aboutusnew);

                Bundle ContactUSBundle = new Bundle();
                String newContact = contact_us_editxt_var.getText().toString();
                ContactUSBundle.putString("ContactUs",newContact);

                Bundle gmailBundle = new Bundle();
                String newgmail = gmaildedittxt_var.getText().toString();
                gmailBundle.putString("Gmail",newgmail);

                Bundle instaBundle = new Bundle();
                instaEditText_Var = findViewById(R.id.insta_editTxt_id);
                String new_Insta_Account = instaEditText_Var.getText().toString();
                instaBundle.putString("Instagram",new_Insta_Account);

                Bundle twitter_Bundle = new Bundle();
                twitterEditText_var = findViewById(R.id.twitter_editTxt_id);
                String new_twitter_Account = twitterEditText_var.getText().toString();
                twitter_Bundle.putString("Twitter",new_twitter_Account);


                Bundle whatsapp_Bundle = new Bundle();
                whatsappEditText_var = findViewById(R.id.whatApp_editTxt_id);
                String new_whatsapp_account = whatsappEditText_var.getText().toString();
                whatsapp_Bundle.putString("Whatsapp",new_whatsapp_account);



                Intent i = new Intent(WebPage.this, WebPage2.class);
                i.putExtras(bundle);
                i.putExtras(headingtxtBundle);
              //  i.putExtras(headinFont);
                i.putExtras(headingtextsizebundle);
                i.putExtras(headintxtcolorBundle);
                i.putExtras(headinSectionColorBundle);
                i.putExtras(tableSectionColorBundle);
                i.putExtra("BannerIMG", uri1);
                i.putExtra("POST1", uri2);
                i.putExtras(webpageSection1ColorBundle);
                i.putExtras(webpageSection2ColorBundle);
                i.putExtras(description1bundle);
                i.putExtra("POST2", uri3);
                i.putExtras(dp2bundle);
                i.putExtras(aboutusbundle);
                i.putExtras(ContactUSBundle);
                i.putExtras(gmailBundle);
                i.putExtras(instaBundle);
                i.putExtras(twitter_Bundle);
                i.putExtras(whatsapp_Bundle);
                startActivity(i);
            }catch (Exception e){
                Toast.makeText(this, "Please Do Editing Properly Then Proceed Further....", Toast.LENGTH_SHORT).show();
            }

        });
        toptextview  = findViewById(R.id.webpage1top_textview);
        toptextview.setSelected(true);
        Button toptxbtn = findViewById(R.id.top_text_addbtn_id);
        toptexteditTxt = findViewById(R.id.top_text_editText_id);
        toptxbtn.setOnClickListener(v -> {
           String abc  = toptexteditTxt.getText().toString();
           toptextview.setText(abc);
        });
        LinearLayout toptextlayout = findViewById(R.id.toptext_id);
        LinearLayout editlayout = findViewById(R.id.magic_editTextlayout_id);
        toptextlayout.setOnClickListener(v -> {
        int magic  =  editlayout.getVisibility();
        if(magic == View.VISIBLE){
            editlayout.setVisibility(View.GONE);
        }
        else{
            editlayout.setVisibility(View.VISIBLE);
        }
        });
      LinearLayout descriptionbox = findViewById(R.id.description_show_box_id);
      TextView descriptiontxt = findViewById(R.id.description_id);
      LinearLayout hiddenDescriptionBOx = findViewById(R.id.hidden_descriptionBox_id);
       descriptionbox.setOnClickListener(v -> {
           int magic2 = hiddenDescriptionBOx.getVisibility();
           if(magic2 == View.VISIBLE){
               hiddenDescriptionBOx.setVisibility(View.GONE);
           }
           else{
               hiddenDescriptionBOx.setVisibility(View.VISIBLE);
           }
       });
       descripeditText = findViewById(R.id.description_edit_text_id);
        Button adddescriptionbtn = findViewById(R.id.description1_add_btn_id);
       adddescriptionbtn.setOnClickListener(v -> {
           String addedittxt = descripeditText.getText().toString();
           descriptiontxt.setText(addedittxt);
           descriptiontxt.setVisibility(View.VISIBLE);
       });
       Button deletedescriptionbtn = findViewById(R.id.DeleteBtn_description_id);
       deletedescriptionbtn.setOnClickListener(v -> descriptiontxt.setVisibility(View.GONE));
       TextView description2 = findViewById(R.id.secondDescription_id);
       description2edit = findViewById(R.id.description2_edittxt_id);
       Button description2textaddbtn = findViewById(R.id.description2_add_btn_id);
       Button deletedescription2btn = findViewById(R.id.description2_delete__btn_id);
       LinearLayout dptxtlayout = findViewById(R.id.description2_layout_id);
      LinearLayout dphiddenlayout = findViewById(R.id.hidden_description2_layout_id);
       dptxtlayout.setOnClickListener(v -> {
           int magicdes2 = dphiddenlayout.getVisibility();
           if(magicdes2 == View.VISIBLE){
               dphiddenlayout.setVisibility(View.GONE);
           }else{
               dphiddenlayout.setVisibility(View.VISIBLE);
           }
       });
       description2textaddbtn.setOnClickListener(v -> {
           String setdp2txt = description2edit.getText().toString();
           description2.setText(setdp2txt);
           description2.setVisibility(View.VISIBLE);
       });
       deletedescription2btn.setOnClickListener(v -> description2.setVisibility(View.GONE));


        seekBar = findViewById(R.id.seekbar_id);
        font_no = findViewById(R.id.font_no_id);
        hidden_layout = findViewById(R.id.hidden_layout_id);
        changefontsize();
        LinearLayout show_hidden_layout = findViewById(R.id.show_hidden_layout_id);
        show_hidden_layout.setOnClickListener(v -> {
            int visibiltyi = hidden_layout.getVisibility();
            if(visibiltyi == View.VISIBLE)
            {
                hidden_layout.setVisibility(View.GONE);
            }else
            {
                hidden_layout.setVisibility(View.VISIBLE);
            }
        });

        headinglayout= findViewById(R.id.heading_section_id);
        headinglayout.setOnClickListener(view -> {
            headsectiondialog = new AmbilWarnaDialog(WebPage.this, headingcolor, new AmbilWarnaDialog.OnAmbilWarnaListener()
            {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                    headinglayout.setBackgroundColor(color);
                    headinSectionColorBundle.putInt("HeadingSectionColor",color);
                    headingcolor = color;
                    headingSectionColor = String.valueOf(color);
                }
            });headsectiondialog.show();
        });


        headtext = findViewById(R.id.webpage1Themefont);
        Button headingeditbbtn = findViewById(R.id.heading_editbtn_id);
        headingeditbbtn.setOnClickListener(v -> {
            headingfontsizealertdialog();
            myalertDialog.show();
        });

        if(CommonWebPage.currentitem.isIsclicked())
        {
            headtext.setText(CommonWebPage.currentitem.getThemename());
        }
        Button headingcolorbtn = findViewById(R.id.heading_textcolorbtn_id);
        headingcolorbtn.setOnClickListener(v -> {
            headtxtDialog = new AmbilWarnaDialog(WebPage.this, headingcolor, new AmbilWarnaDialog.OnAmbilWarnaListener()
            {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                  headtext.setTextColor(CommonWebPage.currentitem.setThemename(color));
                    headingcolor =color;
                    headintxtcolorBundle.putInt("HeadingColor",color);
                    headingTxtColor = String.valueOf(color);
                }
            });
            headtxtDialog.show();

        });

        scrollView = findViewById(R.id.webpage_scroll_background_id);
        scrollView.setOnClickListener(view -> {
            AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(WebPage.this, headingcolor, new AmbilWarnaDialog.OnAmbilWarnaListener()
            {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                    scrollView.setBackgroundColor(color);
                    headingcolor =color;
                }
            });ambilWarnaDialog.show();
        });

        tableLayout = findViewById(R.id.webpage_section_id);
        tableLayout.setOnClickListener(view -> {

            AlertDialog.Builder hiddendialog = new AlertDialog.Builder(WebPage.this);
            hiddendialog.setCancelable(false);
            hiddendialog.setMessage("Do You Want To Change Color")
                    .setPositiveButton("Done", (dialogInterface, i) -> dialogInterface.dismiss());

            View m2view = getLayoutInflater().inflate(R.layout.commonlayoutcolor_and_sectioncolor_hidden_dialog,null);
            Button sectioncolorbtn = m2view.findViewById(R.id.sectionColorbtn_id);
           Button layout1colorbtn = m2view.findViewById(R.id.layout1Colorbtn_id);
           Button layout2Colorbtn = m2view.findViewById(R.id.layout2Colorbtn);
            sectioncolorbtn.setOnClickListener(v -> {
                tablesectiondialog = new AmbilWarnaDialog(WebPage.this, headingcolor, new AmbilWarnaDialog.OnAmbilWarnaListener()
                {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        tableLayout.setBackgroundColor(color);
                        tableSectionColorBundle.putInt("TableSectionColor",color);
                        headingcolor =color;
                        tableSectionColor = String.valueOf(color);
                    }
                });tablesectiondialog.show();
            });

            layout1colorbtn.setOnClickListener(v -> {
                tablesectiondialog = new AmbilWarnaDialog(WebPage.this, headingcolor, new AmbilWarnaDialog.OnAmbilWarnaListener()
                {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        CardView cardView = findViewById(R.id.webpage_section1_id);
                        webpageSection1ColorBundle.putInt("Layout1Color",color);
                        cardView.setBackgroundColor(color);
                        headingcolor =color;
                        newlayout1Color = String.valueOf(color);
                    }
                });tablesectiondialog.show();
            });

            layout2Colorbtn.setOnClickListener(v -> {
                tablesectiondialog = new AmbilWarnaDialog(WebPage.this, headingcolor, new AmbilWarnaDialog.OnAmbilWarnaListener()
                {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        CardView cardView = findViewById(R.id.webpage_section2_id);
                        webpageSection2ColorBundle.putInt("Layout2Color",color);
                        cardView.setBackgroundColor(color);
                        headingcolor =color;
                        newlayout2Color = String.valueOf(color);
                    }
                });tablesectiondialog.show();


            });

            hiddendialog.setView(m2view);
            AlertDialog dialog = hiddendialog.create();
            dialog.show();

        });
        bannerImg = findViewById(R.id.bannner_id);
        bannerImg.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            activityResultLauncher1.launch(i);

        });
        post1 = findViewById(R.id.uploadimg1_id);
        post1.setOnClickListener(view -> {
            Intent img1 = new Intent(Intent.ACTION_PICK);
            img1.setType("image/*");
            activityResultLauncher2.launch(img1);
        });
        post2 = findViewById(R.id.uploadimg2_id);
        post2.setOnClickListener(view -> {
            Intent img2 = new Intent(Intent.ACTION_PICK);
            img2.setType("image/*");
            activityResultLauncher3.launch(img2);
        });
         LinearLayout about_us_layout = findViewById(R.id.about_us_layout_id);
         LinearLayout about_us_hidden_layout = findViewById(R.id.about_us_hidden_layout_id);
        about_us_layout.setOnClickListener(v -> {
            int magicabout = about_us_hidden_layout.getVisibility();
            if(magicabout==View.VISIBLE){
                about_us_hidden_layout.setVisibility(View.GONE);
            }else{about_us_hidden_layout.setVisibility(View.VISIBLE);}});
         TextView aboutus_txt = findViewById(R.id.about_us_txt_id);
        about_edittxt_variable = findViewById(R.id.about_us_edit_txt_id);
         Button addbtn_about_us = findViewById(R.id.about_us_add_btn_id);
        Button about_us_deletebtn_var = findViewById(R.id.about_us_delete_btn_id);
        addbtn_about_us.setOnClickListener(v -> {
        String edittxtaboutus = about_edittxt_variable.getText().toString();
        aboutus_txt.setText(edittxtaboutus);
        aboutus_txt.setVisibility(View.VISIBLE);
        });
        about_us_deletebtn_var.setOnClickListener(v -> aboutus_txt.setVisibility(View.GONE));
        LinearLayout contact_us_layout_var = findViewById(R.id.contact_us_layout_id);
        LinearLayout contact_us_hidden_layout_var = findViewById(R.id.contact_us_hidden_layout_id);
        contact_us_layout_var.setOnClickListener(v -> {
            int contact_us_magic = contact_us_hidden_layout_var.getVisibility();
            if(contact_us_magic==View.VISIBLE){contact_us_hidden_layout_var.setVisibility(View.GONE);}
            else{contact_us_hidden_layout_var.setVisibility(View.VISIBLE);}
        });
        TextView contact_us_txt = findViewById(R.id.contact_us_txt_id);
        contact_us_editxt_var = findViewById(R.id.contact_edit_txt_id);
        Button contact_us_addbtn_var = findViewById(R.id.contact_us_addbtn_id);
        Button contact_us_deletebtn_var = findViewById(R.id.contact_deletebtn_id);
        contact_us_addbtn_var.setOnClickListener(v -> {
            String contct_us_edittxt_storage = contact_us_editxt_var.getText().toString();
            contact_us_txt.setText(contct_us_edittxt_storage);
            contact_us_txt.setVisibility(View.VISIBLE);
        });
        contact_us_deletebtn_var.setOnClickListener(v -> contact_us_txt.setVisibility(View.GONE));
        LinearLayout gmaillayout_var = findViewById(R.id.gmail_layout_id);
        LinearLayout gmailhidden_layout_var = findViewById(R.id.gmail_hidden_layout_id);
        gmaillayout_var.setOnClickListener(v -> {
            int magic_gmail = gmailhidden_layout_var.getVisibility();
            if(magic_gmail==View.VISIBLE){gmailhidden_layout_var.setVisibility(View.GONE);}
            else{gmailhidden_layout_var.setVisibility(View.VISIBLE);}
        });
        gmaildedittxt_var = findViewById(R.id.gmail_editxt_id);
        Button gmailaddbtn = findViewById(R.id.gmail_addbtn_id);
        Button gmaildeletebtn = findViewById(R.id.gmail_deletebtn_id);
        TextView gmailtxt = findViewById(R.id.gmail_txt_id);
        gmailaddbtn.setOnClickListener(v -> {
        String gmaileditTxt = gmaildedittxt_var.getText().toString();
        gmailtxt.setText(gmaileditTxt);
        gmailtxt.setVisibility(View.VISIBLE);
        });
        gmaildeletebtn.setOnClickListener(v -> gmailtxt.setVisibility(View.GONE));
        Button toptextclosebtn = findViewById(R.id.top_text_closebtn_id);
        toptextclosebtn.setOnClickListener(v -> editlayout.setVisibility(View.GONE));
        Button description1_closebtn = findViewById(R.id.description1_closebtn_id);
        description1_closebtn.setOnClickListener(v -> hiddenDescriptionBOx.setVisibility(View.GONE));
        Button description2_closebtn = findViewById(R.id.description2_closebtn_id);
        description2_closebtn.setOnClickListener(v -> dphiddenlayout.setVisibility(View.GONE));
        Button about_us_closebtn = findViewById(R.id.about_us_closebtn_id);
        about_us_closebtn.setOnClickListener(v -> about_us_hidden_layout.setVisibility(View.GONE));
        Button contactus_closebtn = findViewById(R.id.contact_us_closebtn_id);
        contactus_closebtn.setOnClickListener(v -> contact_us_hidden_layout_var.setVisibility(View.GONE));
        Button gmail_closebtn = findViewById(R.id.gmail_closebtn_id);
        gmail_closebtn.setOnClickListener(v -> gmailhidden_layout_var.setVisibility(View.GONE));
    }



    private void saveData() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Members Images")
                .child(uri1.getLastPathSegment());
        AlertDialog.Builder builder = new AlertDialog.Builder(WebPage.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_dialog);
        AlertDialog dialog = builder.create();
        dialog.show();
        storageReference.putFile(uri1).addOnSuccessListener(taskSnapshot -> {
            Task<Uri> uriTask1 = taskSnapshot.getStorage().getDownloadUrl();
            while(!uriTask1.isComplete());
            Uri urlimage1 = uriTask1.getResult();
            bannerImgURL = urlimage1.toString();
            uploadData();
            dialog.dismiss();
        }).addOnFailureListener(e -> dialog.dismiss());

        StorageReference storageReference2 = FirebaseStorage.getInstance().getReference().child("Members Images")
                .child(uri2.getLastPathSegment());
        AlertDialog.Builder builder2 = new AlertDialog.Builder(WebPage.this);
        builder2.setCancelable(false);
        builder2.setView(R.layout.progress_dialog);
        AlertDialog dialog2 = builder2.create();
        dialog2.show();
        storageReference2.putFile(uri2).addOnSuccessListener(taskSnapshot -> {
            Task<Uri> uriTask2 = taskSnapshot.getStorage().getDownloadUrl();
            while(!uriTask2.isComplete());
            Uri urlimage2 = uriTask2.getResult();
            post1imgURL = urlimage2.toString();
            uploadData();
            dialog.dismiss();
        }).addOnFailureListener(e -> dialog.dismiss());

        StorageReference storageReference3 = FirebaseStorage.getInstance().getReference().child("Members Images")
                .child(uri3.getLastPathSegment());
        AlertDialog.Builder builder3 = new AlertDialog.Builder(WebPage.this);
        builder3.setCancelable(false);
        builder3.setView(R.layout.progress_dialog);
        AlertDialog dialog3 = builder3.create();
        dialog3.show();
        storageReference3.putFile(uri3).addOnSuccessListener(taskSnapshot -> {
            Task<Uri> uriTask3 = taskSnapshot.getStorage().getDownloadUrl();
            while(!uriTask3.isComplete());
            Uri urlimage3 = uriTask3.getResult();
            post2imgURL = urlimage3.toString();
            uploadData();
            dialog.dismiss();
        }).addOnFailureListener(e -> dialog.dismiss());
    }

    private void uploadData(){
        String topText = toptexteditTxt.getText().toString();
        String heading = headingeditText.getText().toString();
         String post1Description = descripeditText.getText().toString();
         String post2Description = description2edit.getText().toString();
         headingSize = String.valueOf(seekBar.getProgress());
       //  headingFont = headtext.getTypeface().toString();
        // String aboutusHeading ;
         String aboutUsDescription = about_edittxt_variable.getText().toString() ;
        /// String contactUsHeading ;
         String contactDetail = contact_us_editxt_var.getText().toString();
         String contactgmailaccount = gmaildedittxt_var.getText().toString();
         String socialInstaAccount  = instaEditText_Var.getText().toString();
         String socialTwitterAccount = twitterEditText_var.getText().toString();
         String socialWhatsappAccount = whatsappEditText_var.getText().toString();
        DataStoredClass dataStoredClass = new DataStoredClass(topText,heading,post1Description,post2Description
                ,aboutUsDescription,contactDetail,contactgmailaccount,bannerImgURL,post1imgURL,post2imgURL,socialInstaAccount,
                socialTwitterAccount,socialWhatsappAccount,headingTxtColor,headingSectionColor,tableSectionColor,newlayout1Color,
                newlayout2Color,headingSize);
       try {
           FirebaseDatabase.getInstance().getReference("First Practise Page").child(heading).setValue(dataStoredClass)
                   .addOnCompleteListener(task -> {
                       if (task.isComplete()) {
                           Toast.makeText(WebPage.this, "Created SuccessFully", Toast.LENGTH_SHORT).show();
                           finish();
                       }

                   }).addOnFailureListener(e -> Toast.makeText(WebPage.this, e.getMessage(), Toast.LENGTH_SHORT).show());
       }catch(Exception e){
           Toast.makeText(this, "Sorry Cannot Create Page....", Toast.LENGTH_SHORT).show();
       }
    }
    private void changefontsize() {

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar,int position, boolean fromUser) {
                font_no.setText(String.valueOf(position));
                headtext.setTextSize(position);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void headingfontsizealertdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(WebPage.this);
        View mview = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
        headingeditText = mview.findViewById(R.id.heading_edit_id);
        builder.setView(mview);
        builder.setTitle("Your Heading Text")
                .setPositiveButton("OK", (dialogInterface, i) -> addcard(headingeditText.getText().toString())).setNegativeButton("Cancel", (dialogInterface, i) -> {

                });
        myalertDialog = builder.create();
    }


    private void addcard(String name) {
        TextView newname = findViewById(R.id.webpage1Themefont);
        newname.setText(name);

    }

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SELECT_IMAGE_1 && null!= data){
            uri1 = data.getData();
            uploadimg1.setImageURI(uri1);
        }
        else if(requestCode == SELECT_IMAGE_2 && null != data)
        {
            uri2 = data.getData();
            uploadimg2.setImageURI(uri2);
        }
        else if (requestCode == 1 && null != data){
            uri3 = data.getData();
            webpageBinding.bannnerId.setImageURI(uri3);}}*/



}

