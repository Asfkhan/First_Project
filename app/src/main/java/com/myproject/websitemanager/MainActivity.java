package com.myproject.websitemanager;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import com.myproject.websitemanager.ui.colors.Colors;
import com.myproject.websitemanager.ui.finish_creation.Finish_Creation;
import com.myproject.websitemanager.ui.fonts.Fonts;
import com.myproject.websitemanager.ui.home.Home;
import com.myproject.websitemanager.ui.template.Templates;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

            drawerLayout = findViewById(R.id.drawerLayout);
            navigationView = findViewById(R.id.nav_view);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);

            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(item -> {
                int id = item.getItemId();
                if(id==R.id.nav_home){
                    loadFragment(new Home());
                }
                else if(id==R.id.nav_templates)
                {
                    loadFragment(new Templates());
                }else if(id==R.id.nav_colour)
                {
                    loadFragment(new Colors());

                }else if(id==R.id.nav_font){
                    loadFragment(new Fonts());
                }else {
                    loadFragment(new Finish_Creation());
                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            });

        }

        @Override
        public void onBackPressed() {
            if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START);
            }else{
                super.onBackPressed();
            }
        }

        private void loadFragment(Fragment fragment) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container, fragment);
            ft.commit();
        }
    }

