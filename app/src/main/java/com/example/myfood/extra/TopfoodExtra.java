package com.example.myfood.extra;

import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.example.myfood.R;
import com.example.myfood.model.Topfood;

import java.util.List;

public class TopfoodExtra extends RecyclerView.Adapter<TopfoodExtra.TopfoodViewHolder>{

    Context context;
    List<Topfood> TopfoodList;

    public TopfoodExtra(Context context, List<Topfood> topfoodList) {
        this.context = context;
        this.TopfoodList = topfoodList;
    }

    @NonNull
    @Override
    public TopfoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_food_row_item,parent,false);
        return new TopfoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopfoodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return TopfoodList.size();
    }

    public static final class TopfoodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView price,name;


        public TopfoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.food_image);
            name=itemView.findViewById(R.id.quiche);
            price=itemView.findViewById(R.id.quiche_price);
        }


    }
}

