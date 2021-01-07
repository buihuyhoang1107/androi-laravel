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
import com.example.food_2.Food.FoodInforActivity;
import com.example.food_2.Model.BaiVietModel;
import com.example.food_2.R;
import com.squareup.picasso.Picasso;

import org.json.JSONStringer;

import java.util.ArrayList;

public class BaiVietAdapter extends RecyclerView.Adapter<BaiVietAdapter.BaiVietViewHolder> {

    private ArrayList<BaiVietModel> baiVietModels;
    public static String KEY_BAIVIET = "key_baiviet";

    public BaiVietAdapter(ArrayList<BaiVietModel> baiVietModels) {
        this.baiVietModels = baiVietModels;
    }

    @NonNull
    @Override
    public BaiVietAdapter.BaiVietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_list_food,parent,false);
        return new BaiVietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiVietAdapter.BaiVietViewHolder holder, final int position) {
        holder.title.setText(baiVietModels.get(position).getTen());
        final String img_Api = Config.URL_API + "storage/baiviet/" + baiVietModels.get(position).getHinhanh();
        Picasso.get().load(img_Api).into(holder.img);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),String.valueOf(baiVietModels.get(position).getId()) + baiVietModels.get(position).getTen(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), FoodInforActivity.class);
                intent.putExtra(KEY_BAIVIET, baiVietModels.get(position));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return baiVietModels.size();
    }

    public class BaiVietViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;
        CardView item;

        public BaiVietViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgListFoodAnhitem);
            title = itemView.findViewById(R.id.txtListFoodTitleItem);
            item = itemView.findViewById(R.id.cardview_Item_Food);
        }
    }
}
