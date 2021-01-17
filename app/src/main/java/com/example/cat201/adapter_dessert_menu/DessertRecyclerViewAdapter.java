package com.example.cat201.adapter_dessert_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.cat201.R;
import com.example.cat201.adapter_food_menu.food_recyclerView_adapter;
import com.example.cat201.dessert;

import java.util.List;


public class DessertRecyclerViewAdapter extends  RecyclerView.Adapter<DessertRecyclerViewAdapter.DessertViewHolder>{


    public List<dessert> dessert_list;
    private Context context;


    public DessertRecyclerViewAdapter(Context context,List<dessert> dessert_list) {

        this.context=context;
        this.dessert_list=dessert_list;
    }

    @NonNull
    @Override
    public DessertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View  dessert_menu= LayoutInflater.from(parent.getContext()).inflate(R.layout.desserts_row,null);

        DessertViewHolder dessertHolder=new DessertViewHolder(dessert_menu);

        return dessertHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DessertViewHolder holder, int position) {

        holder.tvDessert_name.setText(dessert_list.get(position).getName());
        holder.imgViewImage.setImageResource(dessert_list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return dessert_list.size();
    }

    public class DessertViewHolder extends RecyclerView.ViewHolder
    {

        public TextView tvDessert_name;
        public ImageView imgViewImage;


        public DessertViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDessert_name=itemView.findViewById(R.id.dessert_name_text);
            imgViewImage=itemView.findViewById(R.id.image_dessert);
        }
    }


}
