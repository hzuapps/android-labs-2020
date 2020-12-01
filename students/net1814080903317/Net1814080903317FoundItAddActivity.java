package com.example.foundit.controller.activity.foundIt;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foundit.R;
import com.example.foundit.controller.activity.MainActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * author: djx
 * created on: 2020/9/28 15:25
 * description:失物招领发布的页面
 */
public class Net1814080903317FoundItAddActivity extends Activity {

    private ImageView backIv;
    private TextView publicTv;
    private EditText titleEt;
    private EditText contentEt;
    private ImageView takePhotoIv;
    private ImageView photoGalleryIv;
    private RecyclerView picRecycerView;
    private ImageView showPicIv;
    private static final int PHOTO_PICKED_WITH_DATA = 3021;
    private static final int CAMERA_WITH_DATA = 3023;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foundit_add);
        initView();
        initListener();
    }

    private void initListener() {
        takePhotoIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
    }

    /**
     * 拍照
     */
    private void takePhoto() {
        //直接询问

        ActivityCompat.requestPermissions(Net1814080903317FoundItAddActivity.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用系统相机
        startActivityForResult(intent,CAMERA_WITH_DATA);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if(resultCode!=RESULT_OK)
            return;
        switch(requestCode){
            case CAMERA_WITH_DATA:
                final Bitmap photo = data.getParcelableExtra("data");
                if(photo!=null){
                    doCropPhoto(photo);
                }
            case PHOTO_PICKED_WITH_DATA:
                Bitmap photo1 = data.getParcelableExtra("data");
                if(photo1!=null){
                    showPicIv.setVisibility(View.VISIBLE);
                    showPicIv.setImageBitmap(photo1);
                }

        }
    }
    protected void doCropPhoto(Bitmap data){
        Intent intent = getCropImageIntent(data);
        startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
    }
    public static Intent getCropImageIntent(Bitmap data) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType("image/*");
        intent.putExtra("data", data);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 128);
        intent.putExtra("outputY", 128);
        intent.putExtra("return-data", true);
        return intent;
    }

    private void initView() {
        backIv = findViewById(R.id.foundit_add_back_iv);
        publicTv = findViewById(R.id.foundit_add_public_tv);
        titleEt = findViewById(R.id.foundit_add_title_et);
        contentEt = findViewById(R.id.foundit_add_content_et);
        takePhotoIv = findViewById(R.id.foundit_add_takephoto_iv);
        photoGalleryIv = findViewById(R.id.foundit_add_photogallery_iv);
        showPicIv = findViewById(R.id.foundit_add_showtakephoto_iv);

        picRecycerView = findViewById(R.id.foundit_add_picshow_recyclerview);

    }
}