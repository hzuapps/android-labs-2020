# 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。
# 二、实验内容
1. 在个人服务器中创建一个表示数据的JSON文件；
2. 从服务器获取文件URL；
3. 在应用中通过网络编程访问服务器的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。
# 三、实验步骤
1. 创建json文件[Moment.json](http://49.234.91.116:80/android/Moment.json)
2. Gradle引入gson和glide
```
  //gson
  implementation 'com.google.code.gson:gson:2.8.6'
```
```
  //glide
  implementation 'com.github.bumptech.glide:glide:4.11.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
```
3. AndroidMainfest.xml加入网络权限，Moment1814080903202Activity配置安全设置
```
  <uses-permission android:name="android.permission.INTERNET"/>
```
```
  //高版本Android需要配置才可联网
  StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
  StrictMode.setThreadPolicy(policy);
```
4. 修改类Moment1814080903202Activity.java。通过getJson()方法获取网络Json文件并转换成json字符串。
5. 在线程方法runOnUiThread里，获取json字符串，再通过gson，利用匿名内部类TypeToken将json字符串转换成APP所需的resultlist。
```
  String jsonText = getJson();
  resultlist = gson.fromJson(jsonText,new TypeToken<List<Map<String,Object>>>(){}.getType());
```
6. 由于json里的图片数据为url，故使用glide加载网络图片。适配器使用SimpleAdapter，重写setViewBinder方法实现加载网络图片到布局中，增加RoundTransform.java实现头像圆角。
```
  //使用Glide加载网络图片到SimpleAdapter中的ImageView
  simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
      @Override
      public boolean setViewValue(View view, Object data, String textRepresentation) {
          if (view instanceof ImageView) {
              ImageView iv = (ImageView) view;
              if(iv.getId() == R.id.head){
              //头像使用圆角
                  RequestOptions options = new RequestOptions().centerCrop() .transform(new RoundTransform(iv.getContext(),30));
                  Glide.with(iv.getContext()).load((String) data).apply(options).into(iv);
              }else{
                  Glide.with(iv.getContext()).load((String) data).into(iv);
              }
              return true;
          }
          return false;
      }
  });
```
# 四、实验结果
![lab6_1](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab6_1.png)
![lab6_2](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab6_2.png)
# 五、实验心得
这次实验我选择的方向是获取网络上的json文件显示到APP上，同时结合Glide也显示了网络上的图片。这次实验也遇到了一些问题，在获取json文件时，高版本的安卓要配置一些安全设置才可以访问到网络。在结合自己的实验APP时，难点在于json无法存储drawable下的图片的id值来匹配图片，所以我选用了Glide匹配网络图片，但是又要加载到SimpleAdapter中，查了一些资料和自己研究了才找到方法实现功能。我之前的头像圆角写法是将图片显示到background，圆角xml显示到src，但是Glide是将图片显示到src，所以我又加入了一个圆角实现类。总的来说，这次实验主要难在构思如何结合自己的APP实现功能，在实现功能过程中不断发现问题，解决问题。
