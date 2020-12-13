package edu.hzuapps.androidlabs.sec1814080911203;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

import static java.nio.charset.StandardCharsets.*;

public class FinancialActivity extends AppCompatActivity {
    String type=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisactivity=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial);
        final EditText moeny = (EditText) findViewById(R.id.xu_money);
        Button a =(Button) findViewById(R.id.xu_moneysure);
        final CheckBox guozhai=(CheckBox)findViewById(R.id.xu_guozhai);
        final CheckBox huangjin=(CheckBox)findViewById(R.id.xu_huangjin);
        final CheckBox maotai=(CheckBox)findViewById(R.id.xu_maotai);
        final CheckBox xinnegyuan=(CheckBox)findViewById(R.id.xu_xinnengyuan);
        final CheckBox lidianchi=(CheckBox)findViewById(R.id.xu_lidianchi);
        final CheckBox hangkong=(CheckBox)findViewById(R.id.hangkong);
        final CheckBox yiliao=(CheckBox)findViewById(R.id.yiliao);
        final CheckBox jungong=(CheckBox)findViewById(R.id.jungong);
        final CheckBox wangluo=(CheckBox)findViewById(R.id.wangluo);
        a.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String _money=moeny.getText().toString();
                moeny.setText(null);
                if(guozhai.isChecked()){

                        type+="国债20322";

                }
                if(huangjin.isChecked()){

                        type+="黄金基金";

                }
                if(maotai.isChecked()){

                        type+="茅台基金";

                }
                if(xinnegyuan.isChecked()){

                        type+="新能源汽车基金";

                }
                if(lidianchi.isChecked()){

                        type+="锂电池基金";

                }
                if(hangkong.isChecked()){

                        type+="航空设备基金";

                }
                if(yiliao.isChecked()){

                        type+="医疗服务基金";

                }
                if(jungong.isChecked()){

                        type+="军工基金";

                }
                if(wangluo.isChecked()){

                        type+="网络安全基金";

                }
                Toast toast=Toast.makeText(thisactivity,type,Toast.LENGTH_SHORT);
                toast.show();
                Financial(_money,getsystime(),type);
                type=null;
            }
        });


    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void Financial(String money, String time, String type){
        File file=new File("/storage/emulated/0/","Financial.txt");
        try {
            file.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try {
            FileOutputStream fileoutputstream =this.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
            FileInputStream fileinputstream =this.openFileInput(file.getAbsolutePath());
            StringBuilder stringbuilder = new StringBuilder();
            InputStreamReader inputstreamreader = new InputStreamReader(fileinputstream, UTF_8);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
            String read =null;
            while((read =bufferedreader.readLine())!=null){
                stringbuilder.append(read+"\n");
            }
            String result = stringbuilder.toString();
            fileoutputstream.write((time+" "+money+"buy"+type).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getsystime(){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date=sDateFormat.format(new java.util.Date());;
        return date;
    }
}