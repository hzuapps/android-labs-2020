package edu.hzuapps.androidlabs.net1814080903315;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddNet1814080903315MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_net1814080903315);

        final AddNet1814080903315MainActivity thisActivity = this;

        Button button1 = (Button) findViewById(R.id.save);//第1个button

        Button button2 = (Button) findViewById(R.id.chose);//第2个button
        Button button3 = (Button) findViewById(R.id.seek);//第3个button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ContentProviderActivity.class);//实现第1个跳转
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ChoseActivity.class);//实现第2个跳转
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, AddSeekActivity.class);//实现第三个跳转
                startActivity(intent);
            }
        });

    }
}
