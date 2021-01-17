package com.example.cat201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cat201.adapter_food_menu.food_recyclerView_adapter;

import java.util.ArrayList;
import java.util.List;

public class food_menu extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        RecyclerView recyclerView=findViewById(R.id.recycler_view_food_menu);
        linearLayoutManager=new LinearLayoutManager(food_menu.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<cuisine_object> menu_cuisine=getInfo();
        food_recyclerView_adapter food_menu_recyclerView=new food_recyclerView_adapter(food_menu.this,menu_cuisine);
        recyclerView.setAdapter(food_menu_recyclerView);
    }

    private List<cuisine_object> getInfo(){

        List<cuisine_object> cuisine_menu=new ArrayList<cuisine_object>();

        cuisine_menu.add(new cuisine_object("Spaghetti Carrettiera",R.drawable.spagetti));
        cuisine_menu.add(new cuisine_object("salted egg burger",R.drawable.salted_egg_burger));
        cuisine_menu.add(new cuisine_object("char keuy teow",R.drawable.char_keuy_teow));
        cuisine_menu.add(new cuisine_object("Penang Laksa",R.drawable.laksa));
        cuisine_menu.add(new cuisine_object("fish and chips",R.drawable.fish_and_chips));
        cuisine_menu.add(new cuisine_object("Vegan chickpea veggie burger",R.drawable.vegan_burger));

        return cuisine_menu;
    }

}