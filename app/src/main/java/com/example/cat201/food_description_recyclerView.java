package com.example.cat201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class food_description_recyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_description_recycler_view);

        Intent intent=getIntent();
        TextView food_text_name,food_text_description;
        ImageView food_detail_recycler;
        food_text_name=findViewById(R.id.food_detail_text_view);
        food_text_description=findViewById(R.id.food_detail_description);
        food_detail_recycler=findViewById(R.id.food_detail_image);

        food_text_name.setText(intent.getStringExtra("food name"));
        food_text_description.setText(intent.getStringExtra("food description"));
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            int food_image=bundle.getInt("food image");
            food_detail_recycler.setImageResource(food_image);
        }




    }
}