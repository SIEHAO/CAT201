package com.example.cat201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cat201.adapter_dessert_menu.DessertRecyclerViewAdapter;
import com.example.cat201.adapter_food_menu.food_recyclerView_adapter;

import java.util.ArrayList;
import java.util.List;

public class desserts_menu extends AppCompatActivity {


    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts_menu);
        RecyclerView recyclerView=findViewById(R.id.recycler_view_dessert);
        linearLayoutManager=new LinearLayoutManager(desserts_menu.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<dessert> all_dessert=get_dessert_info();
         DessertRecyclerViewAdapter dessertRecyclerViewAdapter=new DessertRecyclerViewAdapter(desserts_menu.this,all_dessert);
        recyclerView.setAdapter(dessertRecyclerViewAdapter);
    }


    private List<dessert> get_dessert_info(){

        List<dessert> dessert_object=new ArrayList<dessert>();
        dessert_object.add(new dessert("souffle pancake",R.drawable.souffle_pancake,"A Japanese soufflé pancake is a pancake made using soufflé techniques. Egg whites are whipped up with sugar into a glossy thick meringue then mixed with a batter made with the yolks."));
        dessert_object.add(new dessert("Matcha Bingsu",R.drawable.matcha_bingsu,"Pat Bingsu comes with cornflakes, a dollop of sweet red bean, mochi pieces, and vanilla ice-cream."));
        dessert_object.add(new dessert("oreo cheese cake",R.drawable.cake_2,"Frozen cream cheese with loads of crushed oreo biscuits."));

        dessert_object.add(new dessert("",R.drawable.souffle_pancake,"A Japanese soufflé pancake is a pancake made using soufflé techniques. Egg whites are whipped up with sugar into a glossy thick meringue then mixed with a batter made with the yolks."));
        dessert_object.add(new dessert("souffle pancake",R.drawable.souffle_pancake,"A Japanese soufflé pancake is a pancake made using soufflé techniques. Egg whites are whipped up with sugar into a glossy thick meringue then mixed with a batter made with the yolks."));

        return dessert_object;

    }


}