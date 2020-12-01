# 实验五
## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 使用其中一种布局方式，设计所选题目的界面(LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学))
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理，例如点击按钮：
4. 操作之后，切换到你的第二个界面。

## 三、实验步骤

1. 将Android 提供的 SQLiteOpenHelper抽象类继承为DatabaseHelper，实现抽象类SQLiteOpenHelper中的两个抽象方法onCreate，onUpgrade，编写构造函数；
```
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    //带全部参数的构造函数，此构造函数必不可少
    public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库sql语句 并 执行
        String sql = "create table accountbook(time TEXT NOT NULL, number varchar(20) NOT NULL)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
```
2. 在原有的Accounting类中生成EditText对象，用来获取文本输入框中用户输入的内容；
```
private EditText timeInsert;
private EditText numberInsert;
private TextView tvQueryResult;
timeInsert = findViewById(R.id.ac_time);
numberInsert = findViewById(R.id.ac_number);
/ 1个查询结果展示文本
tvQueryResult = findViewById(R.id.tv_query_result);
```
3. 创建数据库，给数据库起名为“test_db”，数据库版本号为1；
```
//依靠DatabaseHelper的构造函数创建数据库
DatabaseHelper dbHelper = new DatabaseHelper(Accounting.this, "test_db", null, 1);
db = dbHelper.getWritableDatabase();
```
4. 响应增加、查询和返回首页的三个按钮点击时触发的操作
```
public void onClick(View v) {
        String timeData = timeInsert.getText().toString();
        String numberData = numberInsert.getText().toString();
        switch (v.getId()) {
            //记账按钮
            case R.id.button_accounting:
                //创建存放数据的ContentValues对象
                ContentValues values = new ContentValues();
                values.put("time", timeData);
                values.put("number", numberData);
                //数据库执行插入命令
                db.insert("accountbook", null, values);
                showAccountInfo(" "," ");
                break;
            case R.id.button_openAccountBook:
                final Accounting thisActivity = this;
                Intent intent = new Intent(thisActivity, AccountBook.class);
                thisActivity.startActivity(intent);
                break;
            case R.id.bt_query:
                //创建游标对象
                Cursor cursor = db.query("accountbook", new String[]{"time","number"}, null, null, null, null, null);
                //利用游标遍历所有数据对象（for循环中，建议使用StringBuilder替代String）
                //为了显示全部，把所有对象连接起来，放到TextView中
                StringBuilder tvData = new StringBuilder();
                while (cursor.moveToNext()) {number
                    String time = cursor.getString(cursor.getColumnIndex("time"));
                    String number = cursor.getString(cursor.getColumnIndex("number"));
                    tvData.append("\n账单日期").append(time).append(" 账单数目").append();
                }
                tvQueryResult.setText(tvData.toString());
                cursor.close(); // 关闭游标，释放资源
                break;
            default:
                break;
        }
    }
```
## 四、实验结果

![result](https://raw.githubusercontent.com/Unknowuse/android-labs-2020/master/students/net1814080903212/lab5result.png)

## 五、实验心得

这次实验我对我实现了将用户输入的账单输入到数据库中，并将其查询出来的功能，不足的地方就是我没能把查询的功能放在账本页面之中。后面的实验我会把它修改到账本之中，使它符合逻辑。
