# 实验五

## 一、 实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、 实验内容

+ 根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中
2. 使用的文件存储方式：内部存储
3. 将运行结果截图

## 三、 实验步骤

1. 创建一个activity_text.xml文件和TextActivity.java类并将其连接起来

2. 设置点击“+”按钮，跳转到activity_text界面

   ```java
   findViewById(R.id.text_button).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   switch (view.getId()){
                       case R.id.text_button:
                           Intent intent = new Intent(ShareActivity.this,TextActivity.class);
                           startActivity(intent);
                           break;
                   }
               }
           });
   ```

   

3. 在activity_text添加一个EditText控件来输入内容，添加“保存”按钮来实现文件存储，添加“预览”按钮来预览输入的内容，添加TextView控件来显示预览的内容

   ```java
    <EditText
           android:id="@+id/edit"
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:text="点击编辑文字" />
   
       <Button
           android:id="@+id/save"
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:text="保存" />
   
       <Button
           android:id="@+id/preview"
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:text="预览" />
   
       <TextView
           android:id="@+id/tv_content"
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:layout_marginTop="10dp" />
   ```

   

4. 在TextActivity.java类中创建一个save()方法来存储数据

   ```java
   //存储数据
       private void save(String content){
           FileOutputStream fileOutputStream = null;
           try{
               fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
               fileOutputStream.write(content.getBytes());
           }  catch (IOException e) {
               e.printStackTrace();
           } finally{
               if(fileOutputStream != null){
                   try {
                       fileOutputStream.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
   ```

   

5. 在TextActivity.java类中创建一个read()方法来读取数据

```java
//读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");   //实现字符串的拼接
            int len = 0;
            while((len = fileInputStream.read(buff) )> 0){
                sb.append(new String(buff,0,len));//把读取出来的内容变成String类型全部拼接一起
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```



## 四、 实验结果

![文件内存存储](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/storage.png)

## 五、 实验心得体会

​	本次实验实现了内部存储文件的功能。存储数据的时候调用openFileOutput()方法，返回一个FileOutputStream类型的值，然后调用write()方法写入到文件。

​	其中openFileOutput(mFileName,MODE_PRIVATE)有两个参数，mFileName为存储文件的名字，本次实验设置为text.txt；MODE_PRIVATE为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容。该方法还有另一个参数MODE_APPEND，如果想把新写入的内容追加到原文件中，可以使用这个参数。

​	读取数据的时候调用openFileInput(mFileName)方法，mFileName为要读取的文件名称，之后返回一个FileInputStream类型的值，要创建一个byte[]数组来接收数据，使用read()读取文件字节，最后记得调用close()关闭流。

​	在读取数据的时候我使用了StringBuilder sb = new StringBuilder("");   来实现字符串的拼接，调用sb的append(new String(buff,0,len));把读取出来的内容变成String类型全部拼接一起。