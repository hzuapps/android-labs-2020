## 一、实验目标

1. 了解Android的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

# 三、实验步骤

1. 保存闹钟

   ```java
    private void saveAlarmList() {
           Editor editor = getContext().getSharedPreferences(
                   AlarmView.class.getName(), Context.MODE_PRIVATE).edit();
   
           StringBuffer sb = new StringBuffer();
   
           for (int i = 0; i < adapter.getCount(); i++) {
               sb.append(adapter.getItem(i).getTime()).append(",");
           }
           if (sb.length() > 1) {
               String content = sb.toString().substring(0, sb.length() - 1);
               editor.putString(KEY_ALARM_LIST, content);
   
               System.out.println(content);
           } else {
               editor.putString(KEY_ALARM_LIST, null);
           }
           editor.commit();
       }
   
       private void readSaveAlarmList() {
           SharedPreferences sp = getContext().getSharedPreferences(
                   AlarmView.class.getName(), Context.MODE_PRIVATE);
           String content = sp.getString(KEY_ALARM_LIST, null);
   
           if (content != null) {
               String[] timeStrings = content.split(",");
               for (String string : timeStrings) {
                   adapter.add(new AlarmData(Long.parseLong(string)));
               }
           }
       }
   ```

2. 删除闹钟

   ```java
   private void deleteAlarm(int position) {
           AlarmData ad = adapter.getItem(position);
           adapter.remove(ad);
           saveAlarmList();
   
           alarmManager.cancel(PendingIntent.getBroadcast(getContext(),
                   ad.getId(), new Intent(getContext(), AlarmReceiver.class), 0));
       }
   ```

# 四、运行结果及截图

如图所示：添加闹钟-->删除闹钟

![lab5](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/lab5.PNG)



# 五、心得体会

​	通过本次的实验，我学会了如何使用内部存储。这次实验对我来说难度较大，刚开始是在菜鸟教程学习如何使用，但是这个过程中一直报错，最后在百度上找到一些博客解决了我的问题。
