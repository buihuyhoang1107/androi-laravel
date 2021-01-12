package com.example.food_2.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_2.Config;
import com.example.food_2.Food.ListFoodCaregoryActivity;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.Model.CategoryModel;
import com.example.food_2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<CategoryModel> categories;
    public static final String KEY_CATEGORY = "key_Category";


    public CategoryAdapter(ArrayList<CategoryModel> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_search,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.CategoryViewHolder holder, final int position) {
        holder.title.setText(categories.get(position).getTitle());
        final String img_Api = Config.URL_API + "storage/category/" + categories.get(position).getImg();
        Picasso.get().load(img_Api).into(holder.img);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),String.valueOf(categories.get(position).getId()) + categories.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), ListFoodCaregoryActivity.class);
                intent.putExtra(KEY_CATEGORY,categories.get(position));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return categories.size();
        }
        catch (Exception err){
            return 0;
        }
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private CardView item;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_search_img);
            title = itemView.findViewById(R.id.item_search_title);
            item = itemView.findViewById(R.id.cardview_Item_Search);
        }
    }
}
