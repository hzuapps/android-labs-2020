package edu.hzuapps.androidlabs.net1814080903215;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UpDownloadActivity extends AppCompatActivity {

    private Button buttonImage;
    private ImageView imageView;

    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_download);

        Button btn1 = (Button)findViewById(R.id.button);
        final UpDownloadActivity thisActivity = this;
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,PersonalHomeActivity.class);
                thisActivity.startActivity(intent);
            }
        });


        Button btn3 = (Button)findViewById(R.id.button2);
        final UpDownloadActivity thisActivity2 = this;
        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity2,MainActivity.class);
                thisActivity2.startActivity(intent);
            }
        });

        Button btn4 = (Button)findViewById(R.id.button9);
        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent,1);

            }
        });

            this.buttonImage = (Button) this.findViewById(R.id.button4);
            this.imageView = (ImageView) this.findViewById(R.id.imageView5);

            this.buttonImage.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    captureImage();
                }
            });//呼叫照相方法


        }


        private void captureImage() {
            // Create an implicit intent, for image capture.
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // Start camera and wait for the results.
            this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
        }//执行相机的调用



        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {//调用完相机并拍照后会执行
            //第二个 Activity 指定的结果代码。
            // 如果操作成功，此为 RESULT_OK；如果用户退出或操作出于某种原因失败，则是 RESULT_CANCELED
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
                if (resultCode == RESULT_OK) {
                    //请求使用照相，而且用户同意使用相机权限
                    Bitmap bp = (Bitmap) data.getExtras().get("data");
                    //得到intent返回的信息
                    //保存图片等信息
                    this.imageView.setImageBitmap(bp);
                    //设置照片成果

                    save(bp);
                    //调用创建文件

                } else if (resultCode == RESULT_CANCELED) {
                    //用户不授权使用照相机
                    Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
                    //不授权使用相机和请求码不是request image
                }


            }

        }

        private void save(Bitmap bp) {

            File Pdirectory = new File(Environment.getExternalStorageDirectory()+File.separator+"草泥马");

            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);
            String fname = "Image-" + n + ".jpg";
            File file = new File(Pdirectory,fname);
            //在目录下添加东西
            Pdirectory.mkdirs();
            //创建目录

            try{
                FileOutputStream out = new FileOutputStream(file);
                bp.compress(Bitmap.CompressFormat.JPEG,100,out);
                out.flush();
                out.close();
                //compress(Bitmap.CompressFormat format, int quality, OutputStream stream)

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
