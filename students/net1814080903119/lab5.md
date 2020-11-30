# 一、实验目标

1. 了解Android的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

# 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 使用内部存储将产生的数据保存到文件存储中；
3. 将运行结果截图。

# 三、实验步骤

1. 读与写的权限定义到静态字符数组中；
``` java
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
```
2. 判断android studio的系统版本，根据系统版本判断是否动态申请权限；
``` java
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;
 if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
              //ActivityCompat.requestPermission方法:参数1是目标Activity,填写this即可，参数2权限集，参数3为请求码
            }
        }
```
3. 申请权限后调用onRequestPermissionResult函数，参数1请求码，参数2权限集，参数3请求结果：0表示授权成功，-1授权失败；
``` java
 @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("StaticPageActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }
```
4. 写方法保存图片并通知系统图库更新；
``` java
 public static void saveImageToGallery(Context context, Bitmap bmp) {
       // 首先保存图片
       File appDir = new File(Environment.getExternalStorageDirectory(), "");
       if (!appDir.exists()) {
           appDir.mkdir();
       }
       String fileName = System.currentTimeMillis() + ".jpg";
       File file = new File(appDir, fileName);
       try {
           FileOutputStream fos = new FileOutputStream(file);
           bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
           fos.flush();
           fos.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

       // 其次把文件插入到系统图库
       try {
           MediaStore.Images.Media.insertImage(context.getContentResolver(),
                   file.getAbsolutePath(), fileName, null);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       // 最后通知图库更新
       context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
   }
```
5.对应的下载按钮加上保存图片的方法（saveImageToGallery）；
![对应按钮](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/58dab4c5b81ee4fe2411ecff2afc2d7506164e09/students/net1814080903119/lab5.1.jpg)

# 四、实验结果

![下载结果](https://raw.githubusercontent.com/Lj-xinfei/android-labs-2020/58dab4c5b81ee4fe2411ecff2afc2d7506164e09/students/net1814080903119/lab5.2.jpg)

# 五、实验心得体会
做存储的过程中先是解决下载图片的方法，但是代码本身没错，在run的界面出现（permission denied，拒接访问），又去网上搜，查到在AndroidMainfest.xml可以直接加申请权限代码，还是有permission denied。
发现是版本问题，Android 6.0开始，有些权限必须用户同意才能调用相应功能，最后加了动态申请写和读的权限的方式代码，自己也尝试做下载视频的方法，未成功。
   
