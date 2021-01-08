# 一、实验目的

1.了解Andoid的存储手段
2.掌握Android的文件存储
3.掌握Android的数据库存储

# 二、实验内容

1.在AndroidManifest.xml里面请求读取内存权限
2.创建LocalMusicBean.java中撰写显示歌曲的有关代码
3.创建LocaLMusicAdapter.java适配器对象
4.在Net1814080903330.java中补上有关代码

# 三、实验步骤
1.在AndroidManifest.xml里面请求读取内存权限
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

2.创建LocalMusicBean.java
```
    private String id; //歌曲id
    private String song; //歌曲名称
    private String singer; //歌手名称
    private String album; //专辑名称
    private String duration; //歌曲时长
    private String path; //歌曲路径
    private String albumArt;  //专辑地址

    public LocalMusicBean() {
    }

    public LocalMusicBean(String id, String song, String singer, String album, String duration, String path, String albumArt) {
        this.id = id;
        this.song = song;
        this.singer = singer;
        this.album = album;
        this.duration = duration;
        this.path = path;
        this.albumArt = albumArt;
    }
```

3.创建LocaLMusicAdapter.java适配器对象
    
4.Net1814080903330.java中补上有关代码
    
```
    //针对sd卡读取权限申请
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    
    //申请权限

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }
        public void playMusicInMusicBean(LocalMusicBean musicBean) {
        /*根据传入对象播放音乐*/
        //设置底部显示的歌手名称和歌曲名
        singerTv.setText(musicBean.getSinger());
        songTv.setText(musicBean.getSong());
        stopMusic();
//                重置多媒体播放器
        mediaPlayer.reset();
//                设置新的播放路径
        try {
            mediaPlayer.setDataSource(musicBean.getPath());
            String albumArt = musicBean.getAlbumArt();
            Log.i("lsh123", "playMusicInMusicBean: albumpath=="+albumArt);
            Bitmap bm = BitmapFactory.decodeFile(albumArt);
            Log.i("lsh123", "playMusicInMusicBean: bm=="+bm);
            albumIv.setImageBitmap(bm);
            playMusic();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
# 四、实验结果

# 五、实验心得
    一开始很多东西都不太不理解，在网上学习了很久有关数据存储的知识，终于完成了。


    
