package com.example.Net1714080903132;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView img;
    private TextView btn_take_photo;
    private TextView btn_save_photo;
    private TextView btn_take_video;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    public static Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        btn_take_photo = findViewById(R.id.btn_take_photo);
        btn_save_photo = findViewById(R.id.btn_save_photo);
        btn_take_video = findViewById(R.id.btn_take_video);

        btn_take_photo.setOnClickListener(this);
        btn_save_photo.setOnClickListener(this);
        btn_take_video.setOnClickListener(this);

        requestPermission();
    }

    private void requestPermission() {
        String[] permissions = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };
        for (int i = 0; i > permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permissions[i]}, 200);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_take_photo:   //拍照
                dispatchTakePictureIntent();
                break;
            case R.id.btn_save_photo:    //保存照片
                Bitmap bitmap = ((BitmapDrawable)img.getDrawable()).getBitmap();
                saveBitmapFile(bitmap);
                break;
            case R.id.btn_take_video:   //拍视频
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                Uri fileUri = null;
                try {
                    fileUri = Uri.fromFile(createMediaFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                startActivityForResult(intent, 22);
                break;
        }
    }

    /**
     * 创建图片文件
     * @return
     * @throws IOException
     */
    private File createMediaFile() throws IOException {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), "CameraDemo");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "VID_" + timeStamp;
        String suffix = ".mp4";
        File mediaFile = new File(mediaStorageDir + File.separator + imageFileName + suffix);
        return mediaFile;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //图片拍摄完成
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
             imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);        //设置界面图片
        }
        //视频拍摄完成
        else if (requestCode == 22) {
            if (resultCode == RESULT_OK) {
                // Video captured and saved to fileUri specified in the Intent
                Uri data1 = data.getData();
                //拿到视频保存地址
                String name = data1.toString();
                String[] split = name.split(":");
                Message msg = Message.obtain();
                msg.obj = split[1];
                if (handler != null) {
                    handler.sendMessage(msg);
                }
                Log.e("视频地址：",":"+msg.obj);
                Toast.makeText(this, "视频已保存！！！！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(data1);
                this.sendBroadcast(intent);
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the video capture
            } else {
                // Video capture failed, advise user
            }
        }
    }
    Bitmap imageBitmap;


    /**
     * 保存图片
     * @param bitmap
     */
    public void saveBitmapFile(Bitmap bitmap) {
        Toast.makeText(this, "保存前", Toast.LENGTH_SHORT).show();
        File file = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
//                getExternalFilesDir(null).getAbsolutePath(),
                System.nanoTime()+".jpg");//将要保存图片的路径
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("出错",""+e);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            fos.write(bos.toByteArray());
            fos.flush();
            fos.close();

            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);
            intent.setData(uri);
            this.sendBroadcast(intent);


        } catch (IOException e) {
            e.printStackTrace();
            Log.e("保存失败：",e+"");
        }
        Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
    }

}
