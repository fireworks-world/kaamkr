package com.blakoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;
    //** GRIDVIEW HOMEPAGE
    GridView gridView;
    int current_position = 0;

    String[] values = {
            "Beauty & Health",
            "Electronics",
            "Toys & Hobbies",
            "Sport & Outdoor",
            "Travel",
            "Vehicles",
            "Jewelry",
            "Clothing & Shoes",
            "Home Items"
    };

    int[] images = {
            R.drawable.ic_beauty,
            R.drawable.ic_electronics,
            R.drawable.ic_toys,
            R.drawable.ic_sport,
            R.drawable.ic_travel,
            R.drawable.ic_vehicles,
            R.drawable.ic_jewelry,
            R.drawable.ic_clothing,
            R.drawable.ic_home_items
    };
    androidx.viewpager.widget.ViewPager viewPager, viewPagerTop;
    List<ModalClass> mList;
    com.google.android.material.tabs.TabLayout tabLayout;
    CouponHomepageAdapter couponHomepageAdapter;
    TabItem tabAll;
    TabItem tabTravel;
    TabItem tabTech;
    RecyclerView mList1;
    List<LogoStoreHomePage> appList;
    ViewPagerAdapter viewPagerAdapter;

    //** Token request for Admitad
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.admitad.com/token/?client_id=6a94820efdc85cc45f67f78b638fed&scope=coupons&grant_type=client_credentials")
                .method("POST", body)
                .addHeader("base64_header", "NmE5NDgyMGVmZGM4NWNjNDVmNjdmNzhiNjM4ZmVkOjc4OTMwNzJiOWMyMTYwOWQyZjNjZTUyN2Q1YzE4MA==")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //** Details about slideshow in Homepage.
        viewPagerTop = findViewById(R.id.viewPagerId);
        mList = new ArrayList<>();
        mList.add(new ModalClass(R.drawable.banner_eeee, "Title"));
        mList.add(new ModalClass(R.drawable.banner_gggg, "Title"));
        mList.add(new ModalClass(R.drawable.banner_ffff, "Title"));
        mList.add(new ModalClass(R.drawable.banner_gggg, "Title"));
        mList.add(new ModalClass(R.drawable.banner_eeee, "Title"));

//        SlideHomepageAdapter slideHomepageAdapter = new SlideHomepageAdapter(this, mList);
//        viewPager.setAdapter(slideHomepageAdapter);
        viewPagerAdapter = new ViewPagerAdapter(this);

        viewPagerTop.setAdapter(viewPagerAdapter);

        //** Resource for logo store in Homepage.
        mList1 = findViewById(R.id.list1);
        appList = new ArrayList<>();

        appList.add(new LogoStoreHomePage(R.drawable.gearbest, "Gearbest"));
        appList.add(new LogoStoreHomePage(R.drawable.ebay, "eBay"));
        appList.add(new LogoStoreHomePage(R.drawable.amazon, "Amazon"));
        appList.add(new LogoStoreHomePage(R.drawable.aliexpress, "Aliexpress"));
        appList.add(new LogoStoreHomePage(R.drawable.geekbuying, "Geekbuying"));
        appList.add(new LogoStoreHomePage(R.drawable.gearbest, "Gearbest"));
        appList.add(new LogoStoreHomePage(R.drawable.amazon, "Amazon"));
        appList.add(new LogoStoreHomePage(R.drawable.ebay, "eBay"));
        appList.add(new LogoStoreHomePage(R.drawable.aliexpress, "Aliexpress"));
        appList.add(new LogoStoreHomePage(R.drawable.geekbuying, "Geekbuying"));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        LogoStoreHomePageAdapter adaptor1 = new LogoStoreHomePageAdapter(this, appList);
        mList1.setAdapter(adaptor1);

        //** Details about TabItem and TabLayout.
        tabLayout = findViewById(R.id.tablayout);
        tabAll = findViewById(R.id.tabAll);
        tabTravel = findViewById(R.id.tabTravel);
        tabTech = findViewById(R.id.tabTech);
        viewPager = findViewById(R.id.viewPager);

        couponHomepageAdapter = new CouponHomepageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(couponHomepageAdapter);

        //** Initialization TabLayout homepage
        tabLayout.addOnTabSelectedListener(new com.google.android.material.tabs.TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//** GRIDVIEW HOMEPAGE
        gridView = (GridView) findViewById(R.id.grid_category_home);
        AdapterGridCategoryHome adapterGridCategoryHome = new AdapterGridCategoryHome(this, values, images);
        gridView.setAdapter(adapterGridCategoryHome);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Timer timer = new Timer();
                        timer.scheduleAtFixedRate(new MyTimerTask(), 0, 4000);
                    }
                }, 4000);

//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new MyTimerTask(), 0, 4000);
    }

    //** Menu in the Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.for_users:
                fragment = new FramentUser();
                startActivity(new Intent(MainActivity.this, ActivityUser.class));
//                loadFragment(fragment);
//                Toast.makeText(getApplicationContext(),"for_users 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.for_merchants:
                fragment = new FramentMerchant();
                startActivity(new Intent(MainActivity.this, ActivityMerchants.class));
//                loadFragment(fragment);
//                Toast.makeText(getApplicationContext(),"for_merchants 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.about_blakoo:
                fragment = new FramentBlakoo();
                startActivity(new Intent(MainActivity.this, ActivityBlakoo.class));
//                loadFragment(fragment);
//                Toast.makeText(getApplicationContext(),"about_blakoo 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.help_center:
                fragment = new FramentHelp();
                startActivity(new Intent(MainActivity.this, ActivityHelp.class));
//                loadFragment(fragment);
//                Toast.makeText(getApplicationContext(),"help_center 4 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private boolean loadFragment(Fragment fragment){

        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPagerTop.getCurrentItem() == current_position){
                        ++current_position;
                        viewPagerTop.setCurrentItem(current_position);
                    }

                    if ( current_position >= viewPagerAdapter.getCount()){
                        current_position = 0;
                        viewPagerTop.setCurrentItem(current_position);
                    }

                    Log.e("current_position", String.valueOf(current_position));
//                    if (current_position > viewPagerTop )
//                    if(viewPagerTop.getCurrentItem() == 0){
//                        viewPagerTop.setCurrentItem(1);
//                    } else if(viewPagerTop.getCurrentItem() == 1){
//                        viewPagerTop.setCurrentItem(2);
//                    } else {
//                        viewPagerTop.setCurrentItem(0);
//                    }

                }
            });

        }
    }
}