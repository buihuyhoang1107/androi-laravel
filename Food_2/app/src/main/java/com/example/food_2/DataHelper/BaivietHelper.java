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

public class BaivietHelper extends SQLiteOpenHelper {

    private String NameTable;

    public BaivietHelper(@Nullable Context context) {
        super(context, ConfigHelper.DATADASE_NAME, null, ConfigHelper.Version);
        NameTable = "baiviets";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists " + this.NameTable + "(" +
                " id INTERGER primary key," +
                " ten TEXT ," +
                " nguyenlieu TEXT," +
                " soche TEXT," +
                " thuchien TEXT," +
                " cachdung TEXT," +
                " category_id INTERGER, " +
                " vungmien_id INTERGER," +
                " hinhanh TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + NameTable );
        db.execSQL("Create table if not exists " + this.NameTable + "(" +
                " id INTERGER primary key," +
                " ten TEXT ," +
                " nguyenlieu TEXT," +
                " soche TEXT," +
                " thuchien TEXT," +
                " cachdung TEXT," +
                " category_id INTERGER, " +
                " vungmien_id INTERGER," +
                " hinhanh TEXT)");
        //db.execSQL("delete from "+ TABLE_NAME);
    }

    public void updateTabel(ArrayList<BaiVietModel> baiVietModels){
        SQLiteDatabase db = this.getWritableDatabase();

        for (BaiVietModel bv: baiVietModels) {
            ContentValues ct = new ContentValues();
            ct.put("id",bv.getId());
            ct.put("ten",bv.getTen());
            ct.put("nguyenlieu",bv.getNguyenlieu());
            ct.put("soche",bv.getSoche());
            ct.put("thuchien",bv.getThuchien());
            ct.put("cachdung",bv.getCachdung());
            ct.put("category_id",bv.getCategory_id());
            ct.put("vungmien_id",bv.getVungmien_id());
            ct.put("hinhanh",bv.getHinhanh());
            db.insert(NameTable,null,ct);
        }
    }

    public boolean add(BaiVietModel baiVietModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ct = new ContentValues();
        ct.put("id",baiVietModel.getId());//
        ct.put("ten",baiVietModel.getTen());//
        ct.put("nguyenlieu",baiVietModel.getNguyenlieu());//
        ct.put("soche",baiVietModel.getSoche());//
        ct.put("thuchien",baiVietModel.getThuchien());//
        ct.put("cachdung",baiVietModel.getCachdung());//
        ct.put("category_id",baiVietModel.getCategory_id());//
        ct.put("vungmien_id",baiVietModel.getVungmien_id());//
        ct.put("hinhanh",baiVietModel.getHinhanh());//
        try {
            long res = db.insertOrThrow(NameTable,null,ct);
            if( res == -1){
                return false;
            }
            return true;
        }catch (SQLException err){
            Log.i("error",err.getMessage());
            return false;
        }
    }

    public boolean delete(int id){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            long res = db.delete(NameTable ,"id = " + id, null );
            if( res == -1)
                return false;
            return true;
        }
        catch (Exception err){
            Log.e("datahelper","delete");
            return false;
        }
    }

    public BaiVietModel getById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try{
            cursor = db.rawQuery("select * from " + NameTable + " where id = " + String.valueOf(id), null);
        }catch (Exception err){
            return null;
        }
        if (cursor.getCount() == 0){
            return null;
        }
        BaiVietModel baiVietModel = null;
        while(cursor.moveToNext()){
            baiVietModel = new BaiVietModel(
                    cursor.getInt(0),//id
                    cursor.getString(1),//ten
                    cursor.getString(2),//nguyenlieu
                    cursor.getString(3),//soche
                    cursor.getString(4),//thuchien
                    cursor.getString(5),//cachdung
                    cursor.getInt(6),//category_id
                    cursor.getInt(7),//vungmien_id
                    cursor.getString(8)//hinhanh
            );
        }
        return baiVietModel;
    }

    public ArrayList<BaiVietModel> getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try{
            cursor = db.rawQuery("select * from " + NameTable , null);
        }catch (Exception err){
            return null;
        }
        if (cursor.getCount() == 0){
            return null;
        }
        ArrayList<BaiVietModel> baiVietModels = new ArrayList<BaiVietModel>();
        while(cursor.moveToNext()){
            BaiVietModel baiVietModel = new BaiVietModel(
                    cursor.getInt(0),//id
                    cursor.getString(1),//ten
                    cursor.getString(2),//nguyenlieu
                    cursor.getString(3),//soche
                    cursor.getString(4),//thuchien
                    cursor.getString(5),//cachdung
                    cursor.getInt(6),//category_id
                    cursor.getInt(7),//vungmien_id
                    cursor.getString(8)//hinhanh
            );
            baiVietModels.add(baiVietModel);
        }
        return baiVietModels;
    }
}
