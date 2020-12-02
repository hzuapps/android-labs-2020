package com.example.thefirst.pool;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.example.thefirst.Net1814080903107Activity;
import com.example.thefirst.constant.transmission;
import com.example.thefirst.model.DownloadModel;
import java.io.DataInputStream;
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
                            final Bitmap bitmap=loadImage(bitmapName);
                            net1814080903107Activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ((ImageView)v).setImageBitmap(bitmap);
                                }
                            });
                        }
                    });
                }
            }
        }
    }
}
