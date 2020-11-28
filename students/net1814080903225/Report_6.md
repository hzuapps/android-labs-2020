# 一、实验目标 #

1. 掌握Android网络访问方法；

# 二、实验内容 #

1. 创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

# 三、实验步骤 #

1. 创建HttpClientActivity用于测试网络编程

2. 通过```getGitHubIssues()```方法来获取网络文件URL并建立链接

3. 通过```BufferedReader reader```进行文件读取

   ```java
   private String getGitHubIssues() {
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
               // 断开连接
               connection.disconnect();
           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (ProtocolException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
           return jsonText;
       }
   ```

   完成操作后需要断开连接

4. 将指定URL内容在控制台中打印

   ```java
   public void run() {
                           textView = findViewById(R.id.text1);
                           String jsonText = getGitHubIssues();
                           if (jsonText != null) {
                               try {
                                   JSONArray jsonArr = new JSONArray(jsonText);
                                   JSONObject jsonObj = (JSONObject) jsonArr.get(1);
                                   int number = jsonObj.getInt("number");
                                   final int num = number;
                                   System.out.println("NUMBER = " + number);
                                   textView.post(new Runnable() {
                                       @Override
                                       public void run() {
                                           textView.setText("NUMBER = " + num+"\n"+"详细打印情况请看控制台");
                                       }
                                   });
                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }
                           }
                       }
   ```

   

# 四、实验结果 #

![result1](https://raw.githubusercontent.com/ZYL618/android-labs-2020/master/students/net1814080903225/lab_6/result_1.png)

![result2](https://raw.githubusercontent.com/ZYL618/android-labs-2020/master/students/net1814080903225/lab_6/result_2.png)

![result3](https://raw.githubusercontent.com/ZYL618/android-labs-2020/master/students/net1814080903225/lab_6/result_3.png)

# 五、实验心得 #

本次实验网络编程，即通过相关API获取网络上的数据，此部分不属于我的项目范围之内，因此只是跟着老师给的例子进行了一些练习和理解，若要真正融汇贯通可能课下还需要花些功夫。
