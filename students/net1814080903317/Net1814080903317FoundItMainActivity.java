package com.example.foundit.controller.activity.foundIt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.foundit.R;
import com.example.foundit.controller.adapter.FoundItMainAdapter;
import com.example.foundit.model.bean.FoundIt;
import com.example.foundit.model.bean.Info;
import com.example.foundit.model.dao.InfoDao;
import com.example.foundit.utils.LogUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * author: djx
 * created on: 2020/9/28 15:23
 * description:失物招领主页面
 */
public class Net1814080903317FoundItMainActivity extends Activity {

    private ImageView myIv;
    private ImageView backIv;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private Context context=Net1814080903317FoundItMainActivity.this;
    private InfoDao infoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foundit_main);
        initView();
        initData();
        initListener();
    }

    private void initData() {
        infoDao=new InfoDao(context);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<Info> infoList=infoDao.dbSelectAllInfos();
        FoundItMainAdapter foundItMainAdapter=new FoundItMainAdapter(infoList,Net1814080903317FoundItMainActivity.this);
        recyclerView.setAdapter(foundItMainAdapter);
    }

    /**
     * 用于模拟RecyclerView复用效果
     * @return
     */

    private List<FoundIt> getFoundItList() {
        List<FoundIt> foundItList=new ArrayList<>();
        for (int i=1000;i<=1005;i++){
            FoundIt foundIt=new FoundIt();
            foundIt.setId(i);
            foundIt.setNickname("烟花易冷"+i);
            foundIt.setContent("我是烟花易冷"+i+"，我喜欢运动.现在明星出道的方式有很多，但这其中最火的就是靠选秀节目了，因为在节目中可以慢慢积攒人气，通过与别人同台竞技也可以让别人看到自己的实力，从而在出道时有有一定的“铁杆粉丝”。");
            foundIt.setState("未完成");
            if (i/2==0){
                 foundIt.setType("寻 物");
            }else {
                foundIt.setType("招 领");
            }
            foundIt.setPublicTime("2020-10/19-"+i);
            foundItList.add(foundIt);
        }

        return foundItList;
    }


    private void initListener() {
        myIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStartActivity(Net1814080903317FoundItMainActivity.this,Net1814080903317FoundItMyActivity.class);
            }
        });


    }

    /**
     * 启动一个新的Activity
     * @param context 本Activity对象，指
     * @param _class  要跳转的Activity的class
     */
    public void myStartActivity(Context context,Class _class){
        Intent intent=new Intent(context,_class);
        startActivity(intent);
    }
    private void initView() {
        backIv = findViewById(R.id.foundit_main_back_iv);
        myIv = findViewById(R.id.foundit_main_my_iv);
        refreshLayout = findViewById(R.id.foundit_main_refresh_layout);
        recyclerView = findViewById(R.id.foundit_main_recyclerview);

    }

}