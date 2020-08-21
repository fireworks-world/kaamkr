package com.blakoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LogoStoreHomePageAdapter extends RecyclerView.Adapter<LogoStoreHomePageAdapter.MyViewHolder> {

    //** Customer adapter for logo store in homepage.

    private Context context;
    private List<LogoStoreHomePage> apps;

    public LogoStoreHomePageAdapter(Context context, List<LogoStoreHomePage> apps) {
        this.context = context;
        this.apps = apps;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mImage = itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public LogoStoreHomePageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.logostore_homepage_layout_list,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LogoStoreHomePageAdapter.MyViewHolder holder, int position) {

        LogoStoreHomePage app = apps.get(position);

        holder.mName.setText(app.getName());
        holder.mImage.setImageResource(app.getImage());

    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

}
