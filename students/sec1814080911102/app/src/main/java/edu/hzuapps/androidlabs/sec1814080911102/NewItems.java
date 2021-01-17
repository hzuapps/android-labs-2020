package edu.hzuapps.androidlabs.sec1814080911102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import edu.hzuapps.androidlabs.sec1814080911102.filehelper.FileHelper;
import edu.hzuapps.androidlabs.sec1814080911102.fruit.Fruit;

/*
这是一个供输入内容的悬浮窗口，本质上是一个activity
在styles.xml写入悬浮窗的样式，并在AndroidManifest中引用
以达到该效果
 */

public class NewItems extends AppCompatActivity {

    private FileHelper fileHelper;
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_items);

        fileHelper = new FileHelper(getApplicationContext());
        Button ok = (Button) findViewById(R.id.button_new_ok);
        Button close = (Button) findViewById(R.id.button_new_close) ;
        final EditText edittext = (EditText) findViewById(R.id.newitems);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里加下划线是为了把每一次保存的内容隔开，在initFruit();方法中，识别到下划线，就知道是不同的内容
                String text = edittext.getText().toString() + "_";
                //在控制台输出内容，方便观察
                System.out.println("保存成功：" + text);
                if (text.isEmpty()) {
                    //防止保存空内容
                    Toast.makeText(getApplicationContext(), "内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        fileHelper.save("itemdata",text);
                        Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "保存失败", Toast.LENGTH_SHORT).show();
                    }
                    /*
                    这里想在保存数据后通过打开一个新的ListActivity的方式达到刷新页面的效果
                    但是这样之前的页面其实还在那里，所以如果添加了多次数据，那退出的时候也要退出很多次
                    太笨了，算是曲线救国的方法，但是还有更好的方法
                    Intent intent = new Intent(NewItems.this , ListActivity.class);
                    startActivity(intent);
                    */

//                    Intent data = new Intent();这里定义了个data，本来setResult可以带数据回去的，但是我不用，所以也就不需要了
                    //setResult(RESULT_OK, intent);intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
                    setResult(1);
                    //此处一定要调用finish()方法
                    finish();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}