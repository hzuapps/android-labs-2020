# 实验五：Android存储编程

## 一、实验目标

- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储

## 二、实验内容

- 使用文件内部存储方式
- 在PersonalDetailsActivity中点击“确定”按钮后，存储EditText框中的值
- 保存完后在布局中读取存储后的数据
- 存储的数据在界面中显示出来

## 三、实验步骤


- 创建点击事件

```java
 btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTest.saveImageToGallery(DownloadTest.this, BitmapFactory.decodeResource(DownloadTest.this.getResources(),R.drawable.aqua1));
                Toast.makeText(DownloadTest.this,"保存成功",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(thisActivity, ShowTest.class);
//                thisActivity.startActivity(intent);
            }
        });
```

- 判断当前系统版本，是否需要申请权限

```java
if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }
```

- 读写权限

```java
private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
```

- 请求状态码和申请权限

```java
private static int REQUEST_PERMISSION_CODE = 1;

@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("Net1814080903113MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }
```

- 保存图片

```java
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
```

- 把文件插入系统图库

```java
try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
```

- 通知图库更新

```java
context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
    }
```

## 四、实验结果

![test5_1](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test5_1.png)
![test5_2](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test5_2.png)

## 五、实验心得

本次实验是本学期移动应用开发的第五次实验课，学会了如何在Android中实现存储数据，了解到有三种方式：一是文件存储，二是轻量存储、三是SQLite数据库存储，三种存储方式各有各的优势。
