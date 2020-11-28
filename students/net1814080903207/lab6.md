# 一、实验目标 #

1. 掌握Android网络访问方法
2. 理解XML和JSON表示数据的方法

# 二、实验内容 #

1. 在Github的个人目录中创建JSON或XML数据文件
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 通过Android网络编程读取该JSON或XML文件
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

# 三、实验步骤 #

1. 创建HttpClientActivity用于测试网络编程

2. 通过```getGitHubIssues()```方法来获取网络文件URL并建立链接

3. 通过```BufferedReader reader```进行文件读取

   ```java
   private String getGitHubIssues() {
           String gitApi = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
           //gitApi = "https://www.baidu.com";
           URL url = null;
           String jsonText = null;
           try {
               url = new URL(gitApi);
               HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               // HttpClient
               // OKHttp
               //connection.setDoOutput(true);
               //connection.setDoInput(true);
               //connection.setRequestMethod("POST");
               //connection.setUseCaches(false);
               //connection.setInstanceFollowRedirects(true);
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

   


# 四、实验结果 #

![result1]()





# 五、实验心得 #

本次实验为网络编程，就是相关API获取网络上的数据，在自己的项目中没有用上，我认为这个还是比较困难的，想要融会贯通需要非常多的实例训练。