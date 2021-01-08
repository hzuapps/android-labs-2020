## 实验五
一、实验目标  
1.了解Andoid的存储手段;  
2.掌握Android的文件存储;  
3.掌握Android的数据库存储.  
二、实验内容  
应用数据存储可采用数据库存储。  
1.将应用产生的数据存储到数据库中；  
2.将应用运行结果截图。  
三、实验步骤 
1、数据库接口StorageDao类
```
public class StorageDao {
    private DBOpenHelper dbOpenHelper;// 创建DBOpenHelper对象
    private SQLiteDatabase sqliteDatabase;// 创建SQLiteDatabase对象

    public StorageDao(Context context)// 定义构造函数
    {
        dbOpenHelper = new DBOpenHelper(context, null, null, 0);// 初始化DBOpenHelper对象
    }
    // 插入用户数据
    public void dbInsert(String name, String location,String opendate,String overduedate) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();// 以读写方法打开数据库，不仅仅是写，getReadableDatabase()是只读
        String sql = "insert into Storage_of_goods(name,location,opendate,overduedate,isDel) values (?,?,?,?,0)";
        // 传递过来的name,location,opendate,overduedate分别按顺序替换上面sql语句的四个?，自动转换类型，下同，不再赘述
        Object bindArgs[] = new Object[] { name,location,opendate,overduedate};
        // 执行这条无返回值的sql语句
        sqliteDatabase.execSQL(sql, bindArgs);
    }
     // 求出表中有多少条数据
    public int dbGetUserSize() {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select count(*) from Storage_of_goods where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        if (cursor.moveToNext())// 判断Cursor中是否有数据
        {
            return cursor.getInt(0);// 返回总记录数
        }
        return 0;// 如果没有数据，则返回0
    }
    //通过输入名称寻找数据
    public Storage dbQueryOneByUsername(String name) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from Storage_of_goods where name=? and isDel=0";
        String[] selectionArgs = new String[] { name };
        Cursor cursor = sqliteDatabase.rawQuery(sql, selectionArgs);
            if (cursor.moveToNext())// 判断Cursor中是否有数据
            {
                // 如果有用户，则把查到的值填充这个用户实体
                Storage storage = new Storage();
                storage.setId(cursor.getInt(cursor.getColumnIndex("id")));
                storage.setName(cursor.getString(cursor.getColumnIndex("name")));
                storage.setLocation(cursor.getString(cursor.getColumnIndex("location")));
                storage.setOpendate(cursor.getString(cursor.getColumnIndex("opendate")));
                storage.setOverduedate(cursor.getString(cursor.getColumnIndex("overduedate")));
                return storage;// 返回一个物品给前台
            }
        return null;// 没有返回null
    }

    // 查询所有物品
    public ArrayList<Storage> dbQueryAll() {
        ArrayList<Storage> storagesArrayList = new ArrayList<Storage>();
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from Storage_of_goods where isDel=0";
        Cursor cursor = sqliteDatabase.rawQuery(sql, null);
        // 游标从头读到尾
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
                Storage storage = new Storage();
                storage.setId(cursor.getInt(cursor.getColumnIndex("id")));
                storage.setName(cursor.getString(cursor.getColumnIndex("name")));
                storage.setLocation(cursor.getString(cursor.getColumnIndex("location")));
                storage.setOpendate(cursor.getString(cursor.getColumnIndex("opendate")));
                storage.setOverduedate(cursor.getString(cursor.getColumnIndex("overduedate")));
                storagesArrayList.add(storage);
            }
        }
        return storagesArrayList;
    }
    // 删除物品，其实是把相应的isDel值从0改1
    public void dbDeleteUser(int id) {
        sqliteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "update Storage_of_goods set isDel=1 where id=?";
        Object bindArgs[] = new Object[] { id };
        sqliteDatabase.execSQL(sql, bindArgs);
    }

}
```
2、DBOpenHelper类
```
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        String sql=
                "create table if not exists Storage_of_goods("+
                        "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                        "name VARCHAR(255),"+
                        "location VARCHAR(255),"+
                        "opendate VARCHAR(255),"+
                        "overduedate VARCHAR(255),"+
                        "isDel INTEGER DEFAULT 0"+
                        ")";//如果初次运行，建立一张Storage_of_goods表，建表的时候注意，自增是AUTOINCREMENT，而不是mysql的AUTO_INCREMENT
        sqliteDatabase.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        //这里是更新数据库版本时所触发的方法
    }
}
```
3、物品Storage类
```
public class Storage {
    private int id;
    private String name;
    private String location;
    private int isDel;

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public String getOverduedate() {
        return overduedate;
    }

    public void setOverduedate(String overduedate) {
        this.overduedate = overduedate;
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    private  String opendate;
    private String overduedate;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
```
4、往数据插入数据类RecordActivity类
```
public class RecordActivity extends Activity {
    private EditText text1;        //物品名称
    private EditText text2;        //物品位置
    private EditText text3;        //开启时间
    private EditText text4;       //过期时间
    private Button button1;                //提交信息
    private StorageDao storageDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        // 注册组件
        storageDao=new StorageDao(this);
        text1=(EditText) findViewById(R.id.editText);
        text2=(EditText) findViewById(R.id.editText2);
        text3=(EditText) findViewById(R.id.editText3);
        text4=(EditText) findViewById(R.id.editText4);
        button1=(Button)findViewById(R.id.button5);

        //物品登记
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String name = text1.getText() + "";
                String location = text2.getText() + "";
                String opendate=text3.getText() +"";
                String overduedate=text4.getText()+"";
                if (name.equals(null) || name == ""
                ) {
                    Toast.makeText(RecordActivity.this, "物品名称不可为空！",
                            Toast.LENGTH_SHORT).show();

                } else  {
                    if (storageDao.dbQueryOneByUsername(name) == null) {
                        storageDao.dbInsert(name,location,opendate,overduedate);
                        Toast.makeText(
                                RecordActivity.this,
                                "物品名称：" + name + "登记成功", Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Toast.makeText(RecordActivity.this, "该物品已登记，可查看列表或更换其他名称",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
```
5、查找结果类AllResult类
```
public class AllResult extends AppCompatActivity {
    //线性布局
    private LinearLayout linearLayout1;
    //返回按钮
    private Button button3;
    private StorageDao stotagedao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_result);
// 注册组件
        stotagedao = new StorageDao(this);
        button3 = (Button) findViewById(R.id.button3);
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        //求出物品的数量，并且显示
        int userSize = stotagedao.dbGetUserSize();
        TextView textView1 = new TextView(this);
        textView1.setText("共有" + userSize + "个物品");
        textView1.setTextSize(24);
        linearLayout1.addView(textView1, 1);//添加的textView1放到activity_table.xml中tag=1的View那个位置
        //如果物品数量为0就不用搞这么东西添加表格布局了
        if (userSize > 0) {
            ArrayList<Storage> userList = stotagedao.dbQueryAll();//查出表中的所有物品放到一个ArrayList中
            TableLayout tableLayout1 = new TableLayout(this);//新建一个表格布局
            tableLayout1.setStretchAllColumns(true);//自动宽度，使表格在横向占据100%
            //打印表头
            TableRow tableRow = new TableRow(this);//新建一行

            TextView textView = new TextView(this);//新建一个TextView
            textView.setTextSize(24);//设置字体
            textView.setText("物品名称");
            tableRow.addView(textView);//放到行中，自动增加一个单元格

            textView = new TextView(this);
            textView.setTextSize(24);
            textView.setText("存放位置");
            tableRow.addView(textView);

            textView = new TextView(this);
            textView.setTextSize(24);
            textView.setText("删除");
            tableRow.addView(textView);

            // 新建的行TableRow添加到表格TableLayout之中
            tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            //打印物品信息
            for (int i = 0; i < userSize; i++) {
                Storage storage = userList.get(i);
                // 一个物品占据一行
                tableRow = new TableRow(this);

                textView = new TextView(this);
                textView.setTextSize(18);
                textView.setText(storage.getName());
                tableRow.addView(textView);

                textView = new TextView(this);
                textView.setTextSize(18);
                textView.setText(storage.getLocation());
                tableRow.addView(textView);


                Button button = new Button(this);
                button.setText("删除");
                button.setTextSize(18);
                button.setId(storage.getId());//设置按钮的id就是物品的id
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        stotagedao.dbDeleteUser(view.getId());//这样可以获取按钮的id
                        //修改密码，更新数据库之后，刷新一下这个TableActivity
                        finish();
                        Intent intent = new Intent(AllResult.this,
                                AllResult.class);
                        startActivity(intent);
                        Toast.makeText(AllResult.this, "删除成功！",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                tableRow.addView(button);//将这个按钮添加到这行中
                // 新建的TableRow添加到TableLayout
                tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

            }
            linearLayout1.addView(tableLayout1, 2);//把这个表格放到activity_table.xml中tag=2的View那个位置
        }
        //返回Net1814080903337Activity
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
                Intent intent = new Intent(AllResult.this, Net1814080903337Activity.class);
                startActivity(intent);
            }
        });
    }
```
实验截图
![avatar](https://github.com/fairy-lee/android-labs-2020/blob/master/students/picture/sy5.1.jpg)  
![avatar](https://github.com/fairy-lee/android-labs-2020/blob/master/students/picture/sy5.2.jpg)  
![avatar](https://github.com/fairy-lee/android-labs-2020/blob/master/students/picture/sy5.3.jpg)  
四、实验心得
本次实验难度很大，在这个实验花的时间比之前的实验花的时间都多，不停的调整变量，页面间的跳转也调整了很久。但是通过这个实验也初步掌握了利用Android studio自带的sqlite数据库进行数据存储和读取的方法。

