# 实验五：Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1.应用数据存储可采用数据库存储。
2.将应用产生的数据存储到数据库中；
3.将应用运行结果截图。


## 三、实验步骤
1 引入DBHelper 数据库备帮助类，创建数据库，插入、删除都在这里实现
2 在DatabaseActivity 中实现数据存放至数据库的方法
//DatabaseActivity
ContentValues values = new ContentValues();
values.put("name", Name);
values.put("telephone", Telephone);
values.put("email", Email);
DBHelper helper = new DBHelper(getApplicationContext());
helper.insert(values);
3 displayactivity中引用数据库对象
//simplecusoradapter
调用数据库对象生成Dbhelper对象helper，helper.queryAll()实现数据库查询并返回一个cursor对象。
使用simplecusoradapter绑定listview视图。利用simplecusoradapter init方法游标数据映射至布局文件中。
SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.display,c,from,to);
ListView listView=getListView();
listView.setAdapter(adapter);
//builder （对话框）
利用builder为每一个item设置点击事件
final String[] options = new String[] { "详细信息", "删除" ,"删除所有联系人"};
builder.setItems(options, new DialogInterface.OnClickListener() {
@Override
    public void onClick(DialogInterface dialog , int which) {
    switch (which) {
    //点击详细信息的动作
    case 0:
    //点击删除的动作
    case 1:
    //点击删除所有联系人的动作
    caase 2:
}
实现资源name在两个activity间的传送
//dispalyActivity
intent.putExtra("name",name);
//dispaly_detailsActivity
Intent intent=getIntent();
String name=intent.getStringExtra("name");
4.display_detailsActivity
//显示联系人详解信息，使用simplecusoradapter绑定listview视图。
final DBHelper helper=new DBHelper(this);
Cursor c = helper.queryName(name);//定义光标
String[] from={"_id","name","telephone","email","address"};
int[] to={R.id.id,R.id.name_2,R.id.telephone,R.id.email,R.id.address};
SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.display_details,c,from,to);
ListView listView=getListView();
//listview绑定数据适配器
listView.setAdapter(adapter);

# 四、运行结果及截图


#五、心得与体会
本次实验目的是实现数据库的存储，关键点是将联系人的数据保存至数据库，参考了网上的数据库帮助类Dbhelper以方便实现数据库创建，数据的插入与删除查询等功能。
本次实验的难点在于displayActivity中如何获取name资源以及name在displayActivity和display_detailsActivity间的传送。通过https://developer.android.google.cn/
网站adapterview的学习发现视图可以通过adpterview.getAdapter.getItem(i) 可以获取listview 点击第i个item的数据以SQLiteCursor的形式返回，然后通过游标的学习可以
知道SQLiteCursor.getString(columnidex:1)可以获取索引位置为1的数据name，然后利用intent.putExtra("name",name)，和intent.getStringExtra("name")完成name的传输。
