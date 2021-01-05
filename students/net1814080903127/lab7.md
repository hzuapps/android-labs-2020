# 一、实验目标
1. 了解Android的AlarmManager类
2. 了解Android的Broadcast的机制
3. 了解Android的Calendar类
# 二、实验内容
1. 完善剩下的“待办提醒”功能
2. 为添加提醒设计一个界面，能获取时间
3. 使用AlarmManager类创建对象
4. 编写广播接收器用于接收闹钟广播
5. 编写到点提醒的界面
# 三、实验步骤
1. 设置AlarmManager，当创建一条提醒时，发送广播
```java
c=RemindAdd.this;
alarmManager= (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
...
PendingIntent pi = PendingIntent.getBroadcast(c, id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
```
2. 设置Calendar，用来获取、设置时间
```java
calendar=Calendar.getInstance();
calendar.setTimeInMillis(System.currentTimeMillis());
mHour = calendar.get(Calendar.HOUR_OF_DAY);
mMinute = calendar.get(Calendar.MINUTE);
```
3. 设置一个广播接收类，接收广播
```java
public class Receiver extends BroadcastReceiver {
//接收广播
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, ShowTip.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
```
4. 编写用于提醒的界面
# 四、实验结果
![lab7.1](https://github.com/cxcx75/android-labs-2020/blob/master/students/net1814080903127/lab7.1.png)
![lab7.2](https://github.com/cxcx75/android-labs-2020/blob/master/students/net1814080903127/lab7.2.png)
# 五、实验心得
本次实验主要实现“待办提醒”功能，使用Calendar类和日期时间控件能方便地设置触发时间，简单地利用AlarmManager+Broadcast实现类似闹钟的提醒，设置要做的事和时间，到点就弹窗。做的过程中，发现当设置多个提醒时，新的提醒会把旧的覆盖掉，后来查找资料得知PendingIntent.getBroadcast(Context context, int requestCode, Intent intent, int flags)第二个参数设置闹钟id，令它不同就不会覆盖了。
