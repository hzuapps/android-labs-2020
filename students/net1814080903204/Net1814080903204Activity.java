package edu.hzuapps.androidlabs.net1814080903204;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Net1814080903204Activity extends AppCompatActivity {
    private EditText edit;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.Button1);
        Button button2 = (Button) findViewById(R.id.Button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903204Activity.this, setting.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903204Activity.this, remind.class);
                startActivity(intent);
            }
        });

        Button btn_write = (Button) findViewById(R.id.id_btn_write);//
        edit = (EditText) findViewById(R.id.MedicineName);


        btn_write.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = edit.getText().toString();
                save(text);
            }
        });


        btn_write.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = edit.getText().toString();
                save(text);
            }
        });

    }

    public void save(String text) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}