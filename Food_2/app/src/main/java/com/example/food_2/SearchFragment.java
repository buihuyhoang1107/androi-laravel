package com.example.food_2;

import android.os.Bundle;
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
import com.example.food_2.Model.Category;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private ArrayList<Category> categories;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    public SearchFragment() {
        super();
        categories = new ArrayList<Category>();
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
    }

    private void getDataCategory() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://coderthanhson.000webhostapp.com/api/categories";
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
                                    Category category = new Category();
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
                        TextView test = getView().findViewById(R.id.textView2);
                        test.setText("That didn't work!");
                    }
        });
        //call api
        queue.add(stringRequest);
    }

    private void configRCV() {
        adapter = new CategoryAdapter(categories);
        recyclerView = getView().findViewById(R.id.fragment_search_RCV);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }
}
