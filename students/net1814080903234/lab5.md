# 一、实验目标

1. 了解Andoid的存储手段用    
2. 掌握Android的文件存储


# 二、实验内容

1. 将应用产生的数据保存到文件存储中    
2. 说明使用的文件存储方式：内部 or 外部    
3. 结果截图  

# 三、实验步骤

1. 获取数据信息
```
//获取各个数据信息
final EditText nameET =(EditText)findViewById(R.id.name);
final EditText idET =(EditText)findViewById(R.id.neirong);
```
2. 触发按钮点击事件，将获取输入的信息
```
final Activity thisActivity = this;
Button login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //把获取到信息利用起来
                String name=nameET.getText().toString();
                String id=idET.getText().toString();
                FileOutputStream fos=null;
                //抛出异常
                try {
                    fos=openFileOutput("login",MODE_APPEND);
                    //把这些信息写入
                    fos.write((name+" "+id+" ").getBytes());
                    fos.flush();//刷新
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if(fos!=null){
                        try {
                            fos.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
                Intent intent =new Intent(thisActivity,DataActivity.class);
                thisActivity.startActivity(intent);//实现跳转
            }
        });
```

# 四、实验结果

# 五、实验心得
这次实验做的是文件储存，本来是想做SqLite数据库的，但是当储存数据后，出现闪退的情况，百度和问同学都解决不了这个问题 之后我便选择用文件储存来完成这实验

