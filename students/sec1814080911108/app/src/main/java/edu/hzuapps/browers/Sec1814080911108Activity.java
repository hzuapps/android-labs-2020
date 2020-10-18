package edu.hzuapps.browers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sec1814080911108Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911108);

        // 按钮添加点击事件
        Button listButton = (Button)findViewById(R.id.btnLoveList);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 发出Toast
                Toast.makeText(Sec1814080911108Activity.this, "遇见爱情", Toast.LENGTH_SHORT).show();
                // 显式Intent
                Intent intent = new Intent(Sec1814080911108Activity.this,LoveListActivity.class);
                startActivity(intent);
            }
        });
    }
}