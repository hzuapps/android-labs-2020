# 实验六

## 一、实验目标

1. 解决实验五留下的闪退问题
2. 解决商品展示有限的问题

## 二、实验内容

1. 对代码进行修改运行。
2. 在页面跳转后在输出框中输出对应的网络类型。

## 三、实验步骤
1.对代码进行修改运行。
```
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
 ```
2. 在页面跳转后在输出框中输出对应的网络类型。
```
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
```

 ## 四、实验结果
[第六次实验图片](https://github.com/taoge183/android-labs-2020/blob/master/students/net1814080903320/shiyan6.PNG)

 ## 五、心得体会
  本次实验，主要是对于网络的设置。本次实验成功添加了网络连接代码，希望在接下来可以有进一步的实现完善网络功能。
