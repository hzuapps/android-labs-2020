## 一、实验目标（选做）

- 理解Android相机、蓝牙、传感器等设备编程方法。
- 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容

选择一个跟选题相关的设备功能；
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

## 三、实验步骤

- 创建MusicService服务，在MusicControl类中定义四个方法
```java
    class MusicControl extends Binder{
        public void play(int i){//String path
                Uri uri=Uri.parse("android.resource://"+getPackageName()+"/raw/"+"music"+i);
                try{
                    player.reset();//重置音乐播放器
                    //加载多媒体文件
                    player=MediaPlayer.create(getApplicationContext(),uri);
                    player.start();//播放音乐
                    addTimer();//添加计时器
                }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void pausePlay(){
            player.pause();//暂停播放音乐
        }
        public void continuePlay(){
            player.start();//继续播放音乐
        }
        public void seekTo(int progress){
            player.seekTo(progress);//设置音乐的播放位置
        }
    }
```  
- 添加计时器用于设置音乐播放器中的播放进度条
```java
    public void addTimer(){ 
        if(timer==null){
            timer=new Timer();//创建计时器对象
            TimerTask task=new TimerTask() {
                @Override
                public void run() {
                    if (player==null) return;
                    int duration=player.getDuration();//获取歌曲总时长
                    int currentPosition=player.getCurrentPosition();//获取播放进度
                    Message msg=Music_Activity.handler.obtainMessage();//创建消息对象
                    //将音乐的总时长和播放进度封装至消息对象中
                    Bundle bundle=new Bundle();
                    bundle.putInt("duration",duration);
                    bundle.putInt("currentPosition",currentPosition);
                    msg.setData(bundle);
                    //将消息发送到主线程的消息队列
                    Music_Activity.handler.sendMessage(msg);
                }
            };
            //开始计时任务后的5毫秒，第一次执行task任务，以后每500毫秒执行一次
            timer.schedule(task,5,500);
        }
    }
```
## 四、实验结果
播放界面  
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/sy7.jpg)  

## 五、实验心得
本次实验没有做拍照、录视频和检测网络等功能，选择实现了播放功能，设置了进度条，解决了闪退问题。

