package com.example.cat201;

import androidx.appcompat.app.AppCompatActivity;



import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.tabs.TabLayout;

public class swipe_tab extends AppCompatActivity {




    TabLayout tabLayout;
    ViewPager2 viewPager2;


   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_tab_dessert);

        tabLayout=findViewById(R.id.swipe_tabLayout);
        viewPager2=findViewById(R.id.swipe_viewPager);
        viewPager2.setAdapter(new devicefragment_adapter(this));
        //setSupportActionBar(toolbar);
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch(position){
                    case 0:
                        tab.setText("Coffee");
                        break;
                    case 1:
                        tab.setText("Soft Drink");
                        break;
                    case 2:
                        tab.setText("desserts");
                        break;

                }

            }
        });
        tabLayoutMediator.attach();


    }

    /*private void setup_new_pager(){

        devicefragment_adapter adapter=new devicefragment_adapter(getSupportFragmentManager());
        adapter.addFrag(new fragment_coffee(),"coffee");
        adapter.addFrag(new fragment_softdrink(),"soft drink");
        adapter.addFrag(new fragment_dessert(),"desserts");

        viewPager2.setAdapter(adapter);
                //.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager2);

    }*/


}