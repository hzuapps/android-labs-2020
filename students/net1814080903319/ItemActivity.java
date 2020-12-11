package edu.hzuapps.androidlabs.net1814080903319;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    private View xiahuaxian;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        initView();
        initData();
    }

    private void initData() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<Message> messageList = getMessageItem();
        MessageAdapter messageAdapter=new MessageAdapter(messageList,ItemActivity.this);
        recyclerView.setAdapter(messageAdapter);
    }

    private List<Message> getMessageItem() {
        List<Message> messageList = new ArrayList<>();
        for (int i=1;i<=10;i++){
            Message message=new Message();
            message.setId(i);
            message.setSingname("歌名"+i);
            message.setFangshi("弹唱");
            message.setSinger("歌手"+i);
            messageList.add(message);
        }
        return messageList;
    }

    private void initView() {
        xiahuaxian = findViewById(R.id.xiahuaxian);
        refreshLayout = findViewById(R.id.refresh_layout);
        recyclerView = findViewById(R.id.recyclerview);
    }
}
