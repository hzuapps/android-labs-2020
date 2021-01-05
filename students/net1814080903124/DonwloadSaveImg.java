package edu.hzuapps.androidlabs.net1814080903124;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DonwloadSaveImg {
    private static Context context;
    private static String filePath;
    private static Bitmap mBitmap;
    private static String mSaveMessage = "失败";
    private final static String TAG = "DonwloadSaveImg";
    private static ProgressDialog mSaveDialog = null;

    public static void donwloadImg(Context contexts, String filePaths) {
        context = contexts;
        filePath = filePaths;
        mSaveDialog = ProgressDialog.show(context, "保存图片", "图片正在保存中，请稍等...", true);
        new Thread(saveFileRunnable).start();
    }

    private static Runnable saveFileRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                if (!TextUtils.isEmpty(filePath)) { //网络图片
                    // 对资源链接
                    URL url = new URL(filePath);
                    //打开输入流
                    InputStream inputStream = url.openStream();
                    //对网上资源进行下载转换位图图片
                    mBitmap = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                }
                saveFile(mBitmap);
                mSaveMessage = "图片保存成功！";
            } catch (IOException e) {
                mSaveMessage = "图片保存失败！";
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            messageHandler.sendMessage(messageHandler.obtainMessage());
        }
    };

    private static Handler messageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSaveDialog.dismiss();
            Log.d(TAG, mSaveMessage);
            Toast.makeText(context, mSaveMessage, Toast.LENGTH_SHORT).show();
        }
    };

    //保存图片
    public static void saveFile(Bitmap bm ) throws IOException {
        File dirFile = new File(Environment.getExternalStorageDirectory().getPath());
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File myCaptureFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+""+ fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
        //把图片保存后声明这个广播事件通知系统相册有新图片到来
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(myCaptureFile);
        intent.setData(uri);
        context.sendBroadcast(intent);
    }
}

