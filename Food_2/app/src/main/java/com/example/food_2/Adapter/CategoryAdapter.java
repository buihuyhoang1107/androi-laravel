package com.example.food_2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_2.Model.Category;
import com.example.food_2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> categories;

    public CategoryAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_search,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.title.setText(categories.get(position).getTitle());
        Picasso.get().load(categories.get(position).getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_search_img);
            title = itemView.findViewById(R.id.item_search_title);
        }
    }
}
