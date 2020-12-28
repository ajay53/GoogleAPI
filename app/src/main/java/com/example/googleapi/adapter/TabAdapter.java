package com.example.googleapi.adapter;

import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.googleapi.view.BooksFragment;
import com.example.googleapi.view.NewsFragment;

public class TabAdapter extends FragmentStateAdapter {
    private static final String TAG = "PagerAdapter";

    private final int tabCount;

    public TabAdapter(@NonNull FragmentActivity fragmentActivity, int tabCount) {
        super(fragmentActivity);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new BooksFragment();
                break;
            case 1:
                fragment = new NewsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }


//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        Fragment fragment = null;
//        switch (position){
//            case 0:
//                fragment = new BooksFragment();
//                break;
//            case 1:
//                fragment = new NewsFragment();
//                break;
//        }
//        return fragment;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return POSITION_NONE;
//    }
//
//    @Override
//    public int getCount() {
//        return tabCount;
//    }
}
