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
1. 模拟账号登陆后向后端申请账户信息

2. 首先利用了AsycnhttpClient向本地运行得Tomcat发送了请求，获取user.json中的数据

   ```java
   // 创建请求实例
           AsyncHttpClient client = new AsyncHttpClient();
           System.out.println("=============");
           client.get(path, new AsyncHttpResponseHandler() {
               // 请求成功
               @Override
               public void onSuccess(int statusCode, Header[] headers, byte[] bytes) {
                   System.out.println("-----------------------------");
                   // 调用JsonParase工具解析JSON文件
                   try {
                       String json = new String(bytes,"utf-8");
                       user = JsonParse.getUser(json);
                       if(user == null){
                           Toast.makeText(AccountActivity.this,"解析失败",Toast.LENGTH_SHORT).show();
                       } else {
                           Toast.makeText(AccountActivity.this,"解析成功",Toast.LENGTH_SHORT).show();
                           // 显示图像
                           new Thread() {
                               @Override
                               public void run() {
                                   super.run();
                                   try {
                                       Thread.sleep(10);
                                       getUrlimg(user.getAvator());
                                   } catch (InterruptedException e) {
                                       e.printStackTrace();
                                   }
                               }
                           }.start();
   
                           // 显示数据
                           textView_name.setText(user.getName());
                           textView_sex.setText(user.getSex());
                           textView_age.setText(user.getAge());
                           textView_occupation.setText(user.getOccupation());
                       }
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
   
               // 勤请求失败
               @Override
               public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                   Toast.makeText(AccountActivity.this,"请求失败",Toast.LENGTH_SHORT).show();
               }
           });
   ```

3. 利用Gson库对json数据进行解析，然后又将获取到的数据进行展示

   ````java
   public static User getUser(String json){
           // 使用Gson解析JSON数据
           Gson gson = new Gson();
           Type listType = new TypeToken<User>(){}.getType();
           // 把获取的信息存到User中
           User user = gson.fromJson(json, listType);
           return user;
       }
   ````

4. 根据获取到的图像url，用HttpURLConnection向url发送请求

   ```java
   URL url = new URL(path);
               //获取连接
               HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               //使用GET方法访问网络
               connection.setRequestMethod("GET");
               //超时时间为10秒
               connection.setConnectTimeout(10000);
               //获取返回码
               int code = connection.getResponseCode();
               if (code == 200) {
                   InputStream inputStream = connection.getInputStream();
                   //使用工厂把网络的输入流生产Bitmap
                   Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                   //利用Message把图片发给Handler
                   Message msg = Message.obtain();
                   msg.obj = bitmap;
                   msg.what = CODE;
                   myHandler.sendMessage(msg);
                   inputStream.close();
               } else {
                   //服务启发生错误
                   myHandler.sendEmptyMessage(SERVER_ERROR);
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
   ```

5. 利用Message把图片发给Handler，再显示出来

# 四、实验结果

![image-20201215133446927](E:\2021大三第一学期\移动开发\实验\lab06_01.png)

![image-20201215133419119](E:\2021大三第一学期\移动开发\实验\lab06_02.png)

# 五、实验心得

通过网络编程，学习到了Android请求后端的基本步骤，认识到了AsyncHttpClient开源库的强大，每次与服务器进行数据交互不再需要开启一个子线程，简化了Android开发中，发送、处理Http的步骤。
