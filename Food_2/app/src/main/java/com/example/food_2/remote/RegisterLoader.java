package com.example.food_2.remote;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.food_2.Model.Nguoidung;

public class RegisterLoader extends AsyncTaskLoader<String> {

    Nguoidung nguoidung;

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    public RegisterLoader(@NonNull Context context, String ten, String email, String matkhau) {
        super(context);
        nguoidung = new Nguoidung();
        nguoidung.setTen(ten);
        nguoidung.setGmail(email);
        nguoidung.setMatkhau(matkhau);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.Register(nguoidung);
    }
}
