package com.example.food_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_person);
    }

    public void Dangky(View view) {
        Intent downloadIntent = new Intent(this, RegisterActivity.class);
        startActivities(new Intent[]{downloadIntent});
    }
}