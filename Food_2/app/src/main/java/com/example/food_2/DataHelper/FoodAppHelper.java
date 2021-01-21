package com.example.food_2.DataHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;

import java.util.ArrayList;

public class FoodAppHelper extends SQLiteOpenHelper {

    protected String BaiViet;
    protected String Category;
    protected String VungMien;

    public FoodAppHelper(@Nullable Context context) {
        super(context, ConfigHelper.DATADASE_NAME, null, ConfigHelper.Version);
        BaiViet = "baiviets";
        Category = "categories";
        VungMien = "vungmiens";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists " + this.BaiViet + "(" +
                " id INTERGER primary key," +
                " ten TEXT ," +
                " nguyenlieu TEXT," +
                " soche TEXT," +
                " thuchien TEXT," +
                " cachdung TEXT," +
                " category_id INTERGER, " +
                " vungmien_id INTERGER," +
                " hinhanh TEXT)");
        db.execSQL("Create table if not exists " + this.Category + "(id interger primary key, title text not null, img not null)");
        db.execSQL("Create table if not exists " + this.VungMien + "(id interger primary key, ten_vungmien text not null, noidung not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + this.BaiViet );
        db.execSQL("drop table if exists " + this.Category );
        db.execSQL("drop table if exists " + this.VungMien );

        db.execSQL("Create table if not exists " + this.BaiViet + "(" +
                " id INTERGER primary key," +
                " ten TEXT ," +
                " nguyenlieu TEXT," +
                " soche TEXT," +
                " thuchien TEXT," +
                " cachdung TEXT," +
                " category_id INTERGER, " +
                " vungmien_id INTERGER," +
                " hinhanh TEXT)");
        db.execSQL("Create table if not exists " + this.Category + "(id interger primary key, title text not null, img not null)");
        db.execSQL("Create table if not exists " + this.VungMien + "(id interger primary key, ten_vungmien text not null, noidung not null)");
    }
}
