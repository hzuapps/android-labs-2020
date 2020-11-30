# 实验六：Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

```
注意：选择实现的功能，一定要跟你的选题相关！
```

## 二、实验内容

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

## 三、实验步骤

1. 在 build.gradle 上导入依赖
2. 在 AndroidManifest.xml 上添加网络权限

```xml
    <uses-permission android:name="android.permission.INTERNET"/>
```

3. 对上一次实验五的 UploadActivity.java 中的`uploadFile`方法进行修改

```java
 public boolean uploadFile(String path,String filename){
        final OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File(path);
        if(path.isEmpty()||!file.exists())
            return false;
        final RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file",filename,RequestBody.create(new File(path), MediaType.parse("multipart/form-data")))
                .addFormDataPart("filename",filename)
                .build();
        FutureTask<Boolean> task = new FutureTask<>(()->{
            try {
                ResponseBody responseBody = okHttpClient.newCall(
                        new Request.Builder().post(body).url("http://10.0.2.2:8080/upload").build()
                ).execute().body();

                if(responseBody!=null){
                    return Boolean.parseBoolean(responseBody.string());
                }
                return false;
            }catch (IOException e){
                e.printStackTrace();
                return false;
            }
        });
        try {
            new Thread(task).start();
            return task.get();
        }catch (Exception e) {
            return false;
        }
    }
```

4. 在 DownloadActivity.java 上添加一个 EditText 用于在点击时发送网络请求，请求服务器中可下载文件名展示在EditText

getFilesName : 用于发送请求获取文件列表

```java
    public void getFilesName(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://10.0.2.2:8080/getFilesName").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String str = response.body().string();
                    List<String> list = JSONObject.parseArray(str,String.class);
                    Message msg = new Message();
                    msg.obj = list;
                    handler.sendMessage(msg);
                }
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                filenameList = (List<String>) msg.obj;
                showListPopulWindow();

            }
        };

    }
```

showListPopulWindow : 用于将文件列表通过下拉框形式展示在EidtText

```java
    private void showListPopulWindow() {
        String[] list = filenameList.toArray(new String[filenameList.size()]);
        final ListPopupWindow listPopupWindow;
        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list));//用android内置布局，或设计自己的样式
        listPopupWindow.setAnchorView(downText);//以哪个控件为基准，在该处以mEditText为基准
        listPopupWindow.setModal(true);

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {//设置项点击监听
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                downText.setText(list[i]);//把选择的选项内容展示在EditText上
                listPopupWindow.dismiss();//如果已经选择了，隐藏起来
            }
        });
        listPopupWindow.show();//把ListPopWindow展示出来
    }
```

5. `downloadFile` 用于通过EidtText 获取的文件名发送请求从服务器获取文件进行下载

```java
 public File downloadFile(String filename){

        OkHttpClient okHttpClient = new OkHttpClient();

        if(filename==null||filename.isEmpty()){
            return null;
        }

        RequestBody body = new MultipartBody.Builder().addFormDataPart("filename",filename).build();

        FutureTask<File> task = new FutureTask<File>(()->{
            ResponseBody responseBody = okHttpClient.newCall(
                    new Request.Builder().post(body).url("http://10.0.2.2:8080/download").build()).execute().body();
            if(responseBody != null){
                if(getExternalFilesDir(null)!=null){
                    String filePath = getExternalFilesDir(null).toString();
                    File file = new File(getExternalFilesDir(null).toString()+"/"+filename);
                    try (
                            InputStream inputStream = responseBody.byteStream();
                            FileOutputStream outputStream = new FileOutputStream(file)
                    ){
                        byte[] b = new byte[1024];
                        int length;
                        if((length = inputStream.read(b))!=-1){
                            outputStream.write(b,0,length);
                            while( (length=inputStream.read(b)) != -1 ){
                                outputStream.write(b,0,length);
                            }
                            return file;
                        }else{
                            file.delete();
                            return null;
                        }
                    }
                }

            }
            return null;
        });
        try {
            new Thread(task).start();
            return task.get();
        }catch (Exception e) {
            return null;
        }
    }
```

## 四、实验结果及截图

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(1).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(2).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(3).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(4).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(5).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(6).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(7).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(8).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(9).png)

![实验6图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab6(10).png)

## 五、实验心得

通过本次实验学习了如何在安卓发送网络请求，比较要注意的点是需要先在配置文件中启动网络权限，否则发送不了请求，然后就是可以通过使用第三方插件okhttp这个插件进行发送，它对原生的网络请求进行了封装，使用起来比较方便，最后就是如果使用的是安卓模拟器模拟发送给本地电脑请求，应该使用地址10.0.2.2这个ip才能够请求到。