# 实验五：Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 使用文件外部存储方式
3. 运行结果截图。

## 三、实验步骤

1. 为activity_upload.xml添加一个TextView：

```xml
    <TextView
        android:layout_marginLeft="100dp"
        android:layout_width="200dp"
        android:layout_height="40dp"
        android:id="@+id/uploadText"
        android:lines="1"
        android:ellipsize="end"
        android:hint="选择你要上传的文件"
        />
```

2. 在AndroidManifest.xml上添加外部存储读写权限：

```xml
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

3. 在java代码上申请权限：

```java
    //申请权限
    private void permissionFile(){
        String[] permission = new String[]{
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        }; //申请所需要的权限

        if(ActivityCompat.checkSelfPermission(this,permission[0])!= PackageManager.PERMISSION_GRANTED
                ||
                ActivityCompat.checkSelfPermission(this,permission[1])!=PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this,permission,1);   //申请权限
        }
    }
```

* 在UploadActivity.java的onCreate()上调用 permissionFile();

4.通过点击TextView控件，弹出文件管理器，从本地选择文件进行上传到本地的外部存储文件夹中。

```java
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.main_btn:
                    intent = new Intent(UploadActivity.this, Net1814080903117Activity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.up_btn:
                    boolean b = uploadFile(path,file.getName());
                    showMessage(b?"上传成功":"上传失败");
                    break;
                case R.id.uploadText:
                    //打开文件管理器选择文件
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                    //设置你要打开文件的类型
                    intent.setType("*/*");
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(intent,1);
                    break;
            }
        }
```

* 重写回调函数 onActivityResult,从文件管理器获取路径，并将获取到的文件的文件名写回到TiewView

```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();

            //兼容各个版本获取文件路径
            if ("file".equalsIgnoreCase(uri.getScheme())) {   //使用第三方打开
                path = uri.getPath();
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
                return;
            }

            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT) { //4.4以上版本
                uri.getScheme();
                path = getPath(this,uri);
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(this, path , Toast.LENGTH_SHORT).show();
            }else{                                                  //4.4以下版本
                path = getRealPathFromURI(uri);
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(UploadActivity.this,path,Toast.LENGTH_SHORT).show();
            }
        }
    }
```

* 4.4版本以下获取路径方法 getRealPathFromURI( Uri )

```java
    public String getRealPathFromURI(Uri contentUri){
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri,proj,null,null,null);
        if(null!=cursor&&cursor.moveToFirst()){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
            cursor.close();
        }
        return res;
    }
```

* 4.4以上版本获取路径方法 getPath(Context , Uri),判断是通过文件管理器的 外部存储管理器/媒体管理器/下载管理器打开的文件，进行获取路径  **@SuppressLint("NewApi")用于屏蔽新API才能使用的方法报的错误**

```java
    @SuppressLint("NewApi")
    public String getPath(final Context context, final Uri uri){

        final boolean isKitKat = Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT;

        //DocumentProvider
        if(isKitKat && DocumentsContract.isDocumentUri(context,uri)){
            //ExternalStorageProvider
            if(isExternalStorageDocument(uri)){
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split =docId.split(":");
                final String type = split[0];

                if("primary".equalsIgnoreCase(type)){
                    return Environment.getExternalStorageDirectory()+"/"+split[1];
                }
            }

            //DownloadsProvider
            else if (isDownloadsDocument(uri)){

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),Long.valueOf(id));
                return getDataColumn(context,contentUri,null,null);
            }

            //MediaProvider
            else if(isMediaDocument(uri)){

                final String docId = DocumentsContract.getDocumentId(uri);
                final String [] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if("image".equals(type)){
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                }else if("video".equals(type)){
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                }else if("audio".equals(type)){
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                return getDataColumn(context,contentUri,selection,selectionArgs);
            }
        }

        //MediaStore(and general)
        else if("content".equalsIgnoreCase(uri.getScheme())){
            return getDataColumn(context,uri,null,null);
        }

        //File
        else if("file".equalsIgnoreCase(uri.getScheme())){
            return uri.getPath();
        }

        return null;

    }

    public String getDataColumn(Context context,Uri uri,String selection,String[] selectionArgs){

        Cursor cursor = null;
        final String column = "_data";
        final String [] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri,projection,selection,selectionArgs,null);
            if(cursor!=null&&cursor.moveToFirst()){
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        return null;

    }

    public boolean isExternalStorageDocument(Uri uri){
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public boolean isDownloadsDocument(Uri uri){
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public boolean isMediaDocument(Uri uri){
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
```

5. 通过uploadFile(path , filename)进行上传

```java
   public boolean uploadFile(String path,String filename){
        File uploadfile = new File(path);
        if(path.isEmpty()||!uploadfile.exists())
            return false;
        try {
            InputStream inputStream = new FileInputStream(uploadfile);

            if(getExternalFilesDir(null)!=null){
                String filePath = getExternalFilesDir(null).toString();
                File downloadfile = new File(getExternalFilesDir(null).toString()+"/"+filename);
                FileOutputStream outputStream = new FileOutputStream(downloadfile);
                byte[] b = new byte[1024];
                int length;
                if((length = inputStream.read(b))!=-1){
                    outputStream.write(b,0,length);
                    while( (length=inputStream.read(b)) != -1 ){
                        outputStream.write(b,0,length);
                    }
                }else{
                    file.delete();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
```

## 四、运行结果及截图

![实验五图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(1).png)

![实验五图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(2).png)

![实验五图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(3).png)

![实验五图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab5(4).png)

## 五、实验心得

本次实验难度较大，最开始不知道如何通过打开文件管理器获取文件，然后通过百度找方法，看到一篇博客写明了如何调用文件管理器，如何兼容各版本以及选取路径，借鉴了其方法，然后就是测试时发现还是没有办法上传，最后发现是权限的问题，通过获取读写权限后最终完成了实验，收获较大，对安卓外部存储有了更深的理解。