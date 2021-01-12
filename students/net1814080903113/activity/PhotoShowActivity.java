package edu.hzuapps.androidlabs.net1814080903113;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.net1814080903113.adapters.ListViewAdapter;
import edu.hzuapps.androidlabs.net1814080903113.beans.Datas;
import edu.hzuapps.androidlabs.net1814080903113.beans.ItemBean;

public class PhotoShowActivity extends AppCompatActivity {

    private RecyclerView viewlist;
    private List<ItemBean> mdata;
    private ListViewAdapter mAdapter;
    final Activity thisAct = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);

        viewlist = this.findViewById(R.id.Recy_view);

        initDatas();
        spancolor();
    }

    private void spancolor() {

    }


    private void initDatas() {
        mdata = new ArrayList<>();
        for (int i = 0; i< Datas.icons.length; i++){
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = Datas.titles[i];
            data.content = Datas.content[i];
            data.times = Datas.texttime[i];
            data.views = Datas.textviews[i];
            data.whatdo = Datas.textwhatdo[i];
            mdata.add(data);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        viewlist.setLayoutManager(layoutManager);
        mAdapter = new ListViewAdapter(mdata);
        viewlist.setAdapter(mAdapter);
    }


}
