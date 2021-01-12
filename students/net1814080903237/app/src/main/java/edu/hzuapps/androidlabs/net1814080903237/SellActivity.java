package edu.hzuapps.androidlabs.net1814080903237;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SellActivity extends AppCompatActivity{
    Button save,camera;
    EditText name,name1;
    TextView textView;
    ImageView photo;
    private final int CAMERA_REQUEST = 10;
    String filename="thing_file";
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sell);

            save = findViewById(R.id.save);
            camera = findViewById(R.id.camera);

            name = findViewById(R.id.name);
            name1 = findViewById(R.id.name1);
            textView=findViewById(R.id.textView1);
         //   photo = findViewById(R.id.photo);
            init();
    }
    public void saveClick(View view) throws IOException {
        String text =name.getText().toString();
        String prise=name1.getText().toString();

        FileOutputStream fileOutputStream = openFileOutput(filename, Context.MODE_APPEND);
        fileOutputStream.write(text.getBytes());
        if(fileOutputStream !=null){
            fileOutputStream.close();
        }
        Toast.makeText(this,"发布成功",Toast.LENGTH_LONG).show();
       /* FileInputStream fileInputStream =openFileInput(filename);
        byte[] input = new byte[fileInputStream.available()];
        while(fileInputStream.read(input)!=-1){
            String str =new String(input);
            textView.setText(str);
        }*/
    }
    public void init () {
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动本机摄像头
                Intent intent3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //启动系统拍照应用并显示在ImageView中
                startActivityForResult(intent3, CAMERA_REQUEST);
            }

        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQUEST:
                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    photo.setImageBitmap(bitmap);
                }
        }
    }



    }