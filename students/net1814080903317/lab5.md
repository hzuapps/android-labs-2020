# 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容

- 根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

- 应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

# 三、实验步骤

1. 编写数据库连接类DBOpenHelper，继承SQLiteOpenHelper。按照JavaEE三层架构，Controller调用Service、Serveice调用dao、dao编写CURD等语句对数据库进行操作，然后返回结果给Service，Servcie再返回结果给Controller。我这里为了实现方便，直接省略掉Service业务层。

   DBOpenHelper：

   ```java
   public class DBOpenHelper extends SQLiteOpenHelper {
       public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
           //调用构造方法，向系统申请一个SqliteTest.db文件存这个数据库，其中1是数据库版本
           super(context, "foundit", null, 1);
       }
   
       @Override
       public void onCreate(SQLiteDatabase db) {
           ///如果初次运行，建立一张t_user表，建表的时候注意，自增是AUTOINCREMENT，而不是mysql的AUTO_INCREMENT
           String sql="create table if not exists t_info(" +
                   "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                   "type VARCHAR(255),"+
                   "state VARCHAR(255),"+
                   "content VARCHAR(255)"+
                   ");";
   
           db.execSQL(sql);
       }
   
   
       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           //这里是更新数据库版本时所触发的方法
       }
   }
   ```

   

2.  编写实体类Info，属性对应数据库表中的字段。

   ```java
   private Integer id;
   private String type;
   private String state;
   private String content;
   ```

   这里省略setter、getter方法和toString()。

3.  编写dao层：InfoDao

   ```java
   //插入用户数据
   public void  dbInsert(String type,String state,String content){
       // 以读写方法打开数据库，不仅仅是写，getReadableDatabase()是只读
       sqLiteDatabase=dbOpenHelper.getWritableDatabase();
       String sql="insert into t_info(type,state,content) values(?,?,?);";
       // 传递过来的username与password分别按顺序替换上面sql语句的两个?，自动转换类型，下同，不再赘述
       Object bindArgs[] = new Object[] { type, state,content };
       // 执行这条无返回值的sql语句
       sqLiteDatabase.execSQL(sql,bindArgs);
   }
   ```

   ```java
   //查询所有用户
   public List<Info> dbSelectAllInfos(){
       sqLiteDatabase=dbOpenHelper.getWritableDatabase();
       List<Info> infoList=new ArrayList<>();
       String sql="select * from t_info;";
       Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
       while (cursor.moveToNext()) {
           //判断Cursor中是否有数据
           //如果有用户，则把查到的值填充这个用户实体
           Info info=new Info();
           info.setId(cursor.getInt(cursor.getColumnIndex("id")));
           info.setType(cursor.getString(cursor.getColumnIndex("type")));
           info.setState(cursor.getString(cursor.getColumnIndex("state")));
           info.setContent(cursor.getString(cursor.getColumnIndex("content")));
           infoList.add(info);
       }
       return infoList;
   }
   ```

   把数据封装到list，剩下的就不展示了。

4. 在主页面调用dao获取数据，通过构造方法传给适配器：

   ```java
   List<Info> infoList=infoDao.dbSelectAllInfos();
   FoundItMainAdapter foundItMainAdapter=new FoundItMainAdapter(infoList,Net1814080903317FoundItMainActivity.this);
   recyclerView.setAdapter(foundItMainAdapter);
   ```

5. 在适配器中先通过构造方法获取到传过来的数据，然后再冲洗额的onBindViewHolder方法中显示数据：

   ```java
   @Override
   public void onBindViewHolder(@NonNull FoundItMainInnerHolder holder, int position) {
       Info info=infoList.get(position);
       Drawable drawable=context.getResources().getDrawable(R.drawable.headphoto);
       //设置头像
       holder.headPhotoIv.setImageDrawable(drawable);
       //设置状态
       holder.typeTv.setText(info.getType());
       //设置内容
       holder.contentTv.setText(info.getContent());
       //联系TA点击事件......
       holder.connenctionTv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ToastUtils.makeText(context,"你点击了联系TA");
           }
       });
       //评论的点击事件
       holder.commentIv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ToastUtils.makeText(context,"你点击了评论");
           }
       });
   
   }
   ```

# 四、实验结果

   最终的运行结果展示：

![图片2](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/lab2-1.png?raw=true)

# 五、实验心得体会

这次的实验，一开始我是想着使用本地mysql数据库的，但经过多次尝试，网上也百度了好多次，查阅的博客不下15篇，但还是没法连接成功，一周之后就使用Android自带数据库sqllite了，使用过程中，基本没遇到什么问题，思路也比较清晰，然后就是在设计实体类的时候，想着图片的数据类型是什么，百度之后一般是使用string，但是由于这里实现简单我就直接使用res资源目录下的mipmap目录下的资源了，图片的加载可以使用Glide，还有就是其他字段，像时间、等等需要进行格式化。总之这次的实验难度还是有一点的，需要理解一下javaee的三层架构，用到的技术点也相对较多一点，继续加油！