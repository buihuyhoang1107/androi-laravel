package com.example.food_2.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tạo các button bấm
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //Xuất hiện fragment đầu tiên
        Fragment fragment = new SearchFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    androidx.fragment.app.Fragment selectedFragment = null;


                    switch (menuItem.getItemId()){
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
                            selectedFragment = new PersonFragment();
                        }break;
                        default:break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                };
            };



    public void Dangky(View view) {
    }

}