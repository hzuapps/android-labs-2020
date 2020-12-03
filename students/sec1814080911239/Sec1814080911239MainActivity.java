package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sec1814080911239MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到文字
        TextView mTextView_share =(TextView)findViewById(R.id.button1);
        TextView mTextView_knowledge =(TextView)findViewById(R.id.button2);
        TextView mTextView_solve =(TextView)findViewById(R.id.button3);
        //取出文字
        final String mstring_share = mTextView_share.getText().toString();
        final String mstring_knowledge = mTextView_knowledge.getText().toString();
        final String mstring_solve = mTextView_solve.getText().toString();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        Intent intent = new Intent(Sec1814080911239MainActivity.this, ShareActivity.class);
                        intent.putExtra("mstring_share",mstring_share);
                        startActivity(intent);
                        break;
                }

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button2:
                        Intent intent = new Intent(Sec1814080911239MainActivity.this, KnowledgeActivity.class);
                        intent.putExtra("mstring_knowledge",mstring_knowledge);
                        startActivity(intent);
                        break;
                }

            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button3:
                        Intent intent = new Intent(Sec1814080911239MainActivity.this,SolveActivity.class);
                        intent.putExtra("mstring_solve",mstring_solve);
                        startActivity(intent);
                        break;
                }

            }
        });
    }
}