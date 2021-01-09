package com.example.food_2.Home;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_2.Adapter.BaiVietAdapter;
import com.example.food_2.Adapter.CategoryAdapter;
import com.example.food_2.Adapter.FavoritesAdapter;
import com.example.food_2.DataHelper.BaivietHelper;
import com.example.food_2.DataHelper.CategoryHelper;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {


    private BaivietHelper baivietHelper;
    private ArrayList<BaiVietModel> baiVietModels;
    private RecyclerView recyclerView;
    private FavoritesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
        configRCV();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        baivietHelper = new BaivietHelper(getContext());
        baiVietModels = new ArrayList<BaiVietModel>();
        recyclerView = getActivity().findViewById(R.id.rcvFavorites);

        getData();
        configRCV();
    }

    private void configRCV() {
        adapter = new FavoritesAdapter(baiVietModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getData() {
        baiVietModels = baivietHelper.getAll();
    }
}
