package com.example.food_2.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.food_2.Adapter.CategoryAdapter;
import com.example.food_2.Config;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private ArrayList<CategoryModel> categories;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    public SearchFragment() {
        super();
        categories = new ArrayList<CategoryModel>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataCategory();

        TextView test = getView().findViewById(R.id.textView2);
        test.setText("Loại món ăn");

        recyclerView = getView().findViewById(R.id.fragment_search_RCV);

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
                                configRCV();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Search","err");
                    error.printStackTrace();
                }
            });
            //call api
            queue.add(stringRequest);

        }catch (Exception err){
            err.printStackTrace();
        }
    }

    private void configRCV() {
        adapter = new CategoryAdapter(categories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }
}
