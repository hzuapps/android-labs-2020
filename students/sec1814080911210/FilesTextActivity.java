package edu.hzuapps.androidlabs.sec1814080911210;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FilesTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_text);

        final Activity thisActivity = this;



        EditText text = (EditText) findViewById(R.id.name);
        final String inputText = text.getText().toString();


        Button btnOpen = (Button) findViewById(R.id.yes);
        View view = findViewById(R.id.yes);
        assert btnOpen != null;
        assert btnOpen != null;
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(thisActivity.getFilesDir(), "lab5.txt");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    FileOutputStream fos = thisActivity.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(inputText);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
