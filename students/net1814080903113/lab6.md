# 实验六 Android网络编程

# 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

# 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

# 三、实验步骤

- 创建按钮交互

```java

((Button) findViewById(R.id.button_get_issues)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String jsonText = getGitHubIssues();
                        if (jsonText != null) {
                            try {
                                JSONArray jsonArr = new JSONArray(jsonText);
                                JSONObject jsonObj = (JSONObject) jsonArr.get(1);
                                String id = jsonObj.getString("id");
                                System.out.println("NUMBER = " + id);
                                ((EditText) thisActivity.findViewById(R.id.first_node_number)) //
                                        .setText(id);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
```


- 从github上面获取文件URL建立连接，通过BufferedReader读取文件信息

```java

private String getGitHubIssues() {
        String gitApi = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
        //gitApi = "https://www.baidu.com";
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

# 四、实验结果

![test6_1](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test6_1.png)
![test6_2](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test6_2.png)


# 五、实验心得

这一次实验内容是关于Android网络编程，难度比以往的实验增加了不小。由于我的APP没有应用到这一块知识点，因此根据老师提供的代码进行了实验。实验创建了网络连接类HttpClientActivity，对数据进行交互等操作。
