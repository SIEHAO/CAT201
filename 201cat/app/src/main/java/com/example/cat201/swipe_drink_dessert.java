package com.example.cat201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cat201.swipe_adapter.devicefragment_adapter;
import com.google.android.material.tabs.TabLayout;

public class swipe_drink_dessert extends AppCompatActivity {



    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_tab_dessert);
        toolbar=findViewById(R.id.toolbar_swipe);
        tabLayout=findViewById(R.id.tabs_swipe);
        viewPager=findViewById(R.id.swipe_view_page);
        setSupportActionBar(toolbar);
        setup_new_pager();
    }

    private void setup_new_pager(){

        devicefragment_adapter adapter=new devicefragment_adapter(getSupportFragmentManager());
        adapter.addFrag(new fragment_coffee(),"coffee");
        adapter.addFrag(new fragment_softdrink(),"soft drink");
        adapter.addFrag(new fragment_dessert(),"desserts");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


}