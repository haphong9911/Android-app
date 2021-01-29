package com.example.apptruyen1.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.apptruyen1.Fragment.Fragment_Kham_pha;
import com.example.apptruyen1.Fragment.Fragment_Lich_su;
import com.example.apptruyen1.Fragment.Fragment_Menu;
import com.example.apptruyen1.Fragment.Fragment_The_loai;
import com.example.apptruyen1.Fragment.Fragment_Tim_kiem;
import com.example.apptruyen1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_Kham_pha()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_timkiem:
                            selectedFragment = new Fragment_Tim_kiem();
                            break;
                        case R.id.nav_lichsu:
                            selectedFragment = new Fragment_Lich_su();
                            break;
                        case R.id.nav_khampha:
                            selectedFragment = new Fragment_Kham_pha();
                            break;
                        case R.id.nav_theloai:
                            selectedFragment = new Fragment_The_loai();
                            break;
                        case R.id.nav_menu:
                            selectedFragment = new Fragment_Menu();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
