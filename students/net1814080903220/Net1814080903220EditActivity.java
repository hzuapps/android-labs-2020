package edu.hzuapps.androidlabs.net1814080903220;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Net1814080903220EditActivity extends AppCompatActivity {

    private String mFileName = "test.txt";

    //Net1814080903220EditActivity中按返回键返回Net1814080903220MainActivity并销毁当前的Activity
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent();
            intent.setClass(Net1814080903220EditActivity.this, Net1814080903220MainActivity.class);
            moveTaskToBack(true);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /*******文件内部存储********/
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try{
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final TextView mtvContent1 = (TextView)findViewById(R.id.text1);
        Button mBtnShow = (Button)findViewById(R.id.baocun);
        final EditText editText = (EditText)findViewById(R.id.E_dit);
        /*******获取网络图片url，用Glide.load加载该网络图片进入该布局*******/
        ImageView mIg = (ImageView) findViewById(R.id.imageback);
        mIg.setAlpha(80);
        Glide.with(this).load("https://p1.ssl.qhimgs1.com/sdr/400__/t0106390b4760abe341.jpg").into(mIg);

        /****点击保存按钮后显示EditText输入后数据****/
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(editText.getText().toString());
                mtvContent1.setText(read());
            }
        });

        DateView();
    }

    private void DateView() {
        // 实例化控件
        final EditText editText3;
        final DatePickerDialog dateDialog;
        int year, monthOfYear, dayOfMonth;
        Button dateButton = (Button) findViewById(R.id.dateChoose);
        editText3 = (EditText) findViewById(R.id.E_dit2);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker arg0, int year, int monthOfYear,
                                  int dayOfMonth) {
                String text = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                editText3.setText(text);
            }
        }, year, monthOfYear, dayOfMonth);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dateDialog.show();
            }
        });
    }
}
