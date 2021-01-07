# 实验六
## 一.实验目标
1.掌握Android网络访问方法；  
2.理解XML和JSON表示数据的方法。 
  
## 二.实验内容
1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图
## 三.实验步骤
### 1.创建工具类 fileUtils
```
public class FileUtils {
    private String SDCardRoot;
    public FileUtils(){
        //得到当前外部存储设备的目录
        SDCardRoot= Environment.getExternalStorageDirectory()+File.separator;
        //File.separator为文件分隔符”/“,方便之后在目录下创建文件
    }
    //在SD卡上创建文件
    public File createFileInSDCard(String fileName,String dir) throws IOException {
        File file=new File(SDCardRoot+dir+File.separator+fileName);
        file.createNewFile();
        return file;
    }
    //在SD卡上创建目录
    public File createSDDir(String dir)throws IOException{
        File dirFile=new File(SDCardRoot+dir);
        dirFile.mkdir();//mkdir()只能创建一层文件目录，mkdirs()可以创建多层文件目录
        return dirFile;
    }

    //判断文件是否存在
    public boolean isFileExist(String fileName,String dir){
        File file=new File(SDCardRoot+dir+File.separator+fileName);
        return file.exists();
    }

    //将一个InoutStream里面的数据写入到SD卡中
    public File write2SDFromInput(String fileName,String dir,InputStream input){
        File file=null;
        OutputStream output=null;
        try {
            //创建目录
            createSDDir(dir);
            //创建文件
            file=createFileInSDCard(fileName,dir);
            //写数据流
            output=new FileOutputStream(file);
            byte buffer[]=new byte[4*1024];//每次存4K
            int temp;
            //写入数据
            while((temp=input.read(buffer))!=-1){
                output.write(buffer,0,temp);
            }
            output.flush();
        } catch (Exception e) {
            System.out.println("写数据异常："+e);
        }
        finally{
            try {
                output.close();
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
        return file;
    }

}
```
### 2.创建工具类 HttpDownloader
```
public class FileUtils {

    private String SDCardRoot;

    public FileUtils(){
        //得到当前外部存储设备的目录
        SDCardRoot= Environment.getExternalStorageDirectory()+File.separator;
        //File.separator为文件分隔符”/“,方便之后在目录下创建文件
    }

    //在SD卡上创建文件
    public File createFileInSDCard(String fileName,String dir) throws IOException {
        File file=new File(SDCardRoot+dir+File.separator+fileName);
        file.createNewFile();
        return file;
    }

    //在SD卡上创建目录
    public File createSDDir(String dir)throws IOException{
        File dirFile=new File(SDCardRoot+dir);
        dirFile.mkdir();//mkdir()只能创建一层文件目录，mkdirs()可以创建多层文件目录
        return dirFile;
    }

    //判断文件是否存在
    public boolean isFileExist(String fileName,String dir){
        File file=new File(SDCardRoot+dir+File.separator+fileName);
        return file.exists();
    }

    //将一个InoutStream里面的数据写入到SD卡中
    public File write2SDFromInput(String fileName,String dir,InputStream input){
        File file=null;
        OutputStream output=null;
        try {
            //创建目录
            createSDDir(dir);
            //创建文件
            file=createFileInSDCard(fileName,dir);
            //写数据流
            output=new FileOutputStream(file);
            byte buffer[]=new byte[4*1024];//每次存4K
            int temp;
            //写入数据
            while((temp=input.read(buffer))!=-1){
                output.write(buffer,0,temp);
            }
            output.flush();
        } catch (Exception e) {
            System.out.println("写数据异常："+e);
        }
        finally{
            try {
                output.close();
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
        return file;
    }

}
```

### 3.MianActivty
```
package edu.hzuapp.androidlabs.fileutils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//1,在Manifest文件中注册Internet和读写SDCard的权限
//2,下载不能在主线程中进行，要开分线程
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button but1,but2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1=(Button)findViewById(R.id.but1);
        but1.setOnClickListener(this);
        but2=(Button)findViewById(R.id.but2);
        but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==but1){
            new downloadFileThread().start();
        }else if(v==but2){
            new downloadMP3Thread().start();
        }
    }

    class downloadFileThread extends Thread{
        public void run(){
            HttpDownloader httpDownloader=new HttpDownloader();
            String fileData=httpDownloader.downloadFiles("http://mystudy.bj.bcebos.com/AndroidDemo_009.xml");
            System.out.println(fileData);
        }
    }

    class downloadMP3Thread extends Thread{
        public void run(){
            HttpDownloader httpDownloader=new HttpDownloader();
            int downloadResult=httpDownloader.downloadFiles(
                    "http://fengkui.bj.bcebos.com/%E8%B6%B3%E9%9F%B3.mp3","BoBoMusic","足音.mp3");
            System.out.println("下载结果："+downloadResult);
        }
    }
}
```
### 4.activity_main.xml xml文件
```
<Button
        android:id="@+id/but1"
        android:layout_width="305dp"
        android:layout_height="77dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        android:text="下载XML文件"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.043" />

    <Button
        android:id="@+id/but2"
        android:layout_width="306dp"
        android:layout_height="73dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        android:text="下载MP3文件"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.494"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.193" />
   ```
## 四.实验结果    
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab6_2.png">  
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab6_1.png">
  
## 四.实验结果   
这次实验是做网络编程，实现在网络上下载文件的功能，主要难点，如何查看到自己下载的文件，还是通过powershell 在ADK中  
/storage/emulated/BoboMusic目录下看到了自己下载的足音.mp3文件
