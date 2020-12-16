package com.example.thefirst.pool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.example.thefirst.Net1814080903107Activity;
import com.example.thefirst.R;
import com.example.thefirst.constant.transmission;
import com.example.thefirst.model.DownloadModel;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//图片下载池
import static com.example.thefirst.NetworkInit.loadImage;

public class DownloadPool extends Thread implements transmission {
    private Net1814080903107Activity net1814080903107Activity;
    public static ConcurrentLinkedQueue<DownloadModel> queue=new ConcurrentLinkedQueue<DownloadModel>();
    private ExecutorService pool = Executors.newCachedThreadPool();
    public DownloadPool(Net1814080903107Activity net1814080903107Activity){
        this.net1814080903107Activity=net1814080903107Activity;
    }
    public void run(){
        while(true){
            while (!queue.isEmpty()){
                DownloadModel model=queue.poll();
                final View v=model.getView();
                final int type=model.getType();
                final String bitmapName=model.getBitmapName();
                if(type==IMAGEVIEW){
                    pool.execute(new Runnable() {
                        @Override
                        public void run() {
                            Bitmap bitmap1=loadImage(bitmapName);
                            Bitmap bitmap2=BitmapFactory.decodeResource(net1814080903107Activity.getResources(), R.drawable.lost);
                            Bitmap bitmap3=(bitmap1==null)?bitmap2:bitmap1;
                            net1814080903107Activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ((ImageView)v).setImageBitmap(bitmap1);
                                }
                            });
                            File PHOTO_DIR = new File("data/data/com.example.thefirst");//设置保存路径
                            File avaterFile = new File(PHOTO_DIR, bitmapName);//设置文件名称
                            if(avaterFile.exists()){
                                avaterFile.delete();
                            }
                            try {
                                avaterFile.createNewFile();
                                FileOutputStream fos = new FileOutputStream(avaterFile);
                                bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                fos.flush();
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }
}
