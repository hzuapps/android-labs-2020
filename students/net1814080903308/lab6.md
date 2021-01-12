## 一、实验目标

- 掌握Android网络访问方法；
- 理解XML和JSON表示数据的方法。

## 二、实验内容

- 在个人目录中创建一个表示数据的XML或JSON文件；
- 数据文件代码提交之后从GitHub获取文件URL；
- 在应用中通过网络编程访问GitHub的数据文件；
- 在应用中解析并显示文件所包含的数据；
- 将应用运行结果截图。

## 三、实验步骤

- 修改MusicActivity.java和activity_music.xml  
  包含了两个菜单文件：Song1Activity.java（歌曲菜单）和Song2Activity.java（专辑菜单），默认情况下展示song1歌曲菜单,点击切换显示song2专辑菜单

```xml
    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerInParent="true"
        android:layout_marginEnd="28dp"
        android:layout_marginRight="28dp"
        android:layout_marginBottom="40dp"
        android:clickable="true"
        android:src="?android:attr/listChoiceIndicatorSingle"
        app:backgroundTint="#C1E6FF"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        tools:ignore="MissingConstraints"
        tools:visibility="visible" />
```
```java
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            content=(FrameLayout)findViewById(R.id.content);

            tv1=(TextView)findViewById(R.id.menu1);
            tv2=(TextView)findViewById(R.id.menu2);

            tv1.setOnClickListener(this);
            tv2.setOnClickListener(this);

            fm=getSupportFragmentManager();//若是继承FragmentActivity，fm=getFragmentManger();
            ft=fm.beginTransaction();
        ft.replace(R.id.content,new Song1Activity());//默认情况下Song1Activity
        ft.commit();
    }

```

- Song1Activity类是音乐列表界面，主要是创建onCreateView方法，参数分别为inflater（布局填充器），container(容器)，savedInstanceState(保存实例状态)。  
  首先声明一个变量view，用布局填充器的方法显示为music_list的布局文件，然后listView通过findViewById的方法，绑定lv布局文件中的对应控件。

```java
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.music_list,null);
        ListView listView=view.findViewById(R.id.lv);
        MyBaseAdapter adapter=new MyBaseAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(song1.this.getContext(),SingActivity.class);//创建Intent对象，启动check
                //将数据存入Intent对象
                intent.putExtra("name",name[position]);
                intent.putExtra("position",String.valueOf(position));
                startActivity(intent);
            }
        });
        return view;
    }
    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){return  name.length;}
        @Override
        public Object getItem(int i){return name[i];}
        @Override
        public long getItemId(int i){return i;}

        @Override
        public View getView(int i ,View convertView, ViewGroup parent) {
            View view=View.inflate(song1.this.getContext(),R.layout.item_layout,null);
            TextView tv_name=view.findViewById(R.id.item_name);
            ImageView iv=view.findViewById(R.id.iv);

            tv_name.setText(name[i]);
            iv.setImageResource(icons[i]);
            return view;
        }
    }
```

- activity_sing为音乐播放器界面，主要是歌曲图片、歌曲名和四个控制按钮

```xml
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btn_play"
            android:layout_width="0dp"
            android:layout_height="40dp"
            android:layout_margin="8dp"
            android:layout_weight="1"
            android:background="@drawable/btn_bg_selector"
            android:text="播放音乐" />

        <Button
            android:id="@+id/btn_pause"
            android:layout_width="0dp"
            android:layout_height="40dp"
            android:layout_margin="8dp"
            android:layout_weight="1"
            android:background="@drawable/btn_bg_selector"
            android:text="暂停播放" />

        <Button
            android:id="@+id/btn_continue_play"
            android:layout_width="0dp"
            android:layout_height="40dp"
            android:layout_margin="8dp"
            android:layout_weight="1"
            android:background="@drawable/btn_bg_selector"
            android:text="继续播放" />

        <Button
            android:id="@+id/btn_exit"
            android:layout_width="0dp"
            android:layout_height="40dp"
            android:layout_margin="8dp"
            android:layout_weight="1"
            android:background="@drawable/btn_bg_selector"
            android:text="退出" />
    </LinearLayout>

</LinearLayout>
```


## 四、实验结果
歌单界面  
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/sy6-1.jpg)  
播放界面  
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/sy6-2.png)  

## 五、实验心得
本次实验没有做网络编程，在原有的APP基础上继续优化，实现了播放界面、歌单界面、专辑界面的转跳，可能是安卓版本问题，播放音乐会闪退实现不了，接下来看看能不能解决问题，继续努力。
