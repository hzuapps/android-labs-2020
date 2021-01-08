# 实验五
## 1.实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
## 2.实验内容
1. 将应用产生的数据保存到本地文件中；
2. 下次运行读取本地文件；
3. 将运行结果截图。
## 3.实验步骤
1. 在Net1814080903328Activity.java中设置强制要求输入队名；
```java
button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            //  @Override 
            public void onClick(View v){
                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。 
                //在存放资源代码的文件夹下下， 

                EditText editText = (EditText)findViewById(R.id.editText) ;

                String string = editText.getText().toString();
                if(TextUtils.isEmpty(string)){
                    Toast.makeText(Net1814080903328Activity.this,"请输入A队队名!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                EditText editText2 = (EditText)findViewById(R.id.editText2) ;

                String string2 = editText2.getText().toString();
                if(TextUtils.isEmpty(string2)){
                    Toast.makeText(Net1814080903328Activity.this,"请输入B队队名!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                //
                Intent i = new Intent(Net1814080903328Activity.this , ScoreActivity.class);

                i.putExtra("editText",string);
                i.putExtra("editText2",string2);

                //启动 
                startActivity(i);
            }
        });
```
2. 新增ScoreActivity.java，用于分数的增减；
```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        //这是新插入的代码
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding = DataBindingUtil.setContentView( this,R.layout.activity_score);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        TextView tv = (TextView)findViewById(R.id.textView2);
        TextView tv1 = (TextView)findViewById(R.id.textView5);
        Intent intent = getIntent();
        String data = intent.getStringExtra("editText");
        String data1 = intent.getStringExtra("editText2");
        tv.setText(data);
        tv1.setText(data1);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }
```
3.同时新增activity_score.xml，进行界面设计。
## 4.实验结果
![分数界面](https://raw.githubusercontent.com/Garfield-zheng/android-labs-2020/master/students/net1814080903328/score.jpg)
## 5.实验心得
  这次实验主要是在之前的基础上对自己的程序进行补充完善，除了在课上学到的知识，自己还去自学了一些以用于完成设计。
