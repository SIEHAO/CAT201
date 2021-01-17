package com.example.cat201.swipe_adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cat201.fragment_coffee;
import com.example.cat201.fragment_dessert;
import com.example.cat201.fragment_softdrink;

import java.util.ArrayList;
import java.util.List;

public class devicefragment_adapter extends FragmentStateAdapter {

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> mfragmentTitleList=new ArrayList<>();


    public devicefragment_adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position){
            case 0:
                return new fragment_coffee();
            case 1:
                return new fragment_softdrink();
            default:
                return new fragment_dessert();
        }

    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
