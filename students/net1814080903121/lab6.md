# 实验六 Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 三、实验步骤

1. 在AndroidManifest.xml中添加网络权限
  xml
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET"/>
    
2. 创建HttpClientUIActivity和activity_http_client.xml

3. 通过HttpClientUIActivity中getGitHubIssues()方法来获取数值。
  java
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
    
4. 访问网络要放在独立的线程中
  java
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
                
## 四、实验结果
![lab6](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab6.png)

## 五、实验心得
  本次实验学习网络编程，学习了比较简单的通过getGitHubIssues()方法获取数值的知识，比较需要注意的是AndroidManifest.xml文件中需要添加相应的权限。
