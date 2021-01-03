# 实验六 Android网络编程

## 一、实验要求

1、掌握Android网络访问方法

2、理解XML和JSON表示数据的方法

## 二、实验内容（选做）

一、

1、在个人目录中创建一个表示数据的XML或JSON文件；

2、数据文件代码提交之后从GitHub获取文件URL；

3、在应用中通过网络编程访问GitHub的数据文件；

4、在应用中解析并显示文件所包含的数据；

5、将应用运行结果截图。


二、

1、从网络下载一个文件（图片、MP3、MP4）；

2、保存到手机，在应用中使用文件；

3、将应用运行结果截图。

## 三、实验步骤

1、创建3个按钮并实现方法，检查网络、下载图片、下载网页。

```java

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

```

2、在对应的xml文件中对按钮和下载界面进行调整

```java

<Button
        android:id="@+id/button_check"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="检查网络"/>

    <TextView
        android:id="@+id/text_network"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAlignment="center"
        android:gravity="center_horizontal" />

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
        android:textAlignment="center"
        android:gravity="center_horizontal" />

```        
        
## 四、实验结果        
        
![lab6](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab6.png)    

## 五、实验心得

  这次实验预想是在自己的app中没有应用到的，所以我在我的app主页中加了一个跳转按钮来实现文件下载的页面，就是代码写完之后，手机没有网络所以没办法进行下载。

