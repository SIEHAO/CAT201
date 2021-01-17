package com.example.cat201;

import android.os.Bundle;

import com.example.cat201.foods.Food;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class addfoodActivity extends AppCompatActivity {

    EditText et_add_food_code,et_add_food_name;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    CoordinatorLayout coordinatorLayout;

    List<Food> foods;

    DatabaseReference database_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfood);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_add_food_code=findViewById(R.id.add_food_code);
        et_add_food_name=findViewById(R.id.add_food_name);
        listView=findViewById(R.id.coordinator_layout_listview);
        coordinatorLayout=findViewById(R.id.add_food_coordinator_layout);





        foods=new ArrayList<>();
        loadListView();

        database_food=FirebaseDatabase.getInstance().getReference().child("foods");
        database_food.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                foods.clear();
                adapter.clear();

                for(DataSnapshot foodDataSnapshot:snapshot.getChildren()){



                    Food food=foodDataSnapshot.getValue(Food.class);
                    foods.add(food);
                    adapter.add(food.getFood_code()+"\n"+food.getFood_name());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        FloatingActionButton fab = findViewById(R.id.add_food_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               add_food();



            }
        });
    }

    private void add_food(){

        String code=et_add_food_code.getText().toString().trim();
        String name=et_add_food_name.getText().toString().trim();

        if(!TextUtils.isEmpty(code)||!TextUtils.isEmpty(name)){


            Food new_food=new Food(code,name);
            database_food.push().setValue(new_food);

            et_add_food_code.setText("");
            et_add_food_name.setText("");

            Snackbar.make(coordinatorLayout, "Replace with your own action", Snackbar.LENGTH_LONG).show();

        }

    }


    private void loadListView(){

        listView=findViewById(R.id.coordinator_layout_listview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1);
        listView.setAdapter(adapter);

    }

}