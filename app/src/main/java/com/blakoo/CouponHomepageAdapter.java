package com.blakoo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class CouponHomepageAdapter extends FragmentPagerAdapter {

    //** Fragment homepage 3 Tab item.

    private int numOftabs;

    CouponHomepageAdapter(FragmentManager fm, int numOftabs) {
        super(fm);
        this.numOftabs = numOftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllFragment();
            case 1:
                return new TravelFragment();
            case 2:
                return new TechFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount(){return numOftabs;}
}
