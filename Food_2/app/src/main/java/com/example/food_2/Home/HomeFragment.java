package com.example.food_2.Home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.food_2.Adapter.BaiVietAdapter;
import com.example.food_2.Adapter.CategoryAdapter;
import com.example.food_2.Config;
import com.example.food_2.Food.FoodInforActivity;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HomeFragment extends Fragment {

    private CategoryModel category;
    private ArrayList<BaiVietModel> baiVietModels;
    private RecyclerView recyclerView;
    private BaiVietAdapter adapter;
    private BaiVietModel baiVietModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        category = new CategoryModel();
        baiVietModels = new ArrayList<BaiVietModel>();

        recyclerView = getView().findViewById(R.id.RCV_Home);
        baiVietModel = new BaiVietModel();
        getRandomBaiViet();
    }

    private void getRandomBaiViet() {
        try{

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            String url = Config.URL_API + "api/baiviets/random";
            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject object = new JSONObject(response);
                                baiVietModel.setCategory_id(object.getInt("category_id"));
                                baiVietModel.setId(object.getInt("id"));
                                baiVietModel.setTen(object.getString("ten"));
                                baiVietModel.setNguyenlieu(object.getString("nguyenlieu"));
                                baiVietModel.setSoche(object.getString("soche"));
                                baiVietModel.setThuchien(object.getString("thuchien"));
                                baiVietModel.setCachdung(object.getString("cachdung"));
                                baiVietModel.setHinhanh(object.getString("hinhanh"));
                                baiVietModel.setVungmien_id(object.getInt("vungmien_id"));

                                genderBaiViet();
                                getDataCategory();

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e("err",e.getMessage());
                            }
                        }
                    },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });

            requestQueue.add(request);
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    private void getDataCategory() {
        try {
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            String url = Config.URL_API + "api/categories/" + String.valueOf(baiVietModel.getCategory_id());
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            getDataFromResponse(response);
                        }

                        private void getDataFromResponse(String response) {
                            try {
                                JSONObject object = new JSONObject(response);
                                category.setTitle(object.getString("title"));
                                category.setImg(object.getString("hinhanh"));
                                category.setId(object.getInt("id"));


                                getDataFood();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Log.e("err","errr");
                }
            });
            //call api
            queue.add(stringRequest);
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    private void getDataFood() {
        try{

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            String url = Config.URL_API + "api/baiviets/category/" + String.valueOf(category.getId());
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
                                genderBaiViet();
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e("err",e.getMessage());
                            }
                        }
                    },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });

            requestQueue.add(request);
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    private void genderBaiViet() {
        try{
            TextView title = getActivity().findViewById(R.id.txtHomeTitleItem);
            ImageView imageView = getActivity().findViewById(R.id.imgHomeAnhitem);
            String url = Config.URL_API+ "storage/baiviet/" + baiVietModel.getHinhanh();
            Picasso.get().load(url).into(imageView);
            title.setText(baiVietModel.getTen());
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    private void configRCV() {
        try {
            adapter = new BaiVietAdapter(baiVietModels,category);
            recyclerView.setAdapter(adapter);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2, GridLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(gridLayoutManager);
            View view = getActivity().findViewById(R.id.fragment_home_cardView_item);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),String.valueOf(baiVietModel.getId()) + baiVietModel.getTen(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), FoodInforActivity.class);
                    intent.putExtra( BaiVietAdapter.KEY_BAIVIET, baiVietModel);
                    intent.putExtra(BaiVietAdapter.KEY_CATEGORY, category);
                    v.getContext().startActivity(intent);
                }
            });
        }catch (Exception err){
            err.printStackTrace();
        }


    }
}
