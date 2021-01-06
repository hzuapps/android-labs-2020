package edu.hzuapps.androidlabs.net1814080903113;

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
import edu.hzuapps.androidlabs.net1814080903113.adapters.MainViewAdapter2;
import edu.hzuapps.androidlabs.net1814080903113.beans.MainDatas;
import edu.hzuapps.androidlabs.net1814080903113.beans.MainItemBean;
import models.item_main_viewlist_model;


public class MainViewActivity extends AppCompatActivity {

    private RecyclerView viewlist;
    private RecyclerView viewlist2;
    private MainViewAdapter vadapter;
    private MainViewAdapter2 vadapter2;
    private List<MainItemBean> vdata;
    private List<MainItemBean> vdata2;

    private RecyclerView mrecyclerView;
    private RecyclerView mrecyclerView2;
    private RecyclerView mrecyclerView4;
    private RecyclerView mrecyclerView5;

    private MainViewListAdapter mainViewListAdapter;
    private MainViewListAdapter mainViewListAdapter2;
    private MainViewListAdapter mainViewListAdapter4;
    private MainViewListAdapter mainViewListAdapter5;

    private ArrayList<item_main_viewlist_model> item_main_viewlist_models;
    private ArrayList<item_main_viewlist_model> item_main_viewlist_model2;
    private ArrayList<item_main_viewlist_model> item_main_viewlist_model4;
    private ArrayList<item_main_viewlist_model> item_main_viewlist_model5;

    Integer aquaimage[] = {R.drawable.aquamodel1,R.drawable.aquamodel2};
    Integer aquaimage2[] = {R.drawable.aquamodel5,R.drawable.aquamodel8};
    Integer aquaimage4[] = {R.drawable.aquamodel7,R.drawable.aquamodel4};
    Integer aquaimage5[] = {R.drawable.aquamodel3,R.drawable.aquamodel9,R.drawable.aquamodel10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_main_view);

        viewlist = findViewById(R.id.main_list1);
        viewlist2 = findViewById(R.id.main_list2);

        intDatas();

        /*2d3d_1*/
        mrecyclerView = findViewById(R.id.dd_ddd_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainViewActivity.this, LinearLayoutManager.HORIZONTAL,false);
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setItemAnimator(new DefaultItemAnimator());

        item_main_viewlist_models = new ArrayList<>();

        for (int i = 0; i < aquaimage.length; i++){
            item_main_viewlist_model ai = new item_main_viewlist_model(aquaimage[i]);
            item_main_viewlist_models.add(ai);
        }
        mainViewListAdapter = new MainViewListAdapter(MainViewActivity.this,item_main_viewlist_models);
        mrecyclerView.setAdapter(mainViewListAdapter);

        /*2d3d_2*/
        mrecyclerView2 = findViewById(R.id.dd_ddd_view2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(MainViewActivity.this, LinearLayoutManager.HORIZONTAL,false);
        mrecyclerView2.setLayoutManager(layoutManager2);
        mrecyclerView2.setItemAnimator(new DefaultItemAnimator());

        item_main_viewlist_model2 = new ArrayList<>();

        for (int i = 0; i < aquaimage2.length; i++){
            item_main_viewlist_model ai2 = new item_main_viewlist_model(aquaimage2[i]);
            item_main_viewlist_model2.add(ai2);
        }
        mainViewListAdapter2 = new MainViewListAdapter(MainViewActivity.this,item_main_viewlist_model2);
        mrecyclerView2.setAdapter(mainViewListAdapter2);

        /*2d3d_4*/
        mrecyclerView4 = findViewById(R.id.dd_ddd_view4);
        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(MainViewActivity.this, LinearLayoutManager.HORIZONTAL,false);
        mrecyclerView4.setLayoutManager(layoutManager4);
        mrecyclerView4.setItemAnimator(new DefaultItemAnimator());

        item_main_viewlist_model4 = new ArrayList<>();

        for (int i = 0; i < aquaimage4.length; i++){
            item_main_viewlist_model ai4 = new item_main_viewlist_model(aquaimage4[i]);
            item_main_viewlist_model4.add(ai4);
        }
        mainViewListAdapter4 = new MainViewListAdapter(MainViewActivity.this,item_main_viewlist_model4);
        mrecyclerView4.setAdapter(mainViewListAdapter4);

        /*2d3d_5*/
        mrecyclerView5 = findViewById(R.id.dd_ddd_view5);
        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(MainViewActivity.this, LinearLayoutManager.HORIZONTAL,false);
        mrecyclerView5.setLayoutManager(layoutManager5);
        mrecyclerView5.setItemAnimator(new DefaultItemAnimator());

        item_main_viewlist_model5 = new ArrayList<>();

        for (int i = 0; i < aquaimage5.length; i++){
            item_main_viewlist_model ai5 = new item_main_viewlist_model(aquaimage5[i]);
            item_main_viewlist_model5.add(ai5);
        }
        mainViewListAdapter5 = new MainViewListAdapter(MainViewActivity.this,item_main_viewlist_model5);
        mrecyclerView5.setAdapter(mainViewListAdapter5);


    }


    private void intDatas() {

        vdata = new ArrayList<>();
        for (int i = 0; i< MainDatas.aquatitle.length; i++){
            MainItemBean data = new MainItemBean();
            data.vaquaname = MainDatas.aquatitle[i];
            data.vaquatext= MainDatas.aquatext[i];
            vdata.add(data);
        }

        vdata2 = new ArrayList<>();
        for (int i = 0; i< MainDatas.aquaachievement.length;i++){
            MainItemBean data2 = new MainItemBean();
            data2.vaquanum = MainDatas.achinum[i];
            data2.vaquaachi = MainDatas.aquaachievement[i];
            vdata2.add(data2);
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        viewlist.setLayoutManager(layoutManager);
        vadapter = new MainViewAdapter(vdata);
        viewlist.setAdapter(vadapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        viewlist2.setLayoutManager(layoutManager2);
        vadapter2 = new MainViewAdapter2(vdata2);
        viewlist2.setAdapter(vadapter2);
    }
}