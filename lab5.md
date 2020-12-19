# 实验五
## 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤
1. 在LupingActivity.java中加入存储视频的代码；
2. 存储时可以选择需要存放视频的文件夹或者创建一个文件夹；
3. 利用当前的毫秒数给视频命名。

```java
 private File createMediaFile() throws IOException {

            if ((Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))) {
                // 选择自己的文件夹
                String path = Environment.getExternalStorageDirectory().getPath() + "/myvideo/";
                // Constants.video_url 是一个常量，代表存放视频的文件夹
                File mediaStorageDir = new File(path);
                if (!mediaStorageDir.exists()) {
                    if (!mediaStorageDir.mkdirs()) {
                        Log.e("TAG", "文件夹创建失败");
                        return null;
                    }
                }

                // 文件根据当前的毫秒数给自己命名
                String timeStamp = String.valueOf(System.currentTimeMillis());
                timeStamp = timeStamp.substring(7);
                String imageFileName = "V" + timeStamp;
                String suffix = ".mp4";
                File mediaFile = new File(mediaStorageDir + File.separator + imageFileName + suffix);
                return mediaFile;
            }else return null;
    }
```

## 四、实验心得
此次实验没有用到老师讲的存储编程，没有用到数据库，我用了另外一种存储视频的方式，但是存储基本的原理也是差不多的。
