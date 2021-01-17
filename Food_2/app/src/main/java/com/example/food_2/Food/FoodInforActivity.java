package com.example.food_2.Food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_2.AsyncTask.ThichBaiVietAsyncTask;
import com.example.food_2.DataHelper.BaivietHelper;
import com.example.food_2.Adapter.BaiVietAdapter;
import com.example.food_2.Config;
import com.example.food_2.DataHelper.CategoryHelper;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;
import com.squareup.picasso.Picasso;

public class FoodInforActivity extends AppCompatActivity {

    private BaiVietModel baiVietModel;
    private CategoryModel categoryModel;
    private TextView ten;
    private TextView loai;
    private TextView vungMien;
    private TextView nguyenLieu;
    private TextView soChe;
    private TextView thucHien;
    private TextView cachDung;
    private ImageView hinhAnh;
    private ProgressBar progressBar;

    private Menu menu;

    private BaivietHelper helper;

    public static boolean isliked;


    public FoodInforActivity() {
        super();
        helper = new BaivietHelper(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_food_infor, menu);
        this.menu = menu;
        if(helper.getById(baiVietModel.getId()) != null) {
            MenuItem item = (MenuItem) menu.findItem(R.id.btnMenuLike);
            item.setIcon(R.drawable.ic_baseline_favorite_24);
            isliked = true;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.btnMenuLike:
            {
                new ThichBaiVietAsyncTask(this,baiVietModel,categoryModel,progressBar,item).execute(isliked);
                return true;
            }
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_infor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ten = findViewById(R.id.txtFoodInforTen);
        loai = findViewById(R.id.txtFoodInforLoai);
        vungMien = findViewById(R.id.txtFoodInforVung);
        nguyenLieu = findViewById(R.id.txtFoodInforNguyenLieuContent);
        soChe = findViewById(R.id.txtFoodInforSoCheContent);
        thucHien = findViewById(R.id.txtFoodInforThucHienContent);
        cachDung = findViewById(R.id.txtFoodInforCachDungContent);
        hinhAnh = findViewById(R.id.imgFoodInforAnh);
        progressBar = findViewById(R.id.FoodInfor_progressBar_linking);


        isliked = false;

        Intent intent = getIntent();
        baiVietModel = (BaiVietModel) intent.getSerializableExtra(BaiVietAdapter.KEY_BAIVIET);
        categoryModel = (CategoryModel) intent.getSerializableExtra(BaiVietAdapter.KEY_CATEGORY);



        renderContext();
    }

    private void renderContext() {

        getSupportActionBar().setTitle(baiVietModel.getTen());

        ten.setText(baiVietModel.getTen());
        loai.setText(categoryModel.getTitle());
        nguyenLieu.setText(baiVietModel.getNguyenlieu());
        soChe.setText(baiVietModel.getSoche());
        thucHien.setText(baiVietModel.getThuchien());
        cachDung.setText(baiVietModel.getCachdung());
        Picasso.get().load(Config.URL_API + "storage/baiviet/" + baiVietModel.getHinhanh()).into(hinhAnh);
    }
}