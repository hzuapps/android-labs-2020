# 实验五
## 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
## 二、实验内容
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。
## 三、实验步骤
1. 创建一个类MyHelper继承SQLiteOpenHelper;
2. 创一个数据库TeachingbarImformation;
3. 在数据库TeachingbarImformation中创建两个表StuImformation,TimeAndMoney分别用于存储学生信息和课时费信息;
### 代码如下
```java
public class myHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "TeachingbarImformation"; //创建数据库
    static final int DATABASE_VERSION = 1;  //指定数据库版本
    public myHelper(@Nullable Context context) {

        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE StuImformation(stuname VARCHAR(20), courses VARCHAR(20), classtime VARCHAR(20))"); //创建学生信息表
        db.execSQL("CREATE TABLE TimeAndMoney(teachername VARCHAR(20), stuname VARCHAR(20), totaltimes VARCHAR(20))"); //创建课时费管理信息表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

```  
4. 分别在Net814080903333TeacherHomeActivity、Net1814080903333StudentsInformationActivity2中实现增删改查功能;    
### 代码如下  
```java  
public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Intent intent = new Intent(Net814080903333TeacherHomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button:
                name = thname.getText().toString();  //获取文本框数据
                course = stuname.getText().toString(); //获取文本框数据
                time = totaltime.getText().toString(); //获取文本框数据
                if (name.equals("")||course.equals("")&&time.equals("")) //判断是否为空
                {
                    Toast.makeText(this, "请输入数据!!!", Toast.LENGTH_LONG).show();
                }else{
                    db = helper.getReadableDatabase();
                    values = new ContentValues();
                    values.put("teachername", name); //数据存储
                    values.put("stuname", course);  //数据存储
                    values.put("totaltimes", time); //数据存储
                    db.insert("TimeAndMoney", null, values);
                    Toast.makeText(this, "添加成功！", Toast.LENGTH_LONG).show();
                    db.close();
                    break;}
            case R.id.button3:
                db = helper.getReadableDatabase();
                cursor = db.query("TimeAndMoney",null,null,null,null,null,null);
                if (cursor.getCount() == 0) {
                    textView.setText("");
                    Toast.makeText(this, "没有数据！！！", Toast.LENGTH_LONG).show();
                } else {
                    cursor.moveToFirst();
                    textView.setText("Name:"+cursor.getString(0)+"\t"+"StuName:"+cursor.getString(1)+"\t"+"Totaltimes:"+cursor.getString(2));
                }
                while (cursor.moveToNext()) {
                    textView.append("\n"+"Name:"+ cursor.getString(0)+"\t"+"StuName:" + cursor.getString(1)+"\t"+ "Totaltimes:" + cursor.getString(2));
                }
                cursor.close();
                db.close();
                break;
            case R.id.button4:
                db=helper.getWritableDatabase();
                db.delete("TimeAndMoney","teachername=? and stuname=?",new String[]{thname.getText().toString(),stuname.getText().toString()});
                Toast.makeText(this, "删除成功！", Toast.LENGTH_LONG).show();
                cursor = db.query("TimeAndMoney",null,null,null,null,null,null);
                cursor.moveToFirst();
                textView.setText("Name:"+cursor.getString(0)+"\t"+"StuName:"+cursor.getString(1)+"\t"+"Totaltimes:"+cursor.getString(2));
                while (cursor.moveToNext()) {
                    textView.append("\n"+"Name:"+ cursor.getString(0)+"\t"+"StuName:" + cursor.getString(1)+"\t"+ "Totaltimes:" + cursor.getString(2));
                }
                cursor.close();
                db.close();
                break;
            case R.id.button1:
                db=helper.getWritableDatabase();
                values=new ContentValues();
                values.put("teachername",name=thname.getText().toString());
                values.put("stuname", course=stuname.getText().toString());
                values.put("totaltimes", time=totaltime.getText().toString());
                db.update("TimeAndMoney",values,"stuname=? and teachername=?",new String[]{stuname.getText().toString(),thname.getText().toString()});
                db.close();
                Toast.makeText(this, "更新成功！", Toast.LENGTH_LONG).show();

                break;

    }
}}
```  
## 四、实验结果

## 五、实验心得体会





