# 实验五

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

## 三、实验步骤

1. 创建类DonwloadSaveImg用于实现存储图片功能
2. 在DonwloadSaveImg类中定义saveFile方法来将图片保存到SD卡中（外部存储,核心代码如下：
```java
String fileName = System.currentTimeMillis() + ".jpg";
        File myCaptureFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+""+ fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
```
3. 在需要用到保存图片功能的Activity中定义requestPermission方法来检查存储权限及询问是否可赋予存储权限，核心代码如下：
```java
 if (Build.VERSION.SDK_INT >= 23) {
            //读取sd卡的权限
            String[] mPermissionList = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (EasyPermissions.hasPermissions(mContext, mPermissionList)) {
                //已经同意过
                saveImage();
            } else {
                //未同意过,或者说是拒绝了，再次申请权限
                EasyPermissions.requestPermissions(
                        this, 
                        "保存图片需要读取sd卡的权限", //提示
                        REQUEST_CODE_SAVE_IMG, //请求码
                        mPermissionList //权限列表
                );}}
```

## 四、实验结果

![运行截图](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab5_1.PNG)
![运行截图](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab5_2.PNG)

## 五、实验心得

　　由于我的项目需要用到图片保存功能，所以我在本次实验中选做了文件存储且选择了外部存储的方式，在类DonwloadSaveImg中定义saveFile方法，
    实现了图片的保存功能，在第一次运行此项目的设备中，会询问是否可以赋予存储权限，在存储完毕后还会通知系统图库更新，方便在系统相册中查看。
