package com.example.food_2.Login_out;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_2.R;

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