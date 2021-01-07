package edu.hzuapps.androidlabs.net1814080903326;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Net1814080903326Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvShow;
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private HttpURLConnection connection;
    private static final String tv_show = "tv_show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903326);
        initUI();
    }

    //sy5

    public void change(View view){
        changeImformation();
    }

    public void restart(View view){
        String []texts=getImformation();
        changeEditText(texts);
    }

    public String[] getImformation(){
        SharedPreferences settings = this.getSharedPreferences(
                "MY_IMFORMATION", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //

        String contens[]=new String[1];
        contens[0]= settings.getString(tv_show, "");

        return contens;
    }

    public void changeImformation(){
        SharedPreferences settings = this.getSharedPreferences(
                "MY_IMFORMATION", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        //SharedPreferences settings = this.getSharedPreferences(
        //        Context.MODE_PRIVATE); // 不指定ID、使用默认偏好设置（只有一个）
        SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置

        String imformations[]=getText();
        editor.putString(tv_show,imformations[0]);     // 字符串值
        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[2];
        editTexts[0]=(EditText)findViewById(R.id.tv_show);

        return editTexts;
    }

    public void changeEditText(String[] imformations){
        EditText []editTexts=getEditText();
        for(int i=0;i<imformations.length;i++) {
            editTexts[i].setText(imformations[i]);
        }
    }

    public String[] getText(){
        EditText []editTexts=getEditText();
        String texts[]=new String[6];
        for(int i=0;i<6;i++){
            texts[i]=editTexts[i].getText().toString();
        }
        return texts;
    }





    //
    private void initUI() {
        mTvShow = findViewById(R.id.tv_show);
        findViewById(R.id.btu_new).setOnClickListener(this);

        findViewById(R.id.btn_comm).setOnClickListener(this);
        findViewById(R.id.btn_mine).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btu_new:
                initData();
            case R.id.btn_comm:
            case R.id.btn_mine:
                //跳转到第二界面
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), FirstActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    //初始化数据
    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                String data = getDataFromeSerer();

                Log.i("Net1814080903326Activity","获取到数据为:"+data);

            }
        }).start();
    }
    //从服务器数据

    private String getDataFromeSerer() {
        try {//1.创建ui
            URL url = new URL("https://v1.hitokoto.cn/?c=f&encode=text");
            //2.打开链接
            connection = (HttpURLConnection) url.openConnection();

            //3.判断并处理结果
            if (connection.getResponseCode() == 200) {
                //huoqushuruliu
                inputStream = connection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();
                for (String line = ""; (line = bufferedReader.readLine()) != null; ) {
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {

                if(bufferedReader !=null) bufferedReader.close();
                if(inputStream !=null) inputStream.close();
                if(connection!=null)connection.disconnect();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return "";

    }
}

