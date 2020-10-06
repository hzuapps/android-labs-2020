package edu.hzuapps.androidlabs.sec1814080911128;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout loading;
    private ListView lvNews;
    private List<NewsInfos>

    @Override
    protected void onCreate(Budle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fillData();
    }
    //初始化控件
    private void initView() {
        loading = (L)
    }

    private void fillData() { }
    //ListView适配器
    private class NewsAdapter extends BaseAdapter {
        //listview的item数
        @Override
        public int getCount() {
            return newsInfos.size();
        }

        //条目对象
        @Override
        public Object getItem(int position) {
            return null;
        }

        //条目id
        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}