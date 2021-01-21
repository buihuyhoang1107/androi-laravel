package com.example.food_2.DataHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.food_2.Config;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;

import java.util.ArrayList;

public class CategoryHelper extends FoodAppHelper {

    public CategoryHelper(@Nullable Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists " + this.Category + "(id interger primary key, title text not null, img not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + this.Category);
        db.execSQL("Create table if not exists " + this.Category + "(id interger primary key, title text not null, img not null)");
    }

    public void update(ArrayList<CategoryModel> categoryModels){
        SQLiteDatabase db = getWritableDatabase();
        for (CategoryModel cate: categoryModels) {
            ContentValues ct = new ContentValues();
            ct.put("id",cate.getId());
            ct.put("title",cate.getTitle());
            ct.put("img",cate.getImg());
            db.insert(this.Category,null,ct);
        }
    }

    public boolean add(CategoryModel categoryModel){
        try{
            SQLiteDatabase db = getWritableDatabase();
            ContentValues ct = new ContentValues();
            ct.put("id",categoryModel.getId());
            ct.put("title",categoryModel.getTitle());
            ct.put("img",categoryModel.getImg());
            if(db.insert(this.Category,null,ct) == -1)
                return false;
            return true;
        }catch (Exception err){
            Log.e("datahelper","add");
            return false;
        }
    }

    public boolean delete(int id){
        try{
            SQLiteDatabase db = getWritableDatabase();
            if(db.delete(this.Category,"id = " + id, null ) == -1)
                return false;
            return true;
        }catch (Exception err){
            Log.e("datahelper","delete");
            return false;
        }
    }

    public CategoryModel getById(int id){
        SQLiteDatabase db = getReadableDatabase();
        String queryString ="select * from " + this.Category + " where id like ?";
        Cursor cursor = db.rawQuery(queryString, new String[] {String.valueOf(id)});
        if (cursor.getCount() == 0)
            return null;
        CategoryModel categoryModel = null;
        while(cursor.moveToNext()){
            categoryModel = new CategoryModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );

        }
        return categoryModel;
    }

    public ArrayList<CategoryModel> getAll(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + this.Category, null);
        if (cursor.getCount() == 0)
            return null;
        ArrayList<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
        while(cursor.moveToNext()){
            CategoryModel categoryModel = new CategoryModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            categoryModels.add(categoryModel);
        }
        return categoryModels;
    }
}
