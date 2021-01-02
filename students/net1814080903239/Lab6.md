# 一、实验目标
1. 掌握Android网络访问方法
2. 理解XML和JOSN表示数据的方法

# 二、实验内容
1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

# 三、实验步骤
1. 新建FileDownloadActivity和activity_file_download.xml(用于下载图片、文件)、FileDownloader
2. 在FileDownloadActivity与activity_file_download.xml中各控件实现的功能进行对应，主要代码
```java
public void onClick(View view) {
        if (view.getId() == R.id.button_check) {
            checkNetworkState(); // 检查网络
        } else if (view.getId() == R.id.button_download_image) {
            downloadImages(); // 下载图片
        } else if (view.getId() == R.id.button_download_web) {
            downloadWebPage(); // 下载网页
        }
```
```
//下载图片
private void downloadImages() {
        // 创建下载器
        mFileDownloader = new FileDownloader(new FileDownloader.OnImageDownloadListener() {
            @Override
            public void onError(String error) {
                Toast.makeText(FileDownloadActivity.this, error, Toast.LENGTH_LONG).show();
            }
```

```
//下载文件
 for(String imageName : imageNames) {
            String imageUrl = IMAGE_URL_PREFIX + imageName;
            mFileDownloader.download(imageUrl, true);
        }
    }
```

3. 在FileDownload.java中实现对图片文件的下载
``` java
 public void download(@NonNull final String imageUrl, final boolean displayProgress) 
{

        // 启动异步线程下载图片
        new AsyncTask<Void, Integer, Bitmap>() {
            private String error;
}
 // 将下载的文件保存到磁盘中
    public interface OnBitmapSaveListener {
        void onBitmapSaved();
        void onBitmapSaveError(String error);
    }

```
4. 在AndroidManifest添加权限
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.INTERNET" />
```
# 四、实验结果

![实验6截图](https://raw.githubusercontent.com/Joanwjk/android-labs-2020/master/students/net1814080903239/sy6.png)

# 五、实验感想
这次实验内容是从网络上下载图片或网页、文件。因为自己做的项目没有用到这次实验的内容，就练习了课上讲的例子。
首先要在AndroidManifest.xml文件中添加网络权限，在FileDownloadActivity与activity_file_download.xml中各控件实现的功能进行对应，
具体实现在FileDownloader类中，在理解代码上对我来说有点难，通过查找资料后还是有些不太理解的地方。

