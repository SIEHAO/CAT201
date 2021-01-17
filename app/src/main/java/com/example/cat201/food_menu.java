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

        cuisine_menu.add(new cuisine_object("Spaghetti Carrettiera",R.drawable.spagetti,"More than a century ago, carrettieri—cart drivers—would roam the Italian peninsula selling tools, cookware, wine, fabrics, and basic cooking ingredients like grain, preserved fish, and oil. Their peripatetic lifestyle meant they often had to feed themselves on the road. One of their standbys was a simple pasta sauce that came to be known as alla carrettiera, or in the style of the cart driver." ));
        cuisine_menu.add(new cuisine_object("salted egg burger",R.drawable.salted_egg_burger,"Lay cucumber slices and lettuce on the bottom burger bun, followed by the fried chicken and then, drizzle over the salted egg sauce."));
        //cuisine_menu.add(new cuisine_object("char keuy teow",R.drawable.char_keuy_teow,"In Hokkien, Char means “stir-fried” and kway teow refers to flat rice noodles. The dish is considered a national favourite in Malaysia and Singapore."));
        cuisine_menu.add(new cuisine_object("Penang Laksa",R.drawable.laksa," Laksa consists of thick wheat noodles or rice vermicelli with chicken, prawn or fish, served in spicy soup based on either rich and spicy curry coconut milk or on sour asam."));
        cuisine_menu.add(new cuisine_object("fish and chips",R.drawable.fish_and_chips,"Fish and chips is a hot dish consisting of fried fish in batter, served with chips."));
        cuisine_menu.add(new cuisine_object("Vegan chickpea veggie burger",R.drawable.vegan_burger,"In Hokkien, Char means “stir-fried” and kway teow refers to flat rice noodles. The dish is considered a national favourite in Malaysia and Singapore."));
        cuisine_menu.add(new cuisine_object("Pad Thai",R.drawable.pad_thai,"Pad thai, or phad thai, is a stir-fried rice noodle dish commonly served as a street food and at most restaurants in Thailand"));
        cuisine_menu.add(new cuisine_object("fish and chips",R.drawable.fish_and_chips,"Fish and chips is a hot dish consisting of fried fish in batter, served with chips."));
        return cuisine_menu;
    }

}