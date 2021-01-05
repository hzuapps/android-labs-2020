package edu.hzuapps.androidlabs.net1814080903319;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Net1814080903319MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mCheckButton;
    private TextView mNetworkText;
    private boolean mConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Net1814080903319MainActivity thisActivity=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903319);

        Button jump = findViewById(R.id.tiaozhuang);
        jump.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ItemActivity.class);
                startActivity(intent);
            }
        });
        mCheckButton = (Button) findViewById(R.id.button_check);
        mNetworkText = (TextView) findViewById(R.id.text_network);
        mCheckButton.setOnClickListener(this);
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

        mNetworkText.setTextColor(mConnected ? Color.rgb(243,148,224) : Color.RED);
        mNetworkText.setText(mConnected ? "--> 网络正常 (" +types + ")" : "--> 网络未连接!");
    }
}
