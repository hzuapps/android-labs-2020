package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.app.AlertDialog.*;

public class Net1814080903125Activity extends AppCompatActivity {

    DatabaseHelper dbHelper = null;
    SQLiteDatabase db = null;
    String password=null;

    /**
     * 从数据库中查询出数据，并显示到ListView上
     */
    public void query(){
        dbHelper = new DatabaseHelper(Net1814080903125Activity.this,"my_diary",null,1);
        db = dbHelper.getWritableDatabase();

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        Cursor cursor = db.query("_diary", new String[]{"id","title","content"}, null, null, null, null, null);

        //遍历
        while (cursor.moveToNext()){
            Map<String,Object> map = new HashMap<>();
            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            map.put("id",id);
            map.put("title",title);
            map.put("content",content);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.activity_example,new String[]{"id","title"},new int[]{R.id.item_id,R.id.item_title});

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        //点击Item时触发的事件
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter1 = adapterView.getAdapter();
                final Map<String,Object> map = (Map<String, Object>) adapter1.getItem(i);
                System.out.println(map.get("id"));

                dbHelper = new DatabaseHelper(Net1814080903125Activity.this,"my_diary",null,1);
                db = dbHelper.getWritableDatabase();
                Cursor cursor1 = db.query("_diary",new String[]{"password"},"id=?",new String[]{map.get("id").toString()},null,null,null);

                if (cursor1.moveToFirst()){
                    password = cursor1.getString(cursor1.getColumnIndex("password"));
                    System.out.println(password);
                }
                Bundle bundle = new Bundle();
                bundle.putString("title", map.get("title").toString());
                bundle.putString("id", map.get("id").toString());
                bundle.putString("content", map.get("content").toString());
                final Intent intent = new Intent();
                intent.putExtras(bundle);

                //如果没有设置密码，则直接跳转
                if (password==null){
                    //页面跳转
                    intent.setClass(Net1814080903125Activity.this, ShowDiaryActivity.class);
                    startActivity(intent);
                }else{
                    //如果设置了密码，弹出一个文本框，要求输入密码
                    final EditText inputServer = new EditText(Net1814080903125Activity.this);
                    Builder builder = new Builder(Net1814080903125Activity.this);
                    builder.setTitle("请输入密码：").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                            .setNegativeButton("取消", null);

                    //点击确定，如果密码匹配，则跳转到显示日记的界面
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            if ((inputServer.getText().toString()).equals(password)){
                                //页面跳转
                                intent.setClass(Net1814080903125Activity.this, ShowDiaryActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Net1814080903125Activity.this, "输入的密码不正确！", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });

                    //显示弹窗
                    builder.show();
                }

            }

        };
        listView.setOnItemClickListener(listener);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        query();

        //跳转到添加日记的界面
        Button add_btn = (Button)findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903125Activity.this, AddDiaryActivity.class);
                Net1814080903125Activity.this.startActivity(intent);
            }
        });

        //跳转到设置密码的界面
        Button pwd_btn = (Button)findViewById(R.id.pwd_btn);
        pwd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903125Activity.this, PasswordActivity.class);
                Net1814080903125Activity.this.startActivity(intent);
            }
        });

        //删除
        final EditText text = (EditText)findViewById(R.id.text_id);
        Button del = (Button)findViewById(R.id.del_btn);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("_diary","id=?",new String[]{text.getText().toString()});
                text.setText("");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                Toast.makeText(Net1814080903125Activity.this, "日记删除成功！", Toast.LENGTH_LONG)
                        .show();
                query();
            }
        });
    }
}