
# 一、实验目标

1. 掌握Android网络访问方法
2. 理解XML和JSON表示数据的方法
# 二、实验内容

1. 在Github的个人目录中创建JSON或XML数据文件
2. 获取JSON或XML文件的URL
3. 通过Android网络编程读取该JSON或XML文件
4. 将该JSON或XML文件的内容显示出来

# 三、实验步骤

1.通过HttpURLConnection获取网络连接
2. 使用字符流读取titles文件
```java
BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = URLDecoder.decode(lines, "utf-8");
                mm.append(lines);
            }
            jsonText = mm.toString();
```
3. 将网址中的title读取出来并显示在textview中
```java
           textView3.setText("TITLE = " + jsonObj.getString("title"));
```

# 四、实验结果

![result](https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab6.png)

# 五、实验心得

通过这次实验，我学习到了Android网络编程将JSON数据从Github上读取并显示到界面上，创建JSON文件时需要注意JSON文件的语法格式，不确定时可以去通过JSON格式验证网站验证。