package edu.hzuapps.androidlabs.net1814080903216;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private Button btnsax;
    private Button btndom;
    private Button btnpullread;
    private Button btnpullwrite;
    private ListView list;
    private ArrayList<Person> persons;
    private ArrayAdapter<Person> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setViews();
    }

    private void setViews() {
        list = (ListView) findViewById(R.id.list);
        btnsax = (Button) findViewById(R.id.btnsax);
        btndom = (Button) findViewById(R.id.btndom);
        btnpullread = (Button) findViewById(R.id.btnpullread);
        btnpullwrite = (Button) findViewById(R.id.btnpullwrite);

        btnsax.setOnClickListener(this);
        btndom.setOnClickListener(this);
        btnpullread.setOnClickListener(this);
        btnpullwrite.setOnClickListener(this);
    }

    private ArrayList<Person> readxmlForSAX() throws Exception {
        //获取文件资源建立输入流对象
        InputStream is = getAssets().open("person1.xml");
        //①创建XML解析处理器
        SaxHelper ss = new SaxHelper();
        //②得到SAX解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //③创建SAX解析器
        SAXParser parser = factory.newSAXParser();
        //④将xml解析处理器分配给解析器,对文档进行解析,将事件发送给处理器
        parser.parse(is, ss);
        is.close();
        return ss.getPersons();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsax:
                try {
                    persons = readxmlForSAX();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mAdapter = new ArrayAdapter<Person>(MainActivity3.this,
                        android.R.layout.simple_expandable_list_item_1, persons);
                list.setAdapter(mAdapter);
                break;
            case R.id.btndom:
                DomHelper ds = new DomHelper();
                persons = ds.queryXML(getApplicationContext());
                mAdapter = new ArrayAdapter<Person>(MainActivity3.this, android.R.layout.simple_expandable_list_item_1, persons);
                list.setAdapter(mAdapter);
                break;
            case R.id.btnpullread:
                //获取文件资源建立输入流对象
                try {
                    InputStream is = getAssets().open("person3.xml");
                    persons = PullHelper.getPersons(is);
                    if(persons.equals(null)){
                        Toast.makeText(getApplicationContext(), "呵呵", Toast.LENGTH_SHORT).show();
                    }
                    for(Person p1 :persons)
                    {
                        Log.i("逗比", p1.toString());
                    }
                    mAdapter = new ArrayAdapter<Person>(MainActivity3.this, android.R.layout.simple_expandable_list_item_1, persons);
                    list.setAdapter(mAdapter);
                } catch (Exception e) {e.printStackTrace();}
                break;
            case R.id.btnpullwrite:
                Context context = getApplicationContext();
                List<Person> persons = new ArrayList<Person>();
                persons.add(new Person(21,"逗比1",70));
                persons.add(new Person(31,"逗比2",50));
                persons.add(new Person(11,"逗比3",30));
                File xmlFile = new File(context.getFilesDir(),"jay.xml");
                FileOutputStream fos;
                try {
                    fos = new FileOutputStream(xmlFile);
                    PullHelper.save(persons, fos);
                    Toast.makeText(context, "文件写入完毕", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
