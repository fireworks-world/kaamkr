package com.blakoo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CouponCategoryAdapter extends ArrayAdapter<CouponCategory>{

    public CouponCategoryAdapter(Context context, List<CouponCategory> couponcategory) {
        super(context, 0, couponcategory);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.coupon_list_item, parent, false);
        }

        // Get the object located at this position in the list
        final CouponCategory currentCouponCategory = getItem(position);


        // Find the TextView in the coupon_list_item.xml layout with the ID storename
        TextView storenameTextView = (TextView) listItemView.findViewById(R.id.storename);
        storenameTextView.setText("Store: " + currentCouponCategory.getStoreName());

        // Find the TextView in the coupon_list_item.xml layout with the ID coupon_short_description
        TextView couponshortdescriptionTextView = (TextView) listItemView.findViewById(R.id.coupon_short_description);
        couponshortdescriptionTextView.setText(currentCouponCategory.getCouponShortDescription());

        // Find the TextView in the coupon_list_item.xml layout with the ID promocode
        TextView promocodeTextView = (TextView) listItemView.findViewById(R.id.promocode);
        promocodeTextView.setText("Code: " + currentCouponCategory.getPromoCode());

        // Find the TextView in the coupon_list_item.xml layout with the ID rating
        TextView ratingTextView = (TextView) listItemView.findViewById(R.id.rating);
        ratingTextView.setText("Rating: " + currentCouponCategory.getRating());

        // Find the TextView in the coupon_list_item.xml layout with the ID go_to_store
        ImageView descriptionTextView = (ImageView) listItemView.findViewById(R.id.go_to_store);
        descriptionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentCouponCategory.getDescription()));
                getContext().startActivity(browserIntent);
            }
        });

        // Return list view
        return listItemView;
    }


}