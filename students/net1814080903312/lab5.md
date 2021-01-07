# 一、实验目的
1.了解Android的存储手段  
2.掌握Android的文件存储  
3.掌握Android的数据库存储
# 二、实验内容
1.获取访问文件权限  
2.筛选音乐文件  
3.将所得文件放入列表中    
# 三、实验步骤
1.读与写的权限定义到静态字符数组中
```
       <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
2.编写huoqu方法访问本地文件，并筛选音乐文件
```
public void huoqu(View v){
        ContentResolver contentResolver=getContentResolver();
        Cursor c=contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        if (c!=null){
            int i=0;
            while(c.moveToNext()){
                Map<String,Object> map= new HashMap<String, Object>();
                //歌曲
                name[i]=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                id[i]=c.getInt(c.getColumnIndex(MediaStore.Audio.Media._ID));
                //作者
                artical[i]=c.getString(c.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                //路径
                url[i]=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA));
                map.put("SongName", name[i]);
                map.put("id", id[i]);
                map.put("Artical", artical[i]);
                map.put("url", url[i]);
                list.add(map);
                i++;
            }
            adapter = new SimpleAdapter(getApplicationContext(), list, R.layout.content,
                    new String[] { "SongName","Artical" }, new int[] { R.id.name,R.id.artical});
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //从头开始播放音乐

                    if (i<list.size()){
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                        }
                        Uri conuri= ContentUris.withAppendedId(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,id[i]);
                        try {
                            mediaPlayer.setDataSource(getApplicationContext(),conuri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        index=i;
                        isPause=false;
                        mediaPlayer.prepareAsync();
                    }
                }
            });
        }else{
            Toast.makeText(getApplicationContext(),"本地没有音乐文件",Toast.LENGTH_LONG).show();
        }
    }
```
# 四、实验结果
![播放界面](https://raw.githubusercontent.com/xiangzuonidekongbai/android-labs-2020/master/students/net1814080903312/lab5-1.PNG)
![播放界面](https://raw.githubusercontent.com/xiangzuonidekongbai/android-labs-2020/master/students/net1814080903312/lab5-2.PNG)
# 五、实验心得
本次实验学习如何访问内存并进行文件存储，一开始毫无头绪，通过观看一些教学视频以及网上一些大佬的代码后，慢慢摸索出来，但是代码还是存在问题，没能真正完成。
