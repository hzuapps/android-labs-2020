# 一、实验目标 #

1. 掌握Android网络访问方法
2. 理解XML和JSON表示数据的方法

# 二、实验内容 #

1. 在个人目录中创建JSON或XML数据文件
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 通过Android网络编程读取该JSON或XML文件
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

# 三、实验步骤 #

1. 准备好两个json文件，放在服务器上，跟第四次实验中的两个java类(Course.java、PhysicalScore.java)对应  
    [Course.json](http://49.234.91.116:80/examples/course.json)  
    [PhysicalScore.json](http://49.234.91.116:80/examples/physicalScore.json)  
2. 通过```getGitHubIssues()```方法来获取网络文件URL并建立链接  
    ```java
    private String getGitHubIssues() {
        String gitApi = "http://49.234.91.116:80/examples/physicalScore.json";
        URL url = null;
        String jsonText = null;
        try {
            url = new URL(gitApi);
            // 创建网络连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // 以流的方式去读取网络数据：字符流 / 字节流
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
            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText;
    }
    ```

3. AndroidManifest.xml中添加

   ```java
   <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />  
   <uses-permission android:name="android.permission.INTERNET" />  
   ```
4. 在onCreate()方法中让UiThread线程去获取json中的内容，并利用Gson将其转化为实体类

   ```java
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        //在Android4.0以后，会发现，只要是写在主线程（就是Activity）中的HTTP请求，运行时都会报错。可以再Activity的onCreate()方法中加入这样一段代码，适用于网络请求数据量很小的话
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        builder=new GsonBuilder();
        gson=builder.create();

        runOnUiThread(new Runnable() {

            @Override
            public void run() {
            //1. 从网络获取 JSON 内容
                String jsonText = getGitHubIssues();
                if (jsonText != null) {
                    try { 
                        // 2. 解析JSON
                        JSONArray jsonArr = new JSONArray(jsonText);
                        for(int i = 0; i < jsonArr.length(); i++){
                            Object obj = jsonArr.get(i);
                            String str = obj.toString();
                            //3.利用Gson将其转化为实体类(Course类)
                            Course c = gson.fromJson(str, Course.class);
                            courses.add(c);
                            System.out.println(courses);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });  
   ```
5. 由于需要用到gson包，需要在build.gradle中加入gson依赖

   ```gradle
   dependencies {
    implementation 'com.google.code.gson:gson:2.8.2'
   }
   ```
6. 从网络中获取PhysicalScore.json的过程跟上面类似
# 四、实验结果 #  
json文件截图  
  
![lab6_result1](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab6_result1.png)  
Debug截图  
  
![lab6_result2](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab6_result2.png)   
界面截图  
  
![lab6_result3](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab6_result3.png)  
# 五、实验心得 #

本次实验是网络编程，没有使用网络编程获取数据之前， 我是在java类中创造测试数据。本次实验修改变成从网络json文件获取学生的各科成绩，需要在服务器上准备好json，利用相关的API获取数据，然后利用gson将其转化为java实体类，方便使用。
有了json文件后，要想修改学生的成绩，无需修改Java代码再编译运行，只需要修改json文件即可达到效果。
