package com.example.food_2.Food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.food_2.Adapter.BaiVietAdapter;
import com.example.food_2.Adapter.CategoryAdapter;
import com.example.food_2.Config;
import com.example.food_2.Home.SearchFragment;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ListFoodCaregoryActivity extends AppCompatActivity {

    private ArrayList<BaiVietModel> baiVietModels;
    private RecyclerView recyclerView;
    private BaiVietAdapter adapter;
    private TextView Title;
    private int idCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food_caregory);

        baiVietModels = new ArrayList<BaiVietModel>();
        recyclerView = findViewById(R.id.rcvListFood);


        Title = findViewById(R.id.txtListFoodCategory);
        Intent intent = getIntent();
        Title.setText(intent.getStringExtra(CategoryAdapter.TITLE_CATEGORY));
        idCategory = intent.getIntExtra(CategoryAdapter.ID_CATEGORY,0);
        getDataFood();

    }

    private void getDataFood() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = Config.URL_API + "api/baiviets";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jArray = new JSONArray(response);
                            if (jArray != null) {


                                for (int i = 0; i < jArray.length(); i++) {

                                    BaiVietModel baiVietModel = new BaiVietModel();
                                    baiVietModel.setCategory_id(jArray.getJSONObject(i).getInt("category_id"));

                                    if(baiVietModel.getCategory_id() != idCategory) continue;

                                    baiVietModel.setId(jArray.getJSONObject(i).getInt("id"));
                                    baiVietModel.setTen(jArray.getJSONObject(i).getString("ten"));
                                    baiVietModel.setNguyenlieu(jArray.getJSONObject(i).getString("nguyenlieu"));
                                    baiVietModel.setSoche(jArray.getJSONObject(i).getString("soche"));
                                    baiVietModel.setThuchien(jArray.getJSONObject(i).getString("thuchien"));
                                    baiVietModel.setCachdung(jArray.getJSONObject(i).getString("cachdung"));
                                    baiVietModel.setHinhanh(jArray.getJSONObject(i).getString("hinhanh"));
                                    baiVietModel.setVungmien_id(jArray.getJSONObject(i).getInt("vungmien_id"));

                                    baiVietModels.add(baiVietModel);
                                }
                            }
                            configRCV();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Title.setText("Error");
            }
        });

        requestQueue.add(request);
    }
    private void configRCV() {
        adapter = new BaiVietAdapter(baiVietModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}