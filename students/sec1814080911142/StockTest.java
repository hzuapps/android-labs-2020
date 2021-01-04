

package edu.hzuapps.androidlabs.sec1814080911142;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StockTest extends AppCompatActivity implements View.OnClickListener{
    private EditText et;
    private TextView tv;
    private String name = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_test);
//输入框
        et = findViewById(R.id.et);
        //显示框
        tv = findViewById(R.id.tv);

        //为两个按钮都绑定下边的onClick事件
        findViewById(R.id.btn_read).setOnClickListener(this);
        findViewById(R.id.btn_write).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //当前组件对应的就是v
        switch (v.getId()) {
            case R.id.btn_write:
                try {
                    //将文件数据写入到应用的内部存储
                    FileOutputStream fos = openFileOutput(name, Context.MODE_PRIVATE);
                    //封装文件输出流并设置编码方式为UTF8
                    OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
                    //获取输入的内容并写入文件中
                    osw.write(et.getText().toString());
                    //对两个流进行刷新清空
                    osw.flush();
                    fos.flush();
                    //关闭流
                    osw.close();
                    fos.close();
                    //提示弹框
                    Toast t=Toast.makeText(getApplicationContext(),"存储成功！",Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER_VERTICAL,40,0);
                    t.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_read:
                try {
                    //将输入流与存储文件绑定
                    FileInputStream fis = openFileInput(name);
                    InputStreamReader isr = new InputStreamReader(fis,"utf-8");
                    //用char数组接收，大小通过available()确定
                    char input[] = new char[fis.available()];
                    //将文件读取到input中
                    isr.read(input);
                    //关闭流
                    isr.close();
                    fis.close();
                    String readed = new String(input);
                    //回显
                    tv.setText(readed);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
