package com.blakoo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TravelFragment extends Fragment {

    private Object MenuItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_travel, container, false);
    }

    //** View for the All tab in homepage.

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // Create a fake list of earthquakes.
        ArrayList<CouponCategory> couponcategory = CouponUtils.extractCouponcategory();

        // Find a reference to the {@link ListView} in the layout
        ListView couponcategoryListView = view.findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of coupon code
        CouponCategoryAdapter adapter = new CouponCategoryAdapter(view.getContext(), couponcategory);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        couponcategoryListView.setAdapter(adapter);

    }

}