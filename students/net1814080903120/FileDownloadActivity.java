package edu.hzuapps.androidlabs.net1814080903120;

import android.graphics.Bitmap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class FileDownloadActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = FileDownloadActivity.class.getSimpleName();
    public static final String WEB = "http://www.bing.com";
    public static final String IMAGE_URL_PREFIX = "https://img.ivsky.com/img/tupian/pre/202005/11/";

    static String[] imageNames = {"zonglvshu-001.jpg","zonglvshu-002.jpg","zonglvshu-003.jpg"};

    private Button mCheckButton;  // null
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
        mDownloadImageButton.setOnClickListener(this); // NullPointerException
        mDownloadWebButton.setOnClickListener(this);

        // 获取内部存储目录: files
        mPrivateRootDir = getFilesDir();
        // 获取内部存储子目录: files/images
        mImagesDir = new File(mPrivateRootDir, "images");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_check) {
            //checkNetworkState(); // 检查网络
        } else if (view.getId() == R.id.button_download_image) {
            downloadImages(); // 下载图片
        } else if (view.getId() == R.id.button_download_web) {
            //downloadWebPage(); // 下载网页
        }
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
                Log.i(TAG, "!!!!! 当前进度 = " + percent);
                // System.out.println()
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
}