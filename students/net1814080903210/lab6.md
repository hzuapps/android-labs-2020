
# 一、实验目标

1. 掌握Android网络访问方法
2. 理解XML和JSON表示数据的方法
# 二、实验内容

1. 在Github的个人目录中创建JSON或XML数据文件
2. 获取JSON或XML文件的URL
3. 通过Android网络编程读取该JSON或XML文件
4. 将该JSON或XML文件的内容显示出来

# 三、实验步骤

1. 在net1814080903210文件夹下创建名为titles的JSON文件
```txt
[
 {"title":"5G流量和WiFi6的最全科普,以后你都离不开"},
 {"title":"市值2.13万亿,韩国最大集团三星,放在我国是什么水平"},
 {"title":"苹果又要出新品，这次的主角是?"},
 {"title":"JDG曝出LPL冬季转会第一天消息,没想到最先离开的是他"},
 {"title":"千金难买食谱大全!收藏好,别丢了!"},
 {"title":"DNF盘点游戏中一些特别搞笑的装备,你还记得吗?"}
]
```
2. 通过raw按钮获取titles文件的URL
```java
String gitApi = "https://raw.githubusercontent.com/Playerlhh/android-labs-2020/master/students/net1814080903210/titles";
```
3. 通过HttpURLConnection获取网络连接
4. 使用字符流读取titles文件
```java
BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = URLDecoder.decode(lines, "utf-8");
                sb.append(lines);
            }
            jsonText = sb.toString();
```
5. 将titles文件中所有对象的name属性取出来并存到数据库中
```java
 String title = jsonObj.getString("title");
```
7. 查询数据库中的数据并显示结果

# 四、实验结果

![result](https://raw.githubusercontent.com/Playerlhh/android-labs-2020/master/students/net1814080903210/lab6_res.png)

# 五、实验心得

&#160; &#160; &#160; &#160;通过这次实验，我成功的使用Android网络编程将JSON数据从Github上读取并显示到界面上，创建JSON文件时需要注意JSON文件的语法格式，不确定时可以通过JSON格式验证网站验证。
