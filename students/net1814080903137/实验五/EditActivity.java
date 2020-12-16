package edu.hzuapps.androidlabs.net1814080903137;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends AppCompatActivity {

    EditText et;//定义，获取输入框文字
//    private String content;
//    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        et=findViewById(R.id.et);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){//
        if (keyCode == KeyEvent.KEYCODE_HOME){
            return true;
        }
        else if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent =new Intent();//定义，传回所需要的信息
            intent.putExtra("input",et.getText().toString());//转为字符串再使用
//            intent.putExtra("time",dateToStr());
            setResult(RESULT_OK,intent);
            finish();//结束活动
            return true;
        }

        return super.onKeyDown(keyCode,event);//监控
    }
    public String dateToStr(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
