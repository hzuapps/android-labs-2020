# 实验五：Android存储编程

## 一、实验要求

1.了解Andoid的存储手段

2.掌握Android的文件存储

3.掌握Android的数据库存储

## 二、实验内容

1.将应用产生的数据保存到文件存储中；

2.说明使用的文件存储方式：内部 or 外部；

3.将运行结果截图。

##  三、实验步骤
1.数据源：

```
List<LocalMusicBean> mDatas;
```

2.针对SD卡申请权限：

```
private static String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
};
```

3.在Sec1814080911113Activity中添加loadLocalMusicData()方法来加载本地存储中的MP3文件：

```
private void loadLocalMusicData() {
        /* 加载本地存储当中的音乐mp3文件到集合当中*/
//        1.获取ContentResolver对象
        ContentResolver resolver = getContentResolver();
//        2.获取本地音乐存储的Uri地址
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//        3 开始查询地址
        Cursor cursor = resolver.query(uri, null, null, null, null);
//        4.遍历Cursor
        int id = 0;
        while (cursor.moveToNext()) {
            String song = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            id++;
            String sid = String.valueOf(id);
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
            String time = sdf.format(new Date(duration));
//          获取专辑图片主要是通过album_id进行查询
            String album_id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
            String albumArt = getAlbumArt(album_id);
//            将一行当中的数据封装到对象当中
            LocalMusicBean bean = new LocalMusicBean(sid, song, singer, album, time, path,albumArt);
            mDatas.add(bean);
        }
//        数据源变化，提示适配器更新
        adapter.notifyDataSetChanged();
    }
```

## 四、实验结果

<img src="https://github.com/BlaiseChin/android-labs-2020/tree/master/students/sec1814080911113/lab5">

## 五、实验心得
  通过本次实验我学会了安卓存储方面的知识，但是看似简单的存储也有很大的学问，Android 6以上对APP权限的申请进行了动态权限的申请，所以在这里碰了许多钉子，走了许多弯路。
