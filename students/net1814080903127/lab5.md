# 一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
# 二、实验内容
1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。
# 三、实验步骤
1. 创建DBHelper类，包含创建数据库以及对数据库的增删改查等方法
```java
    public DBHelper(Context context) {
        super(context, "text_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table text(" +
                "id integer primary key autoincrement," +
                "title varchar(20)," +
                "context varchar(100)," +
                "date Date)";
        sqLiteDatabase.execSQL(sql);

    }
        //增加
    public void adddata(SQLiteDatabase sqLiteDatabase,String title,String context,String date)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",title);
        contentValues.put("context",context);
        contentValues.put("date",date);
        sqLiteDatabase.insert("text",null,contentValues);
        sqLiteDatabase.close();
    }
    ...
```
2. 创建Note类，包含笔记的属性如标题、内容、时间，以及对笔记的属性的获取、设置的方法

3. 使用ListView显示笔记，故创建一个数据适配器NoteAdapter类，继承BaseAdapter类并重写其方法，建立数据源与ListView之间的适配关系，再单独为单条笔记做一个布局list.xml
```java
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            //每一项的layout
            convertView=layoutInflater.inflate(R.layout.list,null);
            //包装listitem中的项
            helper=new Helper(convertView);
            convertView.setTag(helper);
        }
        else {
            helper= (Helper) convertView.getTag();
        }
        helper.title.setText(noteList.get(position).getTitle());
        helper.context.setText(noteList.get(position).getContext());
        helper.date.setText(noteList.get(position).getDate());
```
4. 修改便签编辑类AddActivity，新建或者修改便签都用同一个界面，利用Bundle类在主界面和编辑界面传输数据，传来的值‘id’决定新增数据或更新数据
```java
        Intent intent=this.getIntent();
        bundle=intent.getExtras();
        if(bundle!=null){//如果有其他的Activity传输数据，则获取id
            id=bundle.getInt("id");
            if(id!=0){
                addText.setText(bundle.getString("context"));
                addTitle.setText(bundle.getString("title"));
            }
        }
        
                DBHelper db=new DBHelper(AddActivity.this);
                SQLiteDatabase sqLiteDatabase=db.getReadableDatabase();
                if(id == 0){//新增数据
                    db.adddata(sqLiteDatabase,title,text,time);
                }else {
                    //更新数据
                    db.Update(sqLiteDatabase,id,title,text,time);
                }
```
5. 修改主界面的Net1814080903127Activity类，增加单条笔记点击事件，点击查看或修改
```java
        //表项点击事件
        textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemID=list.get(position).getId();
                textItem=list.get(position);
                textList.showContextMenu();
                Intent intent=new Intent(Net1814080903127Activity.this,AddActivity.class);
                Bundle bundle=new Bundle();
                String Update_Context=textItem.getContext();
                String Update_Title=textItem.getTitle();
                //传递数据
                bundle.putInt("id",itemID);
                bundle.putString("context",Update_Context);
                bundle.putString("title",Update_Title);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
```
# 四、实验结果
![lab5](https://github.com/cxcx75/android-labs-2020/blob/master/students/net1814080903127/lab5.png)
# 五、实验心得
本次实验学习了使用数据库存储文本，并显示文本，写了便签的建立、查看修改等功能，用数据库存储便签的标题、内容、建立时间等，比较难的是如何把数据库的内容放到LIstView中显示出来，上网查询相关资料和视频后得以解决，后面再把功能完善起来。
