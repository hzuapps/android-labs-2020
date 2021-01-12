# 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容

应用数据存储可采用数据库存储。
1.将应用产生的数据存储到数据库中；
2.将应用运行结果截图。

# 三、实验步骤

1. 创建一个空activity文件，名字为RankActivity.java，意为排行榜，用ranklist.xml获取数据拼接到activity_rank.xml来形成排行榜

2. 在activity_rank.xml设置布局为RelativeLayout+TableLayout，设置3个组件，分别是标题（排行榜）、表格标题（名次 姓名 分数）、纪录数据

3. 游戏结束时将获取的数据存储到数据库的表格中

```java
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rank);
		lvRank = (ListView) findViewById(R.id.lv_rank);
		dbHelper = new PlaneDBHelper(this, "FinalPlaneDB", null, 1);
		getAllRank();//获取所有人的记录
		rank();//对记录按从小到大的顺序排序

		adapter = new SimpleAdapter(this, listRank, R.layout.ranklist, new String[]{"enemyDestroyedNum","name","score"}, new int[]{R.id.txt_id,R.id.txt_name,R.id.txt_score});
		Log.i("wy", "适配器初始化成功");
		lvRank.setAdapter(adapter);
		edtName = new EditText(this);
		intent = getIntent();
		if(intent.getIntExtra("score", -1) != -1){
			int score = intent.getIntExtra("score", 0);
			new AlertDialog.Builder(this).setTitle("记录")
					.setView(edtName)
					.setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							insert(edtName.getText().toString(), intent.getIntExtra("score", 0)+"");
							Log.i("wy", "插入成功");
							listRank = getAllRank();
							rank();
							adapter.notifyDataSetChanged();
						}
					})
					.setNegativeButton("取消", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							insert("unknown", intent.getIntExtra("score", 0)+"");
							Log.i("wy", "插入成功");
							listRank = getAllRank();
							rank();
							adapter.notifyDataSetChanged();
						}
					}).show();
		}
	}
```

4.连接数据库PlaneDbHelper

```java
public class PlaneDBHelper extends SQLiteOpenHelper {
	static final String ID = "_id";
	static final String NAME = "name";
	static final String SCORE = "score";
	static final String TABLE = "rank";

	public PlaneDBHelper(Context context, String name, CursorFactory factory,
						 int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table if not exists " + TABLE + "(" + ID + " integer primary key," + NAME + " varchar(16),"
				+ SCORE + " varchar(5))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
```

5.将数据排序并将数据从数据库取出

```java
private List<Map<String,String>> getAllRank(){
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(dbHelper.TABLE, null, null, null, null, null, null);
		listRank.clear();
		if(cursor != null){
			Log.i("wy", "记录:"+cursor.getCount());
			if(cursor.moveToFirst()){
				while(!cursor.isAfterLast()){
					Map<String, String> map = new HashMap<String, String>();
					map.put("_id", cursor.getInt(cursor.getColumnIndex(dbHelper.ID))+"");
					map.put("name", cursor.getString(cursor.getColumnIndex(dbHelper.NAME)));
					map.put("score", cursor.getInt(cursor.getColumnIndex(dbHelper.SCORE))+"");
					listRank.add(map);
					cursor.moveToNext();
				}
			}
		}else{
			Log.i("wy", "没有记录");
		}
		return listRank;
	}

	private void insert(String name,String score){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("score", score);
		db.insert(dbHelper.TABLE, null, values);
	}

	private void rank(){
		for(int i = 0;i < listRank.size();i++){
			for(int j = i;j < listRank.size();j++){
				if(Integer.parseInt(listRank.get(i).get("score")) < Integer.parseInt(listRank.get(j).get("score"))){
					Map<String,String> temp = listRank.get(i);
					listRank.set(i, listRank.get(j));
					listRank.set(j, temp);
				}
			}
		}
		for(int i = 0; i < listRank.size(); i++){
			listRank.get(i).put("enemyDestroyedNum", (i+1)+"");//设定名次
		}
	}
```

6、ranklist.xml取得数据

```xml
    <TableRow
        android:layout_marginStart="12dp"
        android:layout_marginEnd="12dp">
        <TextView android:id="@+id/txt_id" android:textColor="@color/white" android:textSize="25sp" android:gravity="center"/>
        <TextView android:id="@+id/txt_name" android:textColor="@color/white" android:textSize="25sp" android:gravity="center"/>
        <TextView android:id="@+id/txt_score" android:textColor="@color/white" android:textSize="25sp" android:gravity="center"/>
    </TableRow>
```
7、activity_rank.xml展示数据

```xml
    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:fontFamily="@font/font0"
        android:gravity="center"
        android:text="@string/rank"
        android:textColor="#FFFFFF"
        android:textSize="45sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TableLayout
        android:id="@+id/rank_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        android:stretchColumns="0,1,2"
        android:layout_below="@id/textView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView">

        <TableRow>

            <TextView
                android:gravity="center"
                android:text="@string/num"
                android:textColor="@color/white"
                android:textSize="20sp" />

            <TextView
                android:gravity="center"
                android:text="@string/name"
                android:textColor="@color/white"
                android:textSize="20sp" />

            <TextView
                android:gravity="center"
                android:text="@string/score"
                android:textColor="@color/white"
                android:textSize="20sp" />

        </TableRow>

    </TableLayout>
    <ListView
        android:layout_below="@id/rank_title"
        android:id="@+id/lv_rank"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:orientation="vertical"
        app:layout_constraintTop_toBottomOf="@+id/rank_title" />
```xml

8、测试结果

# 四、实验结果

![实验5截图](./lab/lab5.png)
![实验5截图2](./lab/lab5(2).png)

# 五、实验心得

本次实验是存储编程，游戏app一般会用到的有排行榜，存档，本次实验做的是排行榜，需要使用到数据库，布局则需要使用到tablelayout，完成实验需要花较多的时间和耐心，我也在本次实验中对as有了更深的了解。