# 实验六 Android网络编程

## 一、实验目标



1.掌握Android的网络访问方法；

2.理解XML和JSON表示数据的方法。

## 二、实验内容



1.从网络上下载一个文件（图片、MP3、MP4）；

2.保存到手机，在应用中使用文件；

3.将应用运行结果截图。

## 三、实验步骤

1.建立activity_file_download.xml;

activity_file_download.xml代码：

 ```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="edu.hzuapps.androidlabs.examples.FileDownloadActivity">

    <Button
        android:id="@+id/button_check"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="检查网络"/>

    <TextView
        android:id="@+id/text_network"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAlignment="center"/>

    <Button
        android:id="@+id/button_download_image"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="下载图片"/>

    <Button
        android:id="@+id/button_download_web"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="下载网页"/>

    <TextView
        android:id="@+id/text_result"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAlignment="center"/>

</LinearLayout>
 ```

2.建立FileDownloadActivity.java;

FileDownloadActivity.java代码：

```java
package edu.hzuapps.androidlabs.examples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import edu.hzuapps.androidlabs.R;

public class FileDownloadActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = FileDownloadActivity.class.getSimpleName();
    public static final String WEB = "http://www.bing.com";
    public static final String IMAGE_URL_PREFIX = "https://raw.githubusercontent.com/hzuapps/android-labs/master/app/src/main/res/drawable/";

    static String[] imageNames = {"image_bmp.png", "image_gif.png", "image_ico.png",
            "image_jpeg.png", "image_png.png", "image_tiff.png"};

    private Button mCheckButton;
    private Button mDownloadImageButton;
    private Button mDownloadWebButton;
    private TextView mNetworkText;
    private TextView mResultText;

    private boolean mConnected;

    private FileDownloader mFileDownloader;

    // App的内部存储目录
    private File mPrivateRootDir;
    // “images”子目录
    private File mImagesDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_download);

        mCheckButton = (Button) findViewById(R.id.button_check);
        mDownloadImageButton = (Button) findViewById(R.id.button_download_image);
        mDownloadWebButton = (Button) findViewById(R.id.button_download_web);
        mNetworkText = (TextView) findViewById(R.id.text_network);
        mResultText = (TextView) findViewById(R.id.text_result);

        mCheckButton.setOnClickListener(this);
        mDownloadImageButton.setOnClickListener(this);
        mDownloadWebButton.setOnClickListener(this);

        // 获取内部存储目录: files
        mPrivateRootDir = getFilesDir();
        // 获取内部存储子目录: files/images
        mImagesDir = new File(mPrivateRootDir, "images");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_check) {
            checkNetworkState(); // 检查网络
        } else if (view.getId() == R.id.button_download_image) {
            downloadImages(); // 下载图片
        } else if (view.getId() == R.id.button_download_web) {
            downloadWebPage(); // 下载网页
        }
    }

    // 检查网络状态
    private void checkNetworkState() {
        // 取得连接管理器
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // 检查当前激的网络
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            mConnected = true;
        } else {
            mConnected = false;
        }

        String types = "";

        // 检查Wi-Fi
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifiConn = networkInfo != null && networkInfo.isConnected();
        types += isWifiConn ? "Wi-Fi" : "";

        // 检查数据网络
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileConn = networkInfo != null && networkInfo.isConnected();
        types += isMobileConn ? "流量" : "";

        // 检查蓝牙
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH);
        boolean isBluetoothConn = networkInfo != null && networkInfo.isConnected();
        types += isBluetoothConn ? ", 蓝牙" : "";

        mNetworkText.setTextColor(mConnected ? Color.GREEN : Color.RED);
        mNetworkText.setText(mConnected ? "网络正常 (" +types + ")" : "网络未连接!");
    }

    // 下载图片
    private void downloadImages() {
        // 创建下载器
        mFileDownloader = new FileDownloader(new FileDownloader.OnImageDownloadListener() {
            @Override
            public void onError(String error) {
                Toast.makeText(FileDownloadActivity.this, error, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onProgressChange(int percent) {
                Log.i(TAG, "当前进度 = " + percent);
            }

            @Override
            public void onComplete(Bitmap bitmap, String imageUrl) {
                // 下载的图片格式为PNG
                final Bitmap.CompressFormat format = Bitmap.CompressFormat.PNG;
                // 解析出原始文件名
                String filename = imageUrl.replace(IMAGE_URL_PREFIX, "");
                final File imageFile = new File(mImagesDir, filename);
                // 将文件保存到磁盘中
                FileDownloader.writeToDisk(imageFile, bitmap, new FileDownloader.OnBitmapSaveListener() {
                    @Override
                    public void onBitmapSaved() {
                        Toast.makeText(FileDownloadActivity.this, "文件已保存: " + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onBitmapSaveError(String error) {
                        Toast.makeText(FileDownloadActivity.this, error, Toast.LENGTH_LONG).show();
                    }
                }, format, false);
            }
        });

        // 下载所有文件
        for(String imageName : imageNames) {
            String imageUrl = IMAGE_URL_PREFIX + imageName;
            mFileDownloader.download(imageUrl, true);
        }
    }

    // 下载网页
    private void downloadWebPage() {
    }
}
```

3.建立FileDownloader.java.

