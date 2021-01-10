# 实验五：Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 定义一个文件保存的方法，写入到文件中
2. 定义文件读取的方法
3. 在Sec1814080911111Activity中调用

## 三、实验步骤

1. 这里定义的是一个文件保存的方法，写入到文件中
```java
public void save(String filename, String filecontent) throws Exception {
    FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
    output.write(filecontent.getBytes()); 
    output.close();         
}
```  
2. 这里定义的是文件读取的方法
```java
public String read(String filename) throws IOException {
        //打开文件输入流
        FileInputStream input = mContext.openFileInput(filename);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;
        //读取文件内容:
        while ((len = input.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }
        //关闭输入流
        input.close();
        return sb.toString();
    }
```  
3. 在Sec1814080911111Activity中调用
```java
  try {
            fHelper.save(fileName, fileContent);
            Toast.makeText(getApplicationContext(), "欢迎使用", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "欢迎使用", Toast.LENGTH_SHORT).show();
        }
```  
## 四、实验结果

```  
![result](https://github.com/holenchan/android-labs-2020/blob/master/students/sec1814080911111/lab5.png)
```  

## 五、实验心得体会
这次实验我使用私有模式,创建出来的文件只能被本应用访问,还会覆盖原文件，将String字符串以字节流的形式写入到输出流中，本地存储较容易实现。
