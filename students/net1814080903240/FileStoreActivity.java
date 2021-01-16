package edu.hzuapps.androidlabs.net1814080903240;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStoreActivity extends AppCompatActivity {
    private EditText suggest_editText;
    private Button save_btn;
    private Button show_btn;
    private TextView mContent;
    private final String mFileName = "test.txt";

    private Button take_photo;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filestore);

        suggest_editText = findViewById(R.id.et_suggest);
        save_btn = findViewById(R.id.save_btn);
        show_btn = findViewById(R.id.show_btn);
        mContent = findViewById(R.id.text_view);

        //处理点击按钮
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(suggest_editText.getText().toString());
                mContent.setText("");
            }
        });

        //处理点击按钮
        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContent.setText(read());
            }
        });


        //准备界面
        linearLayout = findViewById(R.id.comment_camera);

        //处理点击按钮
        take_photo = findViewById(R.id.take_photos);
        take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //请求拍照
                dispatchTakePhotoIntent();
            }
        });
    }


    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuffer sb = new StringBuffer("");
            int length = 0;
            while ((length = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,length));
            }return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    static final int REQUEST_IMAGE_CAPTURE =1;

    // 请求拍照
    private void dispatchTakePhotoIntent(){
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePhotoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePhotoIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

    //获取缩略图
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && requestCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = new ImageView(this);
            //设置图片大小
            imageView.setImageBitmap(imageBitmap);
            linearLayout.addView(imageView);
        }
    }
}