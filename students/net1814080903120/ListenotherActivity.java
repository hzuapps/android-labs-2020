package edu.hzuapps.androidlabs.net1814080903120;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class ListenotherActivity extends AppCompatActivity {

private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listenother);

        listView = (ListView) findViewById(R.id.lv_list);

        String data[] = {"第一封信","第二封信","第三封信"};

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        //listview视图加载适配器
        listView.setAdapter(arrayAdapter);
        //为列表视图中选中的项添加响应事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = parent.getItemAtPosition(position).toString();//获取选择项的值
                Toast.makeText(ListenotherActivity.this,"查看"+result,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
