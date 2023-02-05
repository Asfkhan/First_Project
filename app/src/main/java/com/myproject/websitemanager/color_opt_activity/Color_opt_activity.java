package com.myproject.websitemanager.color_opt_activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.websitemanager.R;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Color_opt_activity extends AppCompatActivity {
    int defaultcolor;
    RecyclerView rcv;
    Button colorpickerbtn;
  // Dialog dialog;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_opt);
       /* MyColorList[] colordata = new MyColorList[]{
                new MyColorList("Black",R.color.black),
                new MyColorList("Fiesta",R.color.Fiesta),
                new MyColorList("Scuba_blue",R.color.Scuba_blue),
                new MyColorList("Off_beat_green",R.color.off_beat_green),
                new MyColorList("Morning_glory",R.color.Morning_glory),
                new MyColorList("Titanium",R.color.Titanium),
                new MyColorList("Roasted_Almond",R.color.Roasted_almond),
                new MyColorList("Burgundy",R.color.Burgundy),
                new MyColorList("Sandstone",R.color.Sandstone),
                new MyColorList("Emerald",R.color.Emerald),
                new MyColorList("Olive",R.color.Olive),
                new MyColorList("Forceful_orange",R.color.Forceful_orange),
                new MyColorList("Butternut",R.color.Butternut),
                new MyColorList("Vast_sky",R.color.vast_sky),
                new MyColorList("Intellectual_Grey",R.color.Intellectual_Grey),
                new MyColorList("Obstinate_orange",R.color.Obstinate_orange),
                new MyColorList("Dazzle", R.color.Dazzle),
                new MyColorList("Frank_blue",R.color.Frank_blue)

        };*/
        colorpickerbtn = findViewById(R.id.pick_color_button);
        defaultcolor = ContextCompat.getColor(Color_opt_activity.this,R.color.black);
        colorpickerbtn.setOnClickListener(view ->{
            openColorpicker();

        //    dialog.show();
        });
       // dialog = new Dialog(Color_opt_activity.this);
      //  dialog.setContentView(R.layout.color_picker_layout);
       // dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.color_dialog_box_background));
       // dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

//        myAdapter adapter = new myAdapter(colordata);
  //      rcv = dialog.findViewById(R.id.recyclerViewid);
    //    rcv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
      //  rcv.setAdapter(adapter);

    }

    private void openColorpicker() {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, defaultcolor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
            defaultcolor = color;
            }
        });
        ambilWarnaDialog.show();

    }

}

