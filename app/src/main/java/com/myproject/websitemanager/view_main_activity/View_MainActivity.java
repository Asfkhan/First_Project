package com.myproject.websitemanager.view_main_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myproject.websitemanager.DataStoredClass;
import com.myproject.websitemanager.MainActivity;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.view_webpage.LayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class View_MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataStoredClass> dataStoredClassList;
    DatabaseReference databaseReference;
    ValueEventListener valueEventListener;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(View_MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("View Your Website");
        builder.setMessage("DO Want To Exit");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent onback = new Intent(View_MainActivity.this, MainActivity.class);
            startActivity(onback);
        }).setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.create();
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyler_layout);
        TextView viewheading = findViewById(R.id.message_to_view);
        viewheading.setSelected(true);
        recyclerView = findViewById(R.id.recyclerViewid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(View_MainActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        AlertDialog.Builder builder = new AlertDialog.Builder(View_MainActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_dialog);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataStoredClassList = new ArrayList<>();
        LayoutAdapter layoutAdapter = new LayoutAdapter(View_MainActivity.this, dataStoredClassList);
        recyclerView.setAdapter(layoutAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("First Practise Page");
        dialog.show();

        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataStoredClassList.clear();
                for (DataSnapshot itemShot : snapshot.getChildren()) {
                    DataStoredClass dataStoredClass1 = itemShot.getValue(DataStoredClass.class);
                    dataStoredClassList.add(dataStoredClass1);
                }
                layoutAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });

    }
}