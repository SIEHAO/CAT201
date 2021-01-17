package com.example.cat201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    Button btn_register_food,btn_register_drinks,food_menu_bttn,main_swipe_btn;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_register_food=findViewById(R.id.main_btn_register_food);
        btn_register_drinks=findViewById(R.id.main_btn_register_drinks);
        food_menu_bttn=findViewById(R.id.food_menu_btn);
        main_swipe_btn=findViewById(R.id.main_swipe_tab);

        btn_register_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,addfoodActivity.class);
                startActivity(intent);

            }
        });

        btn_register_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,drinks_available.class);
                startActivity(intent);

            }
        });

        food_menu_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,food_menu.class);
                startActivity(intent);

            }
        });

        main_swipe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, desserts_menu.class);
                startActivity(intent);

            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth=FirebaseAuth.getInstance();
        mFirebaseUser=mFirebaseAuth.getCurrentUser();

        if(mFirebaseUser==null){

            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_logout){

            mFirebaseAuth.signOut();
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);





        }

        return super.onOptionsItemSelected(item);
    }
}