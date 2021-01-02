package edu.hzuapps.androidlabs.net1814080903320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.myapplication.R;

public class RunActivity extends AppCompatActivity {

    private boolean mConnected;

    // 检查网络状态
    private void checkNetworkState() {
        EditText text = this.findViewById(R.id.editText2);
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
        boolean isWifiConn = (networkInfo != null) && networkInfo.isConnected();
        types += isWifiConn ? "Wi-Fi" : "";

        // 检查数据网络
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileConn = (networkInfo != null) && networkInfo.isConnected();
        types += isMobileConn ? "流量" : "";

        // 检查蓝牙
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH);
        boolean isBluetoothConn = (networkInfo != null) && networkInfo.isConnected();
        types += isBluetoothConn ? ", 蓝牙" : "";

        text.setTextColor(mConnected ? Color.GREEN : Color.RED);
        text.setText(mConnected ? "网络正常 (" +types + ")" : "网络未连接!");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);
        Button insert = this.findViewById(R.id.insert);
        checkNetworkState(); // 检查网络
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });
    }
}
