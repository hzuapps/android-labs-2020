# 实验六
## 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容
1. 从GitHub获取文件URL；
2. 在应用中通过网络编程访问GitHub的数据文件；
3. 在应用中解析并显示文件所包含的数据；
4. 将应用运行结果截图。

## 三、实验步骤
代码如下：
```java
     String gitApi = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
        URL url = null;
        String jsonText = null;
        try {
            url = new URL(gitApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = URLDecoder.decode(lines, "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            jsonText = sb.toString();
            reader.close();
```
## 四、实验结果
![lab6](https://github.com/clinying/android-labs-2020/blob/master/students/net1814080903135/lab6.JPG)
## 五、实验心得
  本来是打算在项目中使用网络访问的，但有个地方有问题没能实现，所以这次实验做了一下老师给的例子，通过本次实验掌握了Android网络访问的方法,理解了XML和JSON表示数据的方法。
