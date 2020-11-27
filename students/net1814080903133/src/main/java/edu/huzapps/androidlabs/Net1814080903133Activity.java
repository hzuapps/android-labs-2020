package edu.hzuapps.androidlabs;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.hzuapps.androidlabs.myActivity.NovelReadActivity;
import edu.hzuapps.androidlabs.myActivity.SettingActivity;
import edu.hzuapps.androidlabs.myContreller.Book;
import edu.hzuapps.androidlabs.myContreller.BookManager;
import edu.hzuapps.androidlabs.myContreller.DatabaseHelper;
import edu.hzuapps.androidlabs.myContreller.MyListViewAdapter;
import edu.hzuapps.androidlabs.myContreller.MyTools;


public class Net1814080903133Activity extends AppCompatActivity {

    Button setBtn;
    Button addBtn;
    ListView myListView;
    BookManager bookManager;
    Net1814080903133Activity that=this;
    MyListViewAdapter listAdapte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903133);

        setTitle("主界面");

//        变量初始化
        myListView = findViewById(R.id.listView);
        setBtn = findViewById(R.id.setBtn);
        addBtn = findViewById(R.id.addBtn);

//        初始化从数据库取书本
        final DatabaseHelper databaseHelper = DatabaseHelper.getData();
        databaseHelper.setSQL(that,"novel");
        ArrayList<Book> books = null;
        try {
            books = databaseHelper.initbook(that);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bookManager = BookManager.getBookManager();
        bookManager.clear();
        bookManager.addBook(books);

//        设置按钮绑定事件
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setIn = new Intent(that, SettingActivity.class);
                startActivity(setIn);
            }
        });

//        给listview的item绑定点击事件，position作为ID传递参数
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(that, NovelReadActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });

//        添加书籍弹窗
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(that);
                View dialogView = View.inflate(that,R.layout.add_book_item,null);
                final EditText bookNameE = dialogView.findViewById(R.id.bookNameEditText);
                final EditText authorE = dialogView.findViewById(R.id.authorEditText);
                final EditText imgaddrE = dialogView.findViewById(R.id.imgAddrEditText);
                final EditText addrE = dialogView.findViewById(R.id.addrEditText);

                builder.setPositiveButton("添加", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        添加书本并且初始化
                    try {
//                        判断书本是否存在
                        if (!databaseHelper.bookExist(addrE.getText().toString())){
                            bookManager.addBook(bookNameE.getText().toString(),authorE.getText().toString(),imgaddrE.getText().toString(),addrE.getText().toString(),that);
                            listAdapte.notifyDataSetChanged();
                            Intent intent = new Intent(that, NovelReadActivity.class);
                            intent.putExtra("id",listAdapte.getCount()-1);
                            startActivity(intent);
                        }
                      } catch (IOException e) {
                       e.printStackTrace();
                      }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setView(dialogView);
                builder.show();
            }
        });
//        ListView绑定适配器
        listAdapte = new MyListViewAdapter(this);
        myListView.setAdapter(listAdapte);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listAdapte.notifyDataSetChanged();
    }
}