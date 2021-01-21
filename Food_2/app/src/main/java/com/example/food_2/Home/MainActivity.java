package com.example.food_2.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_2.Login_out.LoginActivity;
import com.example.food_2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static int id_Selected_fragment = -1;
    public static int orientation;

    @Override
    protected void onStart() {
        super.onStart();
        androidx.fragment.app.Fragment selectedFragment = null;
        switch (id_Selected_fragment){
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.nav_favorities:
                selectedFragment = new FavoritesFragment();
                break;
            case R.id.nav_search:
                selectedFragment = new SearchFragment();
                break;
            case R.id.nav_person:
            {
                if(LoginActivity.daDangNhap){
                    selectedFragment = new PersonFragment();
                }
                else {
                    selectedFragment = new PersonFragmentNotLogIn();
                }
            }break;
            default:break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        if (id_Selected_fragment == -1)
            id_Selected_fragment = R.id.nav_search;


        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            orientation = 1;
        }
        else {
            orientation = 2;
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    androidx.fragment.app.Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            id_Selected_fragment = R.id.nav_home;
                            break;
                        case R.id.nav_favorities:
                            selectedFragment = new FavoritesFragment();
                            id_Selected_fragment = R.id.nav_favorities;
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            id_Selected_fragment = R.id.nav_search;
                            break;
                        case R.id.nav_person:
                        {
                            if(LoginActivity.daDangNhap){
                                selectedFragment = new PersonFragment();
                                id_Selected_fragment = R.id.nav_person;
                            }
                            else {
                                selectedFragment = new PersonFragmentNotLogIn();
                                id_Selected_fragment = R.id.nav_person;
                            }
                        }break;
                        default:break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                };
            };

    public void DangNhap(View view) {
        Intent downloadIntent = new Intent(this, LoginActivity.class);
        startActivities(new Intent[]{downloadIntent});
    }
}