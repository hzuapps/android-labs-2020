# 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

# 三、实验步骤

1. 将ContentProviderOfRecords注册到AndroidManifest.xml中

   ```java
    <provider
         android:authorities="edu.hzuapps.androidlabs.ContentProviderOfRecords"
               android:name=".ContentProviderOfRecords"/>
   ```

2. 创建ContentProviderOfRecords类，该类负责与数据库进行交互；核心代码如下：

   ```java
    private static class DatabaseHelper extends SQLiteOpenHelper {
           DatabaseHelper(Context context) {
               super(context, DATABASE_NAME, null, DATABASE_VERSION);
           }
   
           @Override
           public void onCreate(SQLiteDatabase db) {
               db.execSQL(CREATE_DB_TABLE);
           }
   
           @Override
           public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
               db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORDS);
               onCreate(db);
           }
       }
   
   ```

3. 在RecordActivity类中调用ContentProviderOfRecords中的方法，向ContentProviderOfRecords中传送封装好的实体类，然后接收返回的数据，再写到应用界面。

   ```java
   //保存分数记录
       private void saveRecord() {
           String score = ((TextView) findViewById(R.id.tscore)).getText().toString();
           String best = ((TextView) findViewById(R.id.tbest)).getText().toString();
   
           // 插入新记录
           ContentValues record = new ContentValues();
           //book.put("name", name); // Map <- Key:Value
           record.put(ContentProviderOfRecords.SCORE,score);
           record.put(ContentProviderOfRecords.BEST, best);
   
           Uri uri = getContentResolver() // 执行插入操作
                   .insert(ContentProviderOfRecords.CONTENT_URI, record);
   
           Toast.makeText(getBaseContext(), //
                   "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();
   
           this.showRecordInfo("",best); // 清除内容
       }
   
       private void showRecordInfo(String score, String best) {
           ((TextView) findViewById(R.id.tscore)).setText(score);
           ((TextView) findViewById(R.id.tbest)).setText(best);
       }
   ```



# 四、实验结果

![lab5-1](https://github.com/zm-w/android-labs-2020/blob/master/students/net1814080903141/lab5-1.png)

![lab5-2](https://github.com/zm-w/android-labs-2020/blob/master/students/net1814080903141/lab5-2.png)



# 五、实验心得

　本次实验是Android存储编程，难度较大，实验使用了SQLiteOpenHelper的子类进行创建数据库。实验的整体思路是：RecordActivity类将界面输入的信息封装给user实体，然后调用ContentProviderOfRecords中 的执行方法user实体的相应信息传送过去，然后再将返回的数据在RecordActivity上进行处理和显示。