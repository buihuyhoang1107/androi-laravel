package com.example.food_2.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HomeFragment extends Fragment {

    private ArrayList<CategoryModel> categories;
    private ArrayList<BaiVietModel> baiVietModels;
    private RecyclerView recyclerView;
    private BaiVietAdapter adapter;
    private CategoryModel SeletedCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        categories = new ArrayList<CategoryModel>();
        baiVietModels = new ArrayList<BaiVietModel>();
        SeletedCategory = new CategoryModel();
        recyclerView = getView().findViewById(R.id.RCV_Home);

        getDataCategory();
    }

    private void getDataCategory() {
        try {
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            String url = Config.URL_API + "api/categories";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            getDataFromResponse(response);
                        }

                        private void getDataFromResponse(String response) {
                            try {
                                JSONArray jArray = new JSONArray(response);
                                if (jArray != null) {
                                    for (int i=0;i<jArray.length();i++){
                                        CategoryModel category = new CategoryModel();
                                        category.setTitle(jArray.getJSONObject(i).getString("title"));
                                        category.setImg(jArray.getJSONObject(i).getString("hinhanh"));
                                        category.setId(jArray.getJSONObject(i).getInt("id"));

                                        categories.add(category);
                                    }
                                }
                                Random rn = new Random();
                                int answer = rn.nextInt(categories.size());
                                Log.i("answer",String.valueOf(answer));
                                Log.i("answer",String.valueOf(categories.size()));
                                SeletedCategory = categories.get(answer);
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

                                        if(baiVietModel.getCategory_id() != SeletedCategory.getId()) continue;

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
        Random rn = new Random();
        int answer = rn.nextInt(baiVietModels.size()) ;
        BaiVietModel baiVietModel = baiVietModels.get(answer);
        TextView title = getActivity().findViewById(R.id.txtHomeTitleItem);
        ImageView imageView = getActivity().findViewById(R.id.imgHomeAnhitem);
        String url = Config.URL_API+ "storage/baiviet/" + baiVietModel.getHinhanh();
        Picasso.get().load(url).into(imageView);
        title.setText(baiVietModel.getTen());
    }

    private void configRCV() {
        adapter = new BaiVietAdapter(baiVietModels,SeletedCategory);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2, GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
