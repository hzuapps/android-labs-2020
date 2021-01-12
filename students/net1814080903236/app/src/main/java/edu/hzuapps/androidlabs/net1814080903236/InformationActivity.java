package edu.hzuapps.androidlabs.net1814080903236;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;

public class InformationActivity extends AppCompatActivity {

     String fileName="record_file";

    private String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
          try {
              getEdt();
          } catch (IOException e) {
              e.printStackTrace();
          }

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,data);

        ListView listView=findViewById(R.id.ListView);
        listView.setAdapter(adapter);
    }
     private void getEdt() throws IOException {
          FileInputStream fileInputStream =openFileInput(fileName);
          byte[] input =new byte[fileInputStream.available()];
        while(fileInputStream.read(input) != -1){
             String str =new String(input);
            data =str.split("\n");

        }
       if (fileInputStream != null){
            fileInputStream.close();
        }
      }
}