package com.example.food_2;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.food_2.Model.Category;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private ArrayList<Category> categories;


    public SearchFragment() {
        super();
        categories =new ArrayList<Category>();
    }

    private void getDataCategory() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://coderthanhson.000webhostapp.com/api/categories";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        TextView test = getView().findViewById(R.id.textView2);
                        test.setText(response.substring(0, 100));
                        ;
                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        TextView test = getView().findViewById(R.id.textView2);
                        test.setText("That didn't work!");
                    }
        });
        queue.add(stringRequest);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDataCategory();
        return inflater.inflate(R.layout.fragment_search,container,false);
    }
}
