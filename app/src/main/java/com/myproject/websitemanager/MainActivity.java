package com.myproject.websitemanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myproject.websitemanager.ui.colors.Colors;
import com.myproject.websitemanager.ui.finish_creation.Finish_Creation;
import com.myproject.websitemanager.ui.fonts.Fonts;
import com.myproject.websitemanager.ui.home.Home;
import com.myproject.websitemanager.ui.template.Templates;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    FirebaseUser user;
    View header;
    TextView email,username;
    ImageView userImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        try {
            drawerLayout = findViewById(R.id.drawerLayout);
            navigationView = findViewById(R.id.nav_view);
            Toolbar toolbar = findViewById(R.id.main_activity_toolbar_id);
            setSupportActionBar(toolbar);
            mAuth = FirebaseAuth.getInstance();
            user = mAuth.getCurrentUser();
            databaseReference = FirebaseDatabase.getInstance().getReference();
            DatabaseReference userRef = databaseReference.child("Users");
            Log.d("USERID",userRef.getKey());
            header = navigationView.inflateHeaderView(R.layout.nav_header_main);
            userImg = header.findViewById(R.id.user_New_Img_id);
            email = header.findViewById(R.id.email_address_id);
            username = header.findViewById(R.id.userName_id);
            Bundle emailBundle = getIntent().getExtras();
            if (emailBundle != null) {

                email.setText(emailBundle.getString("email"));
            }

            userRef.orderByChild("email").equalTo(user.getEmail()).addValueEventListener(new ValueEventListener() {
                String newuserName, newImg;
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot itemshot : snapshot.getChildren()){
                            newuserName = itemshot.child("userName").getValue(String.class);
                            newImg = itemshot.child("userimg").getValue(String.class);
                            break;
                        }


                    username.setText(newuserName);
                    Glide.with(MainActivity.this).load(newImg).into(userImg);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(MainActivity.this, "SomeThing Wrong " + error, Toast.LENGTH_SHORT).show();
                }
            });


            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);

            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    loadFragment(new Home());
                } else if (id == R.id.nav_templates) {
                    loadFragment(new Templates());
                } else if (id == R.id.nav_colour) {
                    loadFragment(new Colors());

                } else if (id == R.id.nav_font) {
                    loadFragment(new Fonts());
                } else {
                    loadFragment(new Finish_Creation());
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            });

        } catch (Exception e) {
            Toast.makeText(this, "SomeThing Went Wrong" , Toast.LENGTH_LONG).show();
        }


    }




    @Override
    public void onBackPressed() {


        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0 || drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are You Sure Want To Logout And Exit")
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        FirebaseAuth.getInstance().signOut();
                        finish();
                    }).setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.cancel());
            builder.create();
            builder.show();
            //additional code
        } else {
            super.onBackPressed();
            getSupportFragmentManager().popBackStack();
        }


    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.commit();
    }


}
