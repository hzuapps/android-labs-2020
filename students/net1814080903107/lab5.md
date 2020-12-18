# 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容

- 根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

# 三、实验步骤

1. 在AndroidManifest.xml里添加存储权限

2. 将下载的图片保存到手机里，将图片转化为字节数组，输出到文件中

   ```java
   File PHOTO_DIR = new File("data/data/com.example.thefirst");//设置保存路径
   File avaterFile = new File(PHOTO_DIR, bitmapName);//设置文件名称
   if(avaterFile.exists()){
       avaterFile.delete();
   }
       avaterFile.createNewFile();
       FileOutputStream fos = new FileOutputStream(avaterFile);
       bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, fos);
       fos.flush();
       fos.close();
   ```

   

3. 需要用时再从图片读取字节转化为Bitmap使用

   ```java
   File PHOTO_DIR = new File("data/data/com.example.thefirst");//设置保存路径
   File avaterFile = new File(PHOTO_DIR, bitmapName);
   if(avaterFile.exists()) {
       bitmap = BitmapFactory.decodeFile(PHOTO_DIR+"/"+bitmapName);
   }
   ```

   



# 四、实验结果

![lab5_1](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab5_1.PNG)

# 五、实验心得

​	利用文件存储不仅可以保存图片还可以保存文字信息，将常用的信息保存起来，留着下次使用，这不仅会提高效率，还是所有人需要的功能之一。