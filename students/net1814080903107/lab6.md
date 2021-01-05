# 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

# 二、实验内容

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

# 三、实验步骤

1. 在AndroidManifest.xml里添加网络权限

2. 使用HttpURLConnection链接到需要网络资源

3. 从HttpURLConnection的输入流里下载图片

   ```java
   HttpURLConnection conn = null;
   URL url = new URL(imageFrom+imageName);
   System.out.println(url.toString());
   conn = (HttpURLConnection) url.openConnection();
   conn.setRequestMethod("GET");
   if (conn.getResponseCode() == 200) {
       bitmap = BitmapFactory.decodeStream(conn.getInputStream());
   }
   ```

# 四、实验结果

![lab6_1](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab6_1.PNG)

# 五、实验心得

​	本次实验使用网络获取信息，更加动态的更新数据，并且配合数据库的使用，将需要的信息批量加载到App，有更好的视觉效果和体验。