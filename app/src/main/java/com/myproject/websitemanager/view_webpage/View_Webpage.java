package com.myproject.websitemanager.view_webpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import com.bumptech.glide.Glide;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.view_main_activity.View_MainActivity;

import yuku.ambilwarna.AmbilWarnaDialog;

public class View_Webpage extends AppCompatActivity {
int commonColor = Color.BLUE;
AlertDialog myalertDialog;
    TextView headingeditText,toptexteditTxt,bannerscrollTxt,bannerTitle,
            bannerDescription, descrip1text,post1titletext,post2titleText,
            description2text,addpostTitle,addpostdescription,aboutUsText,
            aboutUsDescription,contactUsHeading,contactUsDescription,gmaildedittxt_var,socialheadinText;
    LinearLayout headingSection,addpostLayout,socialLayout,postmainlyaout;
    ImageView newpostimg;
    Uri uri;
    View addpostview;
    ActivityResultLauncher<Intent> activityResultLauncher;
    EditText banneredittx,bannerTitleEditTxt,bannerDescriptionEditText,linkeditText,
            post1editText,post2editText,addposteditText,addpostdescriptionEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_webpage);
        AlertDialog.Builder optionbuilder = new AlertDialog.Builder(View_Webpage.this);
        optionbuilder.setIcon(R.drawable.baseline_cruelty_free_24);
        optionbuilder.setTitle("Decide First! View Or Manage?");

        optionbuilder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("Manage", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LinearLayout bannerscrolltxthiddenlayout = findViewById(R.id.banner_scroll_hiddenlayout_id);
                bannerscrolltxthiddenlayout.setVisibility(View.VISIBLE);
                LinearLayout bannerdescriptionhiddenlayout = findViewById(R.id.banner_description_hiddenlayout_id);
                bannerdescriptionhiddenlayout.setVisibility(View.VISIBLE);
                post1titletext.setVisibility(View.VISIBLE);
                post2titleText.setVisibility(View.VISIBLE);
            }
        });
        AlertDialog startdialog = optionbuilder.create();
        startdialog.show();
        toptexteditTxt = findViewById(R.id.view_topTxt_id);
        headingeditText = findViewById(R.id.view_heading_id);
        headingSection = findViewById(R.id.view_heading_section_id);
        bannerscrollTxt = findViewById(R.id.banner_top_scroll_id);
        bannerscrollTxt.setSelected(true);
        bannerTitle = findViewById(R.id.banner_title_id);
        bannerTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url(linkeditText.getText().toString());
            }
        });
        bannerDescription = findViewById(R.id.banner_description_id);
        ImageView bannerimg = findViewById(R.id.view_banner_id);
        ConstraintLayout section = findViewById(R.id.view_table_section_id);
        ImageView post1img = findViewById(R.id.view_post1_id);
        LinearLayout layout1 = findViewById(R.id.view_layout1Color);
        post1titletext = findViewById(R.id.post1_title_id);
        descrip1text = findViewById(R.id.view_description1_id);
        LinearLayout layout2 = findViewById(R.id.view_layout2_color);
        ImageView post2img = findViewById(R.id.view_post2_id);
        post2titleText = findViewById(R.id.post2title_id);
        description2text = findViewById(R.id.view_description2_id);
        aboutUsText = findViewById(R.id.aboutUs_header_id);
        aboutUsDescription = findViewById(R.id.view_about_us_txt_id);
        contactUsHeading = findViewById(R.id.contactUs_heading_id);
        contactUsDescription = findViewById(R.id.view_contact_us_txt_id);
        socialheadinText = findViewById(R.id.social_heading_id);
        socialLayout =findViewById(R.id.view_social_link_layout_id);
         gmaildedittxt_var = findViewById(R.id.view_gmail_txt_id);
        TextView instaLinks = findViewById(R.id.view_insta_id);
        TextView twitterLinks = findViewById(R.id.view_twitter_id);
        TextView whatsAppLinks = findViewById(R.id.view_whatsapp_id);


         activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == Activity.RESULT_OK){
                Intent data = result.getData();
                if(data != null){
                    uri = data.getData();
                }
                ProgressDialog progressDialog;
                progressDialog = new ProgressDialog(View_Webpage.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMessage("Uploading...");
                progressDialog.setCancelable(false);
                newpostimg.setImageURI(uri);
            }
        });
         
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            toptexteditTxt.setSelected(true);
            toptexteditTxt.setText(bundle.getString("TopText"));
            headingeditText.setText(bundle.getString("Head"));
          //  headingeditText.setTypeface(tf,Integer.parseInt(bundle.getString("HeadingFont")));
            headingeditText.setTextSize(Integer.parseInt(bundle.getString("HeadingSize")));
            headingeditText.setTextColor(Integer.parseInt(bundle.getString("HeadingColor")));
            headingSection.setBackgroundColor(Integer.parseInt(bundle.getString("HeadingSectionColor")));
            Glide.with(this).load(bundle.getString("BannerImg")).into(bannerimg);
            Glide.with(this).load(bundle.getString("Post1")).into(post1img);
            section.setBackgroundColor(Integer.parseInt(bundle.getString("TableSectionColor")));
            layout1.setBackgroundColor(Integer.parseInt(bundle.getString("Layout1Color")));
            layout2.setBackgroundColor(Integer.parseInt(bundle.getString("Layout2Color")));
            descrip1text.setText(bundle.getString("Description1"));
            Glide.with(this).load(bundle.getString("Post2")).into(post2img);
            description2text.setText(bundle.getString("Description2"));
            aboutUsDescription.setText(bundle.getString("AboutUs"));
            contactUsDescription.setText(bundle.getString("ContactUs"));
            gmaildedittxt_var.setText(bundle.getString("Gmail"));
            instaLinks.setOnClickListener(v -> {
                url(bundle.getString("Insta"));
            });
            twitterLinks.setOnClickListener(v -> url(bundle.getString("Twit")));
            whatsAppLinks.setOnClickListener(v -> url(bundle.getString("Whats")));

        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(View_Webpage.this);
        View mview = getLayoutInflater().inflate(R.layout.dialog_website_manage,findViewById(R.id.spinner_dialog_root_id));
        Spinner spinner = mview.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView < ? > parent, View view,int position,long id){
                try{
                    if (position == 1) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.bangers));
                    } else if (position == 2) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.abril_fatface));
                    } else if (position == 3) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.berkshire_swash));
                    } else if (position == 4) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.aclonica));
                    } else if (position == 5) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.acme));
                    } else if (position == 6) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.alfa_slab_one));
                    } else if (position == 7) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.eagle_lake));
                    } else if (position == 9) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.big_shoulders_stencil_display_semibold));
                    }else if (position == 10) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.bungee_shade));
                    }else if (position == 11) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.cherry_swash_bold));

                    }else if (position == 12) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.cinzel_decorative_bold));
                    }else if (position == 13) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.creepster));
                    }else if (position == 14) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.diplomata));

                    }else if (position == 8) {
                        headingeditText.setTypeface(ResourcesCompat.getFont(View_Webpage.this,R.font.fontdiner_swanky));

                    }

                }catch(Exception e){
                    Toast.makeText(View_Webpage.this, " " + e, Toast.LENGTH_SHORT).show();

                }
            }




            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner2 = mview.findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 2){
                    AmbilWarnaDialog toptextdialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {

                        }

                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            toptexteditTxt.setTextColor(color);
                        }
                    });toptextdialog.show();
                } else if (position == 4) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(View_Webpage.this);
                    builder1.setCancelable(false);
                    builder1.setTitle("More You Write More It Describe").setPositiveButton("Add", (dialog, which) -> bannerscrollTxt.setText(banneredittx.getText().toString()));
                    View editView = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
                    banneredittx = editView.findViewById(R.id.heading_edit_id);
                    builder1.setView(editView);
                    AlertDialog dialog = builder1.create();
                    dialog.show();
                } else if (position == 5) {
                    AmbilWarnaDialog bannerscrolllingtxtdialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {

                        }

                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            bannerscrollTxt.setTextColor(color);
                        }
                    });bannerscrolllingtxtdialog.show();
                } else if (position == 6) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(View_Webpage.this);
                    builder2.setCancelable(false);
                    builder2.setTitle("More You Write More It Describe").setPositiveButton("Add", (dialog, which) -> bannerTitle.setText(bannerTitleEditTxt.getText().toString()));
                    View editView = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
                    bannerTitleEditTxt = editView.findViewById(R.id.heading_edit_id);
                    builder2.setView(editView);
                    AlertDialog bannertitle = builder2.create();
                    bannertitle.show();

                } else if (position == 7) {
                    AmbilWarnaDialog bannertitledialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {

                        }

                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            bannerTitle.setTextColor(color);
                        }
                    });bannertitledialog.show();
                } else if (position == 8 ) {
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(View_Webpage.this);
                    builder3.setCancelable(false);
                    builder3.setTitle("More You Write More It Describe").setPositiveButton("Add", (dialog, which) -> bannerDescription.setText(bannerDescriptionEditText.getText().toString()));
                    View editView = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
                    bannerDescriptionEditText = editView.findViewById(R.id.heading_edit_id);
                    builder3.setView(editView);
                    AlertDialog bannerDescription = builder3.create();
                    bannerDescription.show();

                } else if (position == 9) {
                    AmbilWarnaDialog bannerdescriptiondialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {

                        }

                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            bannerDescription.setTextColor(color);
                        }
                    });bannerdescriptiondialog.show();
                } else if (position == 10) {
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(View_Webpage.this);
                    builder4.setCancelable(false);
                    builder4.setTitle("Paste or Type Link").setPositiveButton("Add", (dialog, which) -> {
                        Toast.makeText(View_Webpage.this, "Link Added SuccessFully", Toast.LENGTH_SHORT).show();
                    });
                    View editView = getLayoutInflater().inflate(R.layout.banner_title_link_dialog,findViewById(R.id.banner_title_link_dialog_root_id));
                    linkeditText = editView.findViewById(R.id.paste_link_id);
                    builder4.setView(editView);
                    AlertDialog bannerDescription = builder4.create();
                    bannerDescription.show();
                } else if (position == 12) {
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(View_Webpage.this);
                    builder5.setCancelable(false);
                    builder5.setTitle("MORE YOU WRITE MORE YOU DESCRIBE!").setPositiveButton("Add", (dialog, which) -> post1titletext.setText(post1editText.getText().toString()));
                    View editView = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
                    post1editText = editView.findViewById(R.id.heading_edit_id);
                    builder5.setView(editView);
                    AlertDialog post1Titledialog = builder5.create();
                    post1Titledialog.show();
                } else if (position == 13) {
                    AmbilWarnaDialog post1titledialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            post1titletext.setTextColor(color);
                        }
                    });post1titledialog.show();
                } else if (position == 14) {
                    AmbilWarnaDialog post1descriptiondialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            descrip1text.setTextColor(color);
                        }
                    });post1descriptiondialog.show();

                } else if (position==16) {
                    AlertDialog.Builder builder6 = new AlertDialog.Builder(View_Webpage.this);
                    builder6.setCancelable(false);
                    builder6.setTitle("MORE YOU WRITE MORE YOU DESCRIBE!").setPositiveButton("Add", (dialog, which) -> {
                        post2titleText.setText(post2editText.getText().toString());
                    });
                    View editView = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
                    post2editText = editView.findViewById(R.id.heading_edit_id);
                    builder6.setView(editView);
                    AlertDialog post2Titledialog = builder6.create();
                    post2Titledialog.show();
                } else if (position==17) {
                    AmbilWarnaDialog post2titledialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            post2titleText.setTextColor(color);
                        }
                    });post2titledialog.show();
                } else if (position==18) {
                    AmbilWarnaDialog post2descriptiondialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            description2text.setTextColor(color);
                        }
                    });post2descriptiondialog.show();
                } else if (position==20) {
                    AmbilWarnaDialog aboutUsdialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            aboutUsText.setTextColor(color);
                        }
                    });aboutUsdialog.show();
                } else if (position==21) {
                    AmbilWarnaDialog aboutUsdescriptiondialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            aboutUsDescription.setTextColor(color);
                        }
                    });aboutUsdescriptiondialog.show();
                } else if (position==23) {
                    AmbilWarnaDialog contactUsTitledialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            contactUsHeading.setTextColor(color);
                        }
                    });contactUsTitledialog.show();

                } else if (position==24) {
                    AmbilWarnaDialog contactUsdescriptiondialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            contactUsDescription.setTextColor(color);
                            gmaildedittxt_var.setTextColor(color);
                        }
                    });contactUsdescriptiondialog.show();
                } else if (position == 26) {
                    AmbilWarnaDialog socialheadingdialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                    }
                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        commonColor = color;
                        socialheadinText.setTextColor(color);
                    }
                });socialheadingdialog.show();
                } else if (position==27) {
                    AmbilWarnaDialog sociallayoutdialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            socialLayout.setBackgroundColor(color);
                        }
                    });sociallayoutdialog.show();
                } else if (position==29) {
                    AlertDialog.Builder builder7 = new AlertDialog.Builder(View_Webpage.this);
                    builder7.setCancelable(false);
                    builder7.setTitle("MORE YOU WRITE MORE YOU DESCRIBE!").setPositiveButton("Add", (dialog, which) -> {
                        addpostTitle.setText(addposteditText.getText().toString());
                    });
                    View editView = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
                    addposteditText = editView.findViewById(R.id.heading_edit_id);
                    builder7.setView(editView);
                    AlertDialog newpostdialog = builder7.create();
                    newpostdialog.show();
                } else if (position==30) {
                    AlertDialog.Builder builder8 = new AlertDialog.Builder(View_Webpage.this);
                    builder8.setCancelable(false);
                    builder8.setTitle("MORE YOU WRITE MORE YOU DESCRIBE!").setPositiveButton("Add", (dialog, which) -> {
                        addpostdescription.setText(addpostdescriptionEditText.getText().toString());
                    });
                    View editView = getLayoutInflater().inflate(R.layout.font_size_dialog_box,findViewById(R.id.edittextroot_id));
                    addpostdescriptionEditText = editView.findViewById(R.id.heading_edit_id);
                    builder8.setView(editView);
                    AlertDialog newpostdescriptiondialog = builder8.create();
                    newpostdescriptiondialog.show();
                } else if (position==31) {
                    AmbilWarnaDialog addpost_layoutdialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            addpostLayout.setBackgroundColor(color);
                        }
                    });addpost_layoutdialog.show();
                } else if (position==32) {
                    AmbilWarnaDialog addpost_titledialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            addpostTitle.setTextColor(color);
                        }
                    });addpost_titledialog.show();
                } else if (position==33) {
                    AmbilWarnaDialog addpost_descriptiondialog = new AmbilWarnaDialog(View_Webpage.this, commonColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                        @Override
                        public void onCancel(AmbilWarnaDialog dialog) {
                        }
                        @Override
                        public void onOk(AmbilWarnaDialog dialog, int color) {
                            commonColor = color;
                            addpostdescription.setTextColor(color);
                        }
                    });addpost_descriptiondialog.show();
                } else if (position==34) {
                    AlertDialog.Builder custombuilder = new AlertDialog.Builder(View_Webpage.this);
                    custombuilder.setCancelable(false);
                    custombuilder.setTitle("One Chance Of Edit And Delete");
                    custombuilder.setMessage("Think Twice And Add New Post!");
                    custombuilder.setIcon(R.drawable.baseline_warning_24);

                    custombuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            postmainlyaout = findViewById(R.id.view_website_post_main_layout_id);
                            addpostview = getLayoutInflater().inflate(R.layout.add_hidden_layout_manage_webpage,null);
                            newpostimg = addpostview.findViewById(R.id.add_post_id);
                            addpostLayout = addpostview.findViewById(R.id.add_post_layout_root_id);
                            addpostTitle = addpostview.findViewById(R.id.add_post_title_id);
                            addpostdescription = addpostview.findViewById(R.id.add_post_description_id);
                            newpostimg.setOnClickListener(v1 -> {
                                Intent pickimgintent = new Intent(Intent.ACTION_PICK);
                                pickimgintent.setType("image/*");
                                activityResultLauncher.launch(pickimgintent);
                            });
                            postmainlyaout.addView(addpostview);
                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog customdialog = custombuilder.create();
                    customdialog.show();


                } else if (position==35) {
                    postmainlyaout.removeView(addpostview);
                } else if (position==36) {
                    AlertDialog.Builder custom2builder = new AlertDialog.Builder(View_Webpage.this);
                    custom2builder.setTitle("Are Your Sure");
                    custom2builder.setMessage("This Will Delete All Post!");
                    custom2builder.setIcon(R.drawable.baseline_warning_24);

                    custom2builder.setPositiveButton("Delete Anyway", (dialog, which) -> postmainlyaout.removeAllViews()).setNegativeButton("Cancel", (dialog, which) -> {
                    });
                    AlertDialog custom2dialog = custom2builder.create();
                    custom2dialog.show();}}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        builder.setView(mview);
        builder.setTitle("Lets! Manage Up Website!")
                .setPositiveButton("Done", (dialogInterface, i) -> dialogInterface.dismiss())
                .setNegativeButton("Exit", (dialog, which) -> {
                  Intent backtohome = new Intent(View_Webpage.this, View_MainActivity.class);
                  startActivity(backtohome);
                });
        myalertDialog = builder.create();
        myalertDialog.show();



    }

    private void url(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}