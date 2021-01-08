package edu.hzuapps.androidlabs.net1814080903334;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

public class DownloadActivity extends AppCompatActivity {
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        saveButton = findViewById(R.id.main_save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAndSaveFile();
            }
        });
    }

    private void createAndSaveFile() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        boolean value;
        intent.putExtra(Intent.EXTRA_TITLE,"textFileXXX.txt");
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Uri uri =data.getData();

                try {


                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write("xxx".getBytes());
                    outputStream.close();

                    Toast.makeText(this,"File is save successfully",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    Toast.makeText(this,"Fail to write file",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this,"File not saved",Toast.LENGTH_SHORT).show();
            }
        }
    }
}