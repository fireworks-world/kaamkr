package com.blakoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterGridCategoryHome extends BaseAdapter {

    Context context;
    private final String [] values;
    private final int [] images;
    View view;
    LayoutInflater layoutInflater;

    public AdapterGridCategoryHome(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            view = new View(context);
            view = layoutInflater.inflate(R.layout.grid_category_home, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.logo_category_view);
            TextView textView = (TextView) view.findViewById(R.id.name_category_view);
            imageView.setImageResource(images[position]);
            textView.setText(values[position]);
        }

        return view;

    }
}
