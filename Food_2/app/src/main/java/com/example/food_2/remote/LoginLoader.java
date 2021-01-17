package com.example.food_2.remote;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class LoginLoader extends AsyncTaskLoader<String> {

    public LoginLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.Login();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
