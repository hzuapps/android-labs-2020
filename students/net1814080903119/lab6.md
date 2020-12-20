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
1. 写一个类让它继承ImageView，并增加一个setImageURL(path)方法，方法里开启线程用于联网。
```
//把传过来的路径转成URL
        URL url = new URL(path);
//获取连接
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//使用GET方法访问网络
        connection.setRequestMethod("GET");
//超时时间为10秒
        connection.setConnectTimeout(10000);
//获取返回码
        int code = connection.getResponseCode();
```
2. 使用工厂把网络的输入流生成Bitmap，通过Handler设置图片，利用Message把图片发给Handler。
```
 Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        Message msg = Message.obtain();
        msg.obj = bitmap;
        msg.what = GET_DATA_SUCCESS;
        handler.sendMessage(msg);
```
```
//Handler设置图片
 Bitmap bitmap = (Bitmap) msg.obj;
                    setImageBitmap(bitmap);
```

3. 添加访问网络的权限。
```
 <uses-permission android:name="android.permission.INTERNET"/>
```

4. 调用setImageURL()，把网络的图片路径写上就可以显示网络的图片，这里是将路径存到一个数组里面。

  核心代码：

  ```
 imageView.setImageURL(ImageUrlCol[position]);
  ```

# 四、实验结果

![实验截图](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/master/students/net1814080903119/lab6.jpg)

# 五、实验心得
网络编程，因为自己做壁纸功能，所以通过线程联网实现显示网络图片，再在设为壁纸方法里对url转成Bitmap的实现。难度挺大，一开始总是显示不出来，也会卡顿，后面发现是子类和父类在一些方法上定义上的错误。
