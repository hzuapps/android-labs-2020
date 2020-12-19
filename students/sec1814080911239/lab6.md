# 实验六
## 一、 实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。
## 二、 实验内容
1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。
## 三、 实验步骤
1. 在activity_share.xml创建一个下载图片的按钮，并添加onClick属性

   ```java
   <Button
               android:id="@+id/download"
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:onClick="click"
               android:text="下载图片" />
   ```

   

2. 在activity_share.xml创建一个TexiView来存放文字

3. 在activity_share.xml创建一个ImageView来显示下载的图片

4. 将要下载的图片git到gitee上，生成链接https://gitee.com/linzisong/wx-jf/raw/master/assets/image.jpg

5. 在ShareActivity.java实现按钮点击事件

   ```java
   /**
        * 实现下载图片
        * @param v
        */
       // 点击按钮查看指定路径的源码
       public void click(View v) {
           new Thread(){public void run() {
               try {
                   //获取访问图片的路径
                   String path = "https://gitee.com/linzisong/wx-jf/raw/master/assets/image.jpg";
                   File  file = new File(getCacheDir(),Base64.encodeToString(path.getBytes(), Base64.DEFAULT));
                   if (file.exists()&& file.length()>0) {
                       //使用缓存图片
                       System.out.println("使用缓存图片 ");
                       final Bitmap cacheBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                       runOnUiThread(new Runnable() {
                           public void run() {
                               iv.setImageBitmap(cacheBitmap);
                           }
                       });
                   }else{
                       //第一次访问联网获取数据
                       System.out.println("第一次访问连接网络");
                       URL url = new URL(path);
                       HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
                       //设置请求的方式
                       conn.setRequestMethod("GET");
                       //设置超时时间
                       conn.setConnectTimeout(5000);
                       //获取服务器返回的状态码
                       int code = conn.getResponseCode();
                       if (code == 200) {
                           //获取图片的数据，以流的形式返回
                           InputStream in = conn.getInputStream();
                           //缓存图片
                           FileOutputStream fos = new FileOutputStream(file);
                           int  len = -1;
                           byte[] buffer = new byte[1024];
                           while((len=in.read(buffer))!=-1){
                               fos.write(buffer, 0, len);
                           }
                           fos.close();
                           in.close();
                           //获取bitmap
                           final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                           runOnUiThread(new Runnable() {
                               public void run() {
                                   //把bitmap显示到iv上
                                   iv.setImageBitmap(bitmap);
                               }
                           });
   
                       }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           };}.start();
   
       }
   ```

   
## 四、 实验结果
![图片下载](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/download.png)

## 五、 实验心得体会

​	本次实验我实现的功能是从网络上下载图片，我刚开始写完代码之后运行发现图片下载不下来，后来检查是因为没有监听到下载图片的按钮，于是我为下载图片的按钮添加了onClick属性。刚开始我将图片git到github上，然后生成一个网址，运行代码的时候发现下载不下来，经过了解，发现是因为github是外网，被拦截了，然后就把图片git到gitee上，gitee网站类似于github，不过是国内的，因此下载速度很快。