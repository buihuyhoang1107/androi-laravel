package com.example.food_2.Food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.food_2.Adapter.BaiVietAdapter;
import com.example.food_2.Config;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.R;
import com.squareup.picasso.Picasso;

public class FoodInforActivity extends AppCompatActivity {

    private TextView ten;
    private TextView loai;
    private TextView vungMien;
    private TextView nguyenLieu;
    private TextView soChe;
    private TextView thucHien;
    private TextView cachDung;
    private ImageView hinhAnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_infor);

        ten = findViewById(R.id.txtFoodInforTen);
        nguyenLieu = findViewById(R.id.txtFoodInforNguyenLieuContent);
        soChe = findViewById(R.id.txtFoodInforSoCheContent);
        thucHien = findViewById(R.id.txtFoodInforThucHienContent);
        cachDung = findViewById(R.id.txtFoodInforCachDungContent);
        hinhAnh = findViewById(R.id.imgFoodInforAnh);


        renderContext();
    }

    private void renderContext() {
        Intent intent = getIntent();
        BaiVietModel baiVietModel = (BaiVietModel) intent.getSerializableExtra(BaiVietAdapter.KEY_BAIVIET);
        ten.setText(baiVietModel.getTen());
        nguyenLieu.setText(baiVietModel.getNguyenlieu());
        soChe.setText(baiVietModel.getSoche());
        thucHien.setText(baiVietModel.getThuchien());
        cachDung.setText(baiVietModel.getCachdung());
        Picasso.get().load(Config.URL_API + "storage/baiviet/" + baiVietModel.getHinhanh()).into(hinhAnh);
    }
}