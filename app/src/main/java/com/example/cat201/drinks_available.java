package com.example.cat201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.cat201.foods.Drink;
import com.example.cat201.foods.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class drinks_available extends AppCompatActivity {

    EditText et_drink_code,et_drink_name;
    Spinner spinner_food;
    ListView listView_drink;
    ToggleButton Toggle_btn_Status;
    Button add_drink_btn,update_drink_btn;

    List<Food> foods;
    List<Drink> drinks;

    DatabaseReference database_foods;
    DatabaseReference database_drinks;

    private ArrayAdapter<String> list_adapter;
    private ArrayAdapter<String> spinner_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_available);

        et_drink_code=findViewById(R.id.add_et_drink_code);
        et_drink_name=findViewById(R.id.add_et_drink_name);
        spinner_food=findViewById(R.id.add_food_spinner);
        Toggle_btn_Status=findViewById(R.id.add_drinks_status_toggle_button);
        listView_drink=findViewById(R.id.drink_list_view);
        add_drink_btn=findViewById(R.id.add_drink_btn);
        update_drink_btn=findViewById(R.id.update_drink_btn);
        spinner_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        spinner_food.setAdapter(spinner_adapter);


        list_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1);
        listView_drink.setAdapter(list_adapter);



        database_foods= FirebaseDatabase.getInstance().getReference("foods");
        database_drinks=FirebaseDatabase.getInstance().getReference("drinks");

        foods=new ArrayList<>();
        drinks=new ArrayList<>();



        database_foods.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                foods.clear();
                spinner_adapter.clear();

                for(DataSnapshot foodsDataSnapshot : snapshot.getChildren()){

                    Food food=foodsDataSnapshot.getValue(Food.class);
                    foods.add(food);
                    spinner_adapter.add(food.getFood_code()+"\n"+food.getFood_name());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database_drinks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                drinks.clear();
                list_adapter.clear();
                for(DataSnapshot drinksDataSnapshot:snapshot.getChildren()){

                    Drink drink=drinksDataSnapshot.getValue(Drink.class);
                    drinks.add(drink);
                    list_adapter.add(drink.getDrink_code()+" "+drink.getDrink_name()+"\n"+
                            drink.getDrink_food()+" "+drink.getDrink_status());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        add_drink_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add_drink();

            }
        });

        update_drink_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code=et_drink_code.getText().toString().trim();
                String name=et_drink_name.getText().toString().trim();
                String food=foods.get(spinner_food.getSelectedItemPosition()).getFood_name();
                Boolean status=Toggle_btn_Status.isChecked();
                if(!TextUtils.isEmpty(code) && !TextUtils.isEmpty(name)){

                    update_drink(code,name,food,status);

                }



            }
        });




        listView_drink.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Drink drink=drinks.get(position);
                AlertDialog.Builder alert=new AlertDialog.Builder(drinks_available.this);
                alert.setTitle("Delete information");
                alert.setMessage("data will be permanently deleted");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DatabaseReference dataRef=FirebaseDatabase.getInstance().getReference("drinks").child(drink.getDrink_ID());
                        dataRef.removeValue();
                        Toast.makeText(getApplicationContext(),"Drink deleted",Toast.LENGTH_LONG).show();

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });

                alert.show();
                return false;
            }
        });



    }

    private void add_drink(){

        String code=et_drink_code.getText().toString().trim();
        String name=et_drink_name.getText().toString().trim();
        String food=foods.get(spinner_food.getSelectedItemPosition()).getFood_name();
        Boolean status=Toggle_btn_Status.isChecked();
        if(!TextUtils.isEmpty(code) && !TextUtils.isEmpty(name)){

            String id = database_foods.push().getKey();
            Drink drinks=new Drink(id,code,name,food,status);
            database_drinks.child(id).setValue(drinks);

            et_drink_code.setText("");
            et_drink_name.setText("");

            Toast.makeText(drinks_available.this,"drinks is available in this cuisine",Toast.LENGTH_SHORT).show();

        }


    }

    private void update_drink(String code,String name,String food,Boolean status){


        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
        databaseReference.child("drinks").orderByChild("drink_code").equalTo(code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.hasChildren()){

                    DataSnapshot firstChild=snapshot.getChildren().iterator().next();
                    firstChild.getRef().child("drink_code").setValue(code);
                    firstChild.getRef().child("drink_name").setValue(name);
                    firstChild.getRef().child("drink_food").setValue(food);
                    firstChild.getRef().child("drink_status").setValue(status);

                    Toast.makeText(getApplicationContext(),"drink updated",Toast.LENGTH_SHORT);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}