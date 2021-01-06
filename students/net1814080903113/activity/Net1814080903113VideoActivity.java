package edu.hzuapps.androidlabs.net1814080903113;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.app.DatePickerDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.net1814080903113.adapters.MainViewListAdapter;
import edu.hzuapps.androidlabs.net1814080903113.adapters.MainViewAdapter;
import edu.hzuapps.androidlabs.net1814080903113.beans.MainDatas;
import edu.hzuapps.androidlabs.net1814080903113.beans.MainItemBean;
import models.item_main_viewlist_model;

public class Net1814080903113VideoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainViewListAdapter mainViewListAdapter;
    private ArrayList<item_main_viewlist_model> item_main_viewlist_models;

    Integer aquaimage[] = {R.drawable.aquamodel1,R.drawable.aquamodel2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1814080903113video);

        recyclerView = findViewById(R.id.dd_ddd_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Net1814080903113VideoActivity.this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        item_main_viewlist_models = new ArrayList<>();

        for (int i = 0; i < aquaimage.length; i++){
            item_main_viewlist_model ai = new item_main_viewlist_model(aquaimage[i]);
            item_main_viewlist_models.add(ai);
        }
        mainViewListAdapter = new MainViewListAdapter(Net1814080903113VideoActivity.this,item_main_viewlist_models);
        recyclerView.setAdapter(mainViewListAdapter);
    }
}
