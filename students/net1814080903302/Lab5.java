package edu.hzuapps.myapplication0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab5_activity);
    }

    public void save(View view) {
        String filename = "myfile";
        String string = "Hello world!";
        File file = new File(getFilesDir(), filename);
        FileOutputStream outputStream;
        try {
            file.createNewFile();
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