FileDownloader.java代码：

```java
package edu.hzuapps.androidlabs.examples;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义文件下载器。
 */
public class FileDownloader {

    public static final String TAG = FileDownloader.class.getSimpleName();
    public static final int MAX_SIZE = 8192;

    // 记录当前下载的URL
    private Set<String> mUrlsInProgress = new HashSet<>();
    private OnImageDownloadListener mImageDownloadListener;

    public FileDownloader(@NonNull OnImageDownloadListener listener) {
        mImageDownloadListener = listener;
    }
    
    /**
     * 自定义监听器,供外部处理.
     */
    public interface OnImageDownloadListener {
        void onError(String error);

        void onProgressChange(int percent);

        void onComplete(Bitmap bitmap, String imageUrl);
    }

    /**
     * 使用多线程下载文件.
     * @param imageUrl
     * @param displayProgress
     */
    public void download(@NonNull final String imageUrl, final boolean displayProgress) {
        if (mUrlsInProgress.contains(imageUrl)) {
            Log.w(TAG, "该图片已经在下载列表中!");
            return;
        }

        // 启动异步线程下载图片
        new AsyncTask<Void, Integer, Bitmap>() {
            private String error;

            @Override
            protected void onPreExecute() {
                mUrlsInProgress.add(imageUrl);
                Log.d(TAG, "开始下载……");
            }

            @Override
            protected void onCancelled() {
                mUrlsInProgress.remove(imageUrl);
                mImageDownloadListener.onError(error);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                mImageDownloadListener.onProgressChange(values[0]);
            }

            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap bitmap = null;
                HttpURLConnection connection = null;
                InputStream is = null;
                ByteArrayOutputStream out = null;
                try { // 创建连接
                    connection = (HttpURLConnection) new URL(imageUrl).openConnection();
                    if (displayProgress) {
                        connection.connect(); // 建立连接
                        final int length = connection.getContentLength();
                        if (length <= 0) {
                            error = "URL不正确!";
                            this.cancel(true);
                        }
                        is = new BufferedInputStream(connection.getInputStream(), MAX_SIZE);
                        out = new ByteArrayOutputStream();
                        byte bytes[] = new byte[MAX_SIZE];
                        int count;
                        long read = 0;
                        while ((count = is.read(bytes)) != -1) {
                            read += count;
                            out.write(bytes, 0, count);
                            publishProgress((int) ((read * 100) / length));
                        }
                        bitmap = BitmapFactory.decodeByteArray(out.toByteArray(), 0, out.size());
                    } else {
                        is = connection.getInputStream();
                        bitmap = BitmapFactory.decodeStream(is);
                    }
                } catch (Throwable e) {
                    if (!this.isCancelled()) {
                        error = "网络错误!";
                        this.cancel(true);
                    }
                } finally {
                    try {
                        if (connection != null)
                            connection.disconnect();
                        if (out != null) {
                            out.flush();
                            out.close();
                        }
                        if (is != null)
                            is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                if (result == null) {
                    Log.e(TAG, "下载结果为空!");
                    mImageDownloadListener.onError("文件无法解码!");
                } else {
                    Log.d(TAG, "下载完成,大小为 " + result.getByteCount());
                    mImageDownloadListener.onComplete(result, imageUrl);
                }
                mUrlsInProgress.remove(imageUrl);
                System.gc();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }


    // 将下载的文件保存到磁盘中
    public interface OnBitmapSaveListener {
        void onBitmapSaved();
        void onBitmapSaveError(String error);
    }
    // 声明为静态方式,直接使用.
    public static void writeToDisk(@NonNull final File imageFile, @NonNull final Bitmap image,
                                   @NonNull final OnBitmapSaveListener listener,
                                   @NonNull final Bitmap.CompressFormat format, boolean shouldOverwrite) {

        if (imageFile.isDirectory()) {
            listener.onBitmapSaveError("存在同名目录!");
            return;
        }

        if (imageFile.exists()) {
            if (!shouldOverwrite) {
                listener.onBitmapSaveError("文件已存在!");
                return;
            } else if (!imageFile.delete()) {
                listener.onBitmapSaveError("无法删除原始同名文件!");
                return;
            }
        }

        File parent = imageFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            listener.onBitmapSaveError("无法创建上级目录!");
            return;
        }

        try {
            if (!imageFile.createNewFile()) {
                listener.onBitmapSaveError("无法创建文件!");
                return;
            }
        } catch (IOException e) {
            listener.onBitmapSaveError("写入文件失败!");
            return;
        }

        new AsyncTask<Void, Void, Void>() {

            private String error;

            @Override
            protected Void doInBackground(Void... params) {
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(imageFile);
                    image.compress(format, 100, fos);
                } catch (IOException e) {
                    error = "写入文件失败!";
                    this.cancel(true);
                } finally {
                    if (fos != null) {
                        try {
                            fos.flush();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }

            @Override
            protected void onCancelled() {
                listener.onBitmapSaveError(error);
            }

            @Override
            protected void onPostExecute(Void result) {
                listener.onBitmapSaved();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
```





## 四、运行结果及截图



![result](6.png)





## 五、实验心得

通过本次实验，我掌握了Android的网络访问方法，并且通过实际运行调试，理解XML和JSON表示数据的方法。



