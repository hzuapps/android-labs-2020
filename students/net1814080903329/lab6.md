# 实验六 Android网络编程

# 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

# 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

# 三、实验步骤

1. 在AndroidManifest.xml中添加user-permission

```
 <uses-permission android:name="android.permission.INTERNET" />
```

1. 创建HttpUrlConnectionActivity类，用于进行网络编程测试；
2. 在HttpUrlConnectionActivity类编写向发送网络请求sendRequestWithHttpURLConnection(View view)的方法和响应网络请求方法,访问CSDN开发者社区；

核心代码
```
public void sendRequestWithHttpURLConnection(View view) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection= null;
                    BufferedReader reader = null;

                    try {
                        URL url = new URL("https://www.csdn.com");
                         //获取
                        connection = (HttpURLConnection) url.openConnection();
                       //使用GET方法访问网络
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(5000);
                        connection.setReadTimeout(5000);
                       InputStream in = connection.getInputStream();
                            reader = new BufferedReader(new InputStreamReader(in));

                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        showResponse(response.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (connection != null) {
                            connection.disconnect();
                        }
                    }
                }
            }).start();
        }

    public void showResponse(final String response){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            tvResponse.setText(response);
        }
    });

    }
} 
```
3.创建一个SaveImageViewActivity类用于下载网络图片
```
    //读取图片
       public void readImg(View v) {
        String path = Environment.getExternalStorageDirectory() + "/1.png";
        根据URI 加载图片
        showImg.setImageURI(Uri.parse(path));

       }
 
    //保存图片
      public void saveImg(View v) {
        //获取BitmapDrawable对象
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        /*
        通过Bitmap(位图)压缩的方法（compress）保存图片到SD卡
        参数1:图片格式（PNG JPEJ WEBP）
        参数2：图片质量（0-100）
        参数3：输出流
         */
        //取得SD卡根目录
        File root = Environment.getExternalStorageDirectory();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(root + "/1.png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    //获取网络图片
    public void getUrlImg(View v) {
        new GetImg().execute("http://img2.imgtn.bdimg.com/it/u=169341381,1292926655&fm=21&gp=0.jpg");
    }

    public  void saveHttpImg(View v){
        new SaveHttpImg().execute("http://img2.imgtn.bdimg.com/it/u=169341381,1292926655&fm=21&gp=0.jpg");
    }

    public class GetImg extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            HttpURLConnection con = null;
            //拿数据
            InputStream is = null;
            try {
                URL url=new URL(params[0]);
                con= (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5000);
                con.setReadTimeout(5*1000);
                if (con.getResponseCode()==200){
                    is=con.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    return bitmap;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (con!=null){
                    con.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            showImg.setImageBitmap(bitmap);
        }
    }
    
    
    
    //保存网络图片
    public class SaveHttpImg extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection con = null;
            InputStream is = null;
            try {
                URL url = new URL(strings[0]);
                con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5*1000);
                con.setReadTimeout(5*1000);
                File root = Environment.getExternalStorageDirectory();
                FileOutputStream fos = new FileOutputStream(root+"/http.jpg");
                if(con.getResponseCode()==200){
                    is = con.getInputStream();
                    int next=0;
                    byte[] bytes = new byte[1024];
                    while ( (next = is.read(bytes))>0){
                        fos.write(bytes,0,next);
                    }
                    fos.flush();
                    fos.close();
                    return  root+"/http.jpg";
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(con!=null){
                    con.disconnect();
                }
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!s.equals("")){
                Toast.makeText(SaveImageViewActivity.this, "保存路径:" + s, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(SaveImageViewActivity.this,"保存失败:",Toast.LENGTH_SHORT).show();
            }
        }
    }

  ```  
# 四、实验结果

[![lab6-1](https://github.com/2950743175/android-labs-2020/blob/1d3e3915ea68bd29e73e6821e2d2e587eac4993c/students/net1814080903329/lab6.PNG)

[![lab6-2](https://github.com/2950743175/android-labs-2020/blob/1d3e3915ea68bd29e73e6821e2d2e587eac4993c/students/net1814080903329/lab7.PNG)

# 五、实验心得
 本次实验主要是进行Android的网络编程，难度比之前的实验提高，在网上看了一些教程学习，本次实验我做了两个网络测试的功能，一个是可以访问csdn开发者社区，另一个是可以下载网络图片，通过这次实验对于Android编程有了初步的认识。

