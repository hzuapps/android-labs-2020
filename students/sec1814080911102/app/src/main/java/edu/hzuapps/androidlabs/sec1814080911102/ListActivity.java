package edu.hzuapps.androidlabs.sec1814080911102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import edu.hzuapps.androidlabs.sec1814080911102.filehelper.FileHelper;
import edu.hzuapps.androidlabs.sec1814080911102.fruit.Fruit;
import edu.hzuapps.androidlabs.sec1814080911102.fruit.FruitAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private FileHelper fileHelper;
    public List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FruitAdapter adapter = new FruitAdapter(ListActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.listview_newitems);
        listView.setAdapter(adapter);

        initFruits();

        final ListActivity thisActivity = this;
        Button listBtn = (Button) findViewById(R.id.button_newitems);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, NewItems.class);
                /*
                startActivityForResult与startActivity的不同之处在于：
                1、startActivity( )
                仅仅是跳转到目标页面，若是想跳回当前页面，则必须再使用一次startActivity( )。
                2、startActivityForResult( )
                可 以一次性完成这项任务，当程序执行到这段代码的时候，假若从T1Activity跳转到下一个Text2Activity，
                而当这个 Text2Activity调用了finish()方法以后，程序会自动跳转回T1Activity，
                并调用前一个T1Activity中的 onActivityResult( )方法。
                参考文章：https://www.cnblogs.com/yaowen/p/5441728.html
                https://blog.csdn.net/hellobenji/article/details/79978701?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control
                 */
                startActivityForResult(intent,1);
            }
        });
    }

    //和startActivityForResult配套使用，只要从NewItems回来就会调用这个方法。
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == 1){
            refresh();
        }
    }

    private void refresh() {
        finish();
        //设置finish();的动画效果为淡入淡出
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        Intent intent = new Intent(ListActivity.this, ListActivity.class);
        startActivity(intent);
        /*设置startActivity();的动画效果为淡入淡出
        参考 https://www.cnblogs.com/dazuihou/p/3585303.html*/
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    public void initFruits() {
        fileHelper = new FileHelper(getApplicationContext());
        String data = null;
        String[] fruits = {};
        try {
            data = fileHelper.read("itemdata");
            fruits = data.split("_");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String item:
                fruits) {
            Fruit apple = new Fruit(item);
            fruitList.add(apple);
        }
    }
}

