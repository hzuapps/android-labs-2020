package edu.hzuapps.androidlabs.net1814080903215;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    File  showPIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button)findViewById(R.id.button);
        final MainActivity thisActivity = this;
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, PersonalHomeActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        Button btn2 = (Button)findViewById(R.id.button3);
        final MainActivity thisActivity3 = this;
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity3,UpDownloadActivity.class);
                thisActivity3.startActivity(intent);
            }
        });



            /*button=findViewById(R.id.button10);
            imageView=findViewById(R.id.imageView7);


            if (Build.VERSION.SDK_INT>=23){
                requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},2);
            }//请求权限


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dispafuckpic();

                }
            });
        }


        private void dispafuckpic() {
            Intent takepic=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            if (takepic.resolveActivity(getPackageManager())!=null){
                //这代表你的app可以允许相机

                startActivityForResult(takepic,1);
                File photofile=null;

                try{

                    photofile=cratephotofile();//去创建文件方法,获得图片路径创建的
                    showPIC=photofile;

                    if (photofile!=null) {
                        String pathtofile = photofile.getAbsolutePath();
                        Log.e("testt","seee:"+pathtofile);
                        Uri photouri=FileProvider.getUriForFile(MainActivity.this,"comgin.example.root.hightqualitycame.fileprovider",photofile);
                        //把这个图片和其他app分享，AUTHORITY是自己定义的,第三个必须是完整的图片路径
                        takepic.putExtra(MediaStore.EXTRA_OUTPUT,photouri);
                    //把share的Uri放进选好的路径
                        startActivityForResult(takepic,1);
                    }

                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }















        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode==RESULT_OK){
                if (requestCode==1){
                    Bitmap bitmap=BitmapFactory.decodeFile(String.valueOf(showPIC));
//String.valueOf进行一个String转型


                    imageView.setImageBitmap(bitmap);
                }
            }
        }








        public File  cratephotofile() throws IOException {//返回一个File类的文件



            String name=new SimpleDateFormat("YYYYMMdd_HHmmss").format(new Date());
//年月日小时分秒


            File stordir=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            //获得公共目录下的图片文件路径


            File image=File.createTempFile(name,".jpg",stordir);
            //1：字首2：后缀3：在哪个目录下

            return  image;
        }*/

    }
}
