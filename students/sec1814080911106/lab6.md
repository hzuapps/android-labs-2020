# # 实验六
# 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。


# 二、实验内容
1.从网络下载一个文件（图片、MP3、MP4）；
2.保存到手机，在应用中使用文件；
3.将应用运行结果截图。


# 三、实验步骤
1.添加相关权限
```java
    <uses-permission android:name="android.permission.INTERNET" />

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

```

2. 在子线程中连接到网络
```java

    private Runnable connectNet = new Runnable(){
        @Override
        public void run() {
            try {
                String filePath = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1762068863,3837136581&fm=26&gp=0.jpg";
                mFileName = "test3.jpg";
                //取得InputStream，直接从InputStream生成bitmap
                mBitmap = BitmapFactory.decodeStream(getImageStream(filePath));
                // 发送消息，通知handler在主线程中更新UI
                connectHanlder.sendEmptyMessage(0);
                Log.d(TAG, "set image ...");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    };
```

3. 下载图片
```java

        mBtnSave.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                mSaveDialog = ProgressDialog.show(httpPictureActivity.this, "保存图片", "图片正在保存中，请稍等...", true);
                new Thread(saveFileRunnable).start();
            }
        });
    }


    //从服务器获取图片
    public byte[] getImage(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            return readStream(inStream);
        }
        return null;
    }

    public InputStream getImageStream(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            return conn.getInputStream();
        }
        return null;
    }

    public static byte[] readStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1){
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }
```

4.保存图片
```java
    public void saveFile(Bitmap bm, String fileName) throws IOException {
        File dirFile = new File(ALBUM_PATH);
        if(!dirFile.exists()){
            dirFile.mkdir();
        }
        File myCaptureFile = new File(ALBUM_PATH + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
    }
```

# 四、实验结果

![实验六结果](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/lab6-1.png)
![实验六结果](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/lab6-2.png)

# 五、实验心得体会
通过本次实验，我学习了Android网络编程，从网络中下载图片并保存。在实验过程中，我了解到从网络上取得的图片，生成Bitmap时有两种方法，一种是先转换为byte[]，再生成bitmap；一种是直接用InputStream生成bitmap，在本次实验过程中我使用了直接从InputStream生成bitmap的方法。


