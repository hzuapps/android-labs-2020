# 实验五
## 一、实验目标
1. 了解Andoid的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

## 二、实验内容
1. 根据选题要求使用文件存储；
2. 应用数据存储可采用数据库存储；
3. 将应用产生的数据存储到数据库中；
4. 将应用运行结果截图。

## 三、实验步骤
1. 定义音乐的实体类：
```java
package edu.hzuapps.androidlabs.net1814080903136;
class music {
    public String song;//歌曲名
    public String singer;//歌手
    public long size;//歌曲所占空间大小
    public int duration;//歌曲时间长度
    public String path;//歌曲地址
}
```
2. 创建工具类，将获得的本地文件存放在里面，并对歌曲名字进行格式编写
```java
public class Utils {
    //定义一个集合，存放从本地读取到的内容
    public static List<music> list;
    public static music song;
    public static List<music> getmusic(Context context) {
        list = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                , null, null, null, MediaStore.Audio.AudioColumns.IS_MUSIC);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                song = new music();
                song.song = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                song.singer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                song.path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                song.duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                song.size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
// 把歌曲名字和歌手切割开
                if (song.size > 1000 * 800) {
                    if (song.song.contains("-")) {
                        String[] str = song.song.split("-");
                        song.song = str[0];
                        song.singer = str[1];
                    }
                    list.add(song);
                }

            }
        }
        cursor.close();
        return list;
    }
    //    转换歌曲时间的格式
    public static String formatTime(int time) {
        if (time / 1000 % 60 < 10) {
            String tt = time / 1000 / 60 + ":0" + time / 1000 % 60;
            return tt;
        } else {
            String tt = time / 1000 / 60 + ":" + time / 1000 % 60;
            return tt;
        }
    }

}
```
3. 将获取的歌名输出显示到列表
```java   
    class MyAdapter extends BaseAdapter {

        Context context;
        List<music> list;

        public MyAdapter(Net1814080903136Activity net1814080903136Activity, List<music> list) {
            this.context = net1814080903136Activity;
            this.list = list;
        }
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public Object getItem(int i) {
            return list.get(i);
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Myholder myholder;
            if (view == null) {
                myholder = new Myholder();
                view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.text, null);
                myholder.t_position = view.findViewById(R.id.t_postion);
                myholder.t_song = view.findViewById(R.id.t_song);
                myholder.t_singer = view.findViewById(R.id.t_singer);
                myholder.t_duration = view.findViewById(R.id.t_duration);
                view.setTag(myholder);
            } else {
                myholder = (Myholder) view.getTag();
            }
            myholder.t_song.setText(list.get(i).song.toString());
            myholder.t_singer.setText(list.get(i).singer.toString());
            String time = Utils.formatTime(list.get(i).duration);
            myholder.t_duration.setText(time);
            myholder.t_position.setText(i + 1 + "");
            return view;
        }
        class Myholder {
            TextView t_position, t_song, t_singer, t_duration;
        }
    }
} 
```

## 四、实验结果
![运行截图](https://github.com/yesijie0216/android-labs-2020/blob/master/students/net1814080903136/lab5.jpg)

## 五、实验心得
本次实验完成的是外部存储，创建实体类和工具类，对本地文件进行存放，然后输出到列表。本次实验学会了怎样获取外部文件，后续的功能以现在的能力还未能做出。
 
