package edu.hzuapps.androidlabs.net1814080903328;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903328Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Net1814080903328Activity thisActivity = this;

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(thisActivity, RuleActivity.class);
                startActivity(intent);

            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(thisActivity, SkillsActivity.class);
                startActivity(intent);

            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            //  @Override 
            public void onClick(View v){
                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。 
                //在存放资源代码的文件夹下下， 

                EditText editText = (EditText)findViewById(R.id.editText) ;

                String string = editText.getText().toString();
                if(TextUtils.isEmpty(string)){
                    Toast.makeText(Net1814080903328Activity.this,"请输入A队队名!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                EditText editText2 = (EditText)findViewById(R.id.editText2) ;

                String string2 = editText2.getText().toString();
                if(TextUtils.isEmpty(string2)){
                    Toast.makeText(Net1814080903328Activity.this,"请输入B队队名!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                //
                Intent i = new Intent(Net1814080903328Activity.this , ScoreActivity.class);

                i.putExtra("editText",string);
                i.putExtra("editText2",string2);

                //启动 
                startActivity(i);
            }
        });

    }
}