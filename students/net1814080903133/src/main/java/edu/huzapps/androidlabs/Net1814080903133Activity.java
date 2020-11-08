package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import edu.hzuapps.androidlabs.myActivity.NovelReadActivity;
import edu.hzuapps.androidlabs.myActivity.SettingActivity;
import edu.hzuapps.androidlabs.myContreller.BookManager;
import edu.hzuapps.androidlabs.myContreller.MyListViewAdapter;


public class Net1814080903133Activity extends AppCompatActivity {

    Button setBtn;
    ListView myListView;
    BookManager bookManager;
    Net1814080903133Activity that=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903133);

        setTitle("主界面");

        myListView = (ListView)findViewById(R.id.listView);
        setBtn = (Button)findViewById(R.id.setBtn);
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setIn = new Intent(that, SettingActivity.class);
                startActivity(setIn);
            }
        });
        bookManager = BookManager.getBookManager();

        bookManager.clear();
        bookManager.addBook("daode","道德经","老子","3");
        for (int i=2;i<=12;i++){
            bookManager.addBook("book"+i,"book"+i,"author"+i,"12");
        }
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(that, NovelReadActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
        myListView.setAdapter(new MyListViewAdapter(this));
    }
}