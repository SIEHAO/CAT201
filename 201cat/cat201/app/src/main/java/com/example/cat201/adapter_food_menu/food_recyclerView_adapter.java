package com.example.cat201.adapter_food_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cat201.R;
import com.example.cat201.cuisine_object;


import java.util.List;

public class food_recyclerView_adapter extends RecyclerView.Adapter<food_recyclerView_adapter.FoodViewHolder>{


    public List<cuisine_object> food_menuList;
    private Context context;


    public food_recyclerView_adapter(Context context,List<cuisine_object> food_menuList) {

        this.context=context;
        this.food_menuList=food_menuList;


    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View food_menu= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_row_menu,null);

        FoodViewHolder foodViewHolder=new FoodViewHolder(food_menu);
        return foodViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        holder.tvView_food_name.setText(food_menuList.get(position).getName());
        holder.img_menu_food.setImageResource(food_menuList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return food_menuList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{


          public TextView tvView_food_name;
          public ImageView img_menu_food;


          public FoodViewHolder(@NonNull View itemView) {

              super(itemView);
              tvView_food_name=itemView.findViewById(R.id.cuisine_tv_spaghetti);
              img_menu_food=itemView.findViewById(R.id.food_menu_spaghetti);

          }
      }

    }


