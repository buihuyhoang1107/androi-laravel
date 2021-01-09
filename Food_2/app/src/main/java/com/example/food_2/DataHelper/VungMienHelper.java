package com.example.food_2.DataHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.food_2.Model.CategoryModel;
import com.example.food_2.Model.VungMienModel;

import java.util.ArrayList;

public class VungMienHelper extends SQLiteOpenHelper {

    private SQLiteDatabase dbread = getReadableDatabase();
    private SQLiteDatabase dbwrite = getWritableDatabase();
    private String NameTable = "vungmiens";

    public VungMienHelper(@Nullable Context context) {
        super(context, ConfigHelper.DATADASE_NAME, null, ConfigHelper.Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + NameTable + "(id interger primary key, ten_vungmien text not null, noidung not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + NameTable);
        db.execSQL("Create table " + NameTable + "(id interger primary key, ten_vungmien text not null, noidung not null)");
    }

    public void update(ArrayList<VungMienModel> vungMienModels){
        for (VungMienModel vm: vungMienModels) {
            ContentValues ct = new ContentValues();
            ct.put("id",vm.getId());
            ct.put("ten_vungmien",vm.getTen_vungmien());
            ct.put("noidung",vm.getNoidung());
            dbwrite.insert(NameTable,null,ct);
        }
    }

    public boolean add(VungMienModel vungMienModel){
        ContentValues ct = new ContentValues();
        ct.put("id",vungMienModel.getId());
        ct.put("ten_vungmien",vungMienModel.getNoidung());
        ct.put("noidung",vungMienModel.getNoidung());
        if(dbwrite.insert(NameTable,null,ct) == -1)
            return false;
        return true;
    }

    public boolean delete(int id){
        if(dbwrite.delete(NameTable,"id = " + id, null ) == -1)
            return false;
        return true;
    }

    public VungMienModel getById(int id){
        Cursor cursor = dbread.rawQuery("select * from " + NameTable + " where id = " + String.valueOf(id), null);
        if (cursor.getCount() == 0)
            return null;
        VungMienModel vungMienModel = null;
        while(cursor.moveToNext()){
            vungMienModel = new VungMienModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );

        }
        return vungMienModel;
    }
}
