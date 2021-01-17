package com.example.food_2.AsyncTask;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_2.DataHelper.BaivietHelper;
import com.example.food_2.DataHelper.CategoryHelper;
import com.example.food_2.Food.FoodInforActivity;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;

public class ThichBaiVietAsyncTask extends AsyncTask<Boolean,Void,Integer> {

    private Context context;
    private BaivietHelper baivietHelper;
    private CategoryHelper categoryHelper;
    private BaiVietModel baiVietModel;
    private CategoryModel categoryModel;
    private ProgressBar progressBar;
    private MenuItem item;

    public ThichBaiVietAsyncTask(Context context, BaiVietModel baiVietModel, CategoryModel categoryModel, ProgressBar progressBar, MenuItem item){
        this.context = context;
        baivietHelper = new BaivietHelper(context);
        categoryHelper = new CategoryHelper(context);
        this.baiVietModel = baiVietModel;
        this.categoryModel = categoryModel;
        this.progressBar = progressBar;
        progressBar.setVisibility(View.VISIBLE);
        this.item = item;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(Boolean... booleans) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(booleans[0]){
            if(baivietHelper.delete(baiVietModel.getId())){
                booleans[0] = false;
                return 1;
            }
            else
                return 2;
        }
        else {
            categoryHelper.add(categoryModel);
            if(baivietHelper.add(baiVietModel)){
                booleans[0] = true;
                return 3;
            }
            else
                return 4;
        }
    }

    @Override
    protected void onPostExecute(Integer i) {
        super.onPostExecute(i);
        switch (i){
            case 1:{
                Toast.makeText(context,"đã bỏ thích ! " + String.valueOf(baiVietModel.getId()) + " " + baiVietModel.getTen(),Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.ic_baseline_favorite_border_24);
                FoodInforActivity.isliked = false;
            }break;
            case 2:{
                Toast.makeText(context,"Error dontlike" + String.valueOf(baiVietModel.getId()) + " " + baiVietModel.getTen(),Toast.LENGTH_SHORT).show();
            }break;
            case 3:{
                Toast.makeText(context,"đã thích ! " + String.valueOf(baiVietModel.getId()) + " " + baiVietModel.getTen(),Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.ic_baseline_favorite_24);
                FoodInforActivity.isliked = true;
            }break;
            case 4:{
                Toast.makeText(context,"Error like" + String.valueOf(baiVietModel.getId()) + " " + baiVietModel.getTen(),Toast.LENGTH_SHORT).show();
            }break;
            default:break;
        }
        progressBar.setVisibility(View.INVISIBLE);
    }
}
