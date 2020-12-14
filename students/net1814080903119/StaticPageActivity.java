package edu.hzuapps.androidlabs.net1814080903119;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static edu.hzuapps.androidlabs.net1814080903119.MyImageView.returnBitMap;
import static edu.hzuapps.androidlabs.net1814080903119.SaveImageUrl.ImageUrlCol;

public class StaticPageActivity extends AppCompatActivity {
    private static Context context;
    private Button staticSet;
    private Button staticDownlo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_page);

        //判断当前系统版本，是否需要申请权限
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }

        staticSet = findViewById(R.id.button4);
        staticDownlo = findViewById(R.id.button6);
        MyImageView imageView = findViewById(R.id.imageView);
        Intent intent=getIntent();
        final Integer posion = intent.getIntExtra("id",0);
        imageView.setImageURL(ImageUrlCol[posion]);
        staticSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StaticPageActivity.this,"设置成功", Toast.LENGTH_SHORT).show();
                WallpaperManager mWallManager = WallpaperManager.getInstance(StaticPageActivity.this);
                try
                {
                    mWallManager.setBitmap(returnBitMap(ImageUrlCol[posion]));
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        staticDownlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL conurl = null;
                try {
                    conurl = new URL(ImageUrlCol[posion]);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection con = null;
                try {
                    con = (HttpURLConnection) conurl.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(StaticPageActivity.this,"下载成功", Toast.LENGTH_SHORT).show();
                try {
                    saveImageToGallery(StaticPageActivity.this,BitmapFactory.decodeStream(con.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;
    //申请权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("StaticPageActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }


    public static void saveImageToGallery(Context context, Bitmap bmp) {
       // 首先保存图片
       File appDir = new File(Environment.getExternalStorageDirectory(), "");
       if (!appDir.exists()) {
           appDir.mkdir();
       }
       String fileName = System.currentTimeMillis() + ".jpg";
       File file = new File(appDir, fileName);
       try {
           FileOutputStream fos = new FileOutputStream(file);
           bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
           fos.flush();
           fos.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

       // 其次把文件插入到系统图库
       try {
           MediaStore.Images.Media.insertImage(context.getContentResolver(),
                   file.getAbsolutePath(), fileName, null);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       // 最后通知图库更新
       context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
   }
}