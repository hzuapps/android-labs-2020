package edu.hzuapps.androidlabs.net1814080903236;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class RecordActivity extends AppCompatActivity {

    Button button_record,button_information;
    EditText  editName,editSex,data;
    String fileName="record_file";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        editName=findViewById(R.id.editName);
        editSex=findViewById(R.id.editSex);
        data=findViewById(R.id.data);

        button_record = findViewById(R.id.button2_1);
        button_information = findViewById(R.id.button2_2);

    }
    public void btn2_1Click(View view) throws IOException {
       String name=editName.getText().toString();
       String sex= editSex.getText().toString();
       String d=data.getText().toString();

        FileOutputStream fileOutputStream=openFileOutput(fileName, Context.MODE_APPEND);
        fileOutputStream.write((name+","+sex+","+d+"\n").getBytes());
        if(fileOutputStream!=null){
            fileOutputStream.close();
        }
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }
    public void btn2_2Click(View view){
        final RecordActivity thisActivity2 = this;
        button_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity2,InformationActivity.class);
                RecordActivity.this.startActivity(intent);
            }
        });
    }
}
