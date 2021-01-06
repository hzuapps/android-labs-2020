package edu.hzuapps.androidlabs.net1814080903113;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import edu.hzuapps.androidlabs.net1814080903113.adapters.MainViewListAdapter;
import edu.hzuapps.androidlabs.net1814080903113.adapters.MainViewListAdapter2;
import models.item_main_viewlist_model;
import edu.hzuapps.androidlabs.net1814080903113.fragment.MessageFragment;
import edu.hzuapps.androidlabs.net1814080903113.fragment.ItemViewFragment;
import edu.hzuapps.androidlabs.net1814080903113.fragment.MainViewFragment;


public class Net1814080903113MainActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private MainViewListAdapter2 mainViewListAdapter;
    private ArrayList<item_main_viewlist_model> item_main_viewlist_models;
//    ImageView imageView = findViewById(R.id.aquaimage);

    Integer aquaimage[] = {R.drawable.aquairasuto1,R.drawable.aquairasuto2,R.drawable.aquairasuto3,R.drawable.aquairasuto4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1814080903113main);

        final Activity thisActivity = this;


        LinearLayout btnOpen = (LinearLayout) findViewById(R.id.buttonopen);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, MainViewActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);

            }
        });

        LinearLayout btnshow = (LinearLayout) findViewById(R.id.buttonshow);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, PhotoShowActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        mrecyclerView = findViewById(R.id.main_viewshow);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Net1814080903113MainActivity.this, LinearLayoutManager.HORIZONTAL,false);
        mrecyclerView.setLayoutManager(layoutManager);
//        mrecyclerView.setItemAnimator(new DefaultItemAnimator());

        item_main_viewlist_models = new ArrayList<>();

        for (int i = 0; i < aquaimage.length; i++){
            item_main_viewlist_model ai = new item_main_viewlist_model(aquaimage[i]);
            item_main_viewlist_models.add(ai);
        }
        mainViewListAdapter = new MainViewListAdapter2(Net1814080903113MainActivity.this,item_main_viewlist_models);
        mrecyclerView.setAdapter(mainViewListAdapter);

    }


//    public void loadImage(View view){
//        String url = "https://i.loli.net/2020/12/15/pvWwOuboDjhaN7V.jpg";
//        Glide.with(this)
//                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                .into(imageView);
//    }
}
