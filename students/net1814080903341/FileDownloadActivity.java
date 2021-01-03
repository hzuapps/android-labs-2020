package edu.hzuapps.Net1814080903341Activity;


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

import edu.hzuapps.Net1814080903341Activity.R;

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

//    private FileDownloader mFileDownloader;

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


}