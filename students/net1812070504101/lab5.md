# 实验五  

## 一.实验目标  
1.了解Andoid的存储手段  
2.掌握Android的文件存储  
3.掌握Android的数据库存储
  
## 二.实验内容
1. 应用数据存储可采用数据库存储。
2. 将应用产生的数据存储到数据库中；
3. 将应用运行结果截图。 
## 三.实验步骤
1.创建 DatabaseHelper类继承SQLiteOpenHelper 并且实现父类的方法  
```
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE = "create table student(_id varchar(10),sname varchar(10) );";

    public DatabaseHelper(Context context) {
        super( context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE); // 执行这句才会创建表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
```
2. 创建Util 工具类封装方法
```
public class Util {

    public void insert(SQLiteDatabase db){
        String sql="insert into student values(1,'ly'),(2,'lq');";
        db.execSQL(sql);
       // db.close();
    }

    public void Query(SQLiteDatabase db){
        String sql="select * from student";
        try{
            Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
                    String id=cursor.getString(cursor.getColumnIndex("_id"));
                    String sname=cursor.getString(cursor.getColumnIndex("sname"));
                    Log.d(TAG,sname);
                }
       }catch (SQLiteException ex){
            ex.printStackTrace();
        }finally {
       //     cursor.close();
            db.close();
        }
    }
    public void delete(SQLiteDatabase db){
        String sql="delete from student ;";
        db.execSQL(sql);
       // db.close();
    }
```
3.在mainActivity中测试数据
```
 DBHelper=new DatabaseHelper(this);
        SQLiteDatabase DB=DBHelper.getWritableDatabase();
        util.delete(DB);
        util.insert(DB);
        util.Query(DB);
```

## 四.实验结果 
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab5_1.png" height=50%>
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab5_2.png" height=50%>  

## 五.实验心得  
  本次实验，用到了SQLiteDatabase,过程中遇到很多bug,完成的很艰辛















