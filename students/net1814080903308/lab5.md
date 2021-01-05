# 一、实验目标

1.了解Andoid的存储手段用    
2.掌握Android的文件存储    
3.将应用运行结果截图   

# 二、实验内容
1.将应用产生的数据保存到文件存储中    
2.说明使用的文件存储方式：内部 or 外部    
3.将运行结果截图  

# 三、实验步骤
1.获取数据信息  
```
  private void initView() {
        //关联控件
        Title = findViewById(R.id.title);
        Text = findViewById(R.id.text);
    }
```
2.按钮获取方法。    
```
<Button
   android:id="@+id/save"
   android:layout_width="100dp"
   android:layout_height="wrap_content"
   android:layout_weight="1"
   android:onClick="save"
   android:text="@string/state"
   android:textSize="20dp" />
   
   //方法
    public void save(View view) {
        //当内容不为空时
        if(!TextUtils.isEmpty(Title.getText()) && !TextUtils.isEmpty(Text.getText())){
            FileOutputStream fos = null;
            try {


                //Context中的方法openFileOutput()，获取一个FileOutputStream对象
                fos = openFileOutput("data", Context.MODE_PRIVATE);
                String str = Title.getText().toString().trim() + "#" + Text.getText().toString().trim();
                fos.write(str.getBytes());
                Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();



            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            Toast.makeText(getApplicationContext(), "请输入内容", Toast.LENGTH_SHORT).show();
        }
    }
``` 
3.利用Context中的openFileInput()方法获取输入流    
```
    FileInputStream data = openFileInput("data");
    BufferedReader reader = new BufferedReader(new InputStreamReader(data));
    String line = reader.readLine();
    String[] split = line.split("#");
    Title.setText(split[0]);
    Text.setText(split[1]);
``` 

# 四、实验结果
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/5-1.jpg)  
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/5-2.jpg)
# 五、实验心得
本次实验要用到存储，做起来比较困难，后面把精力放在其他科目了，导致实验拖了很久，仔细研究了一下开发者文档，终于完成了实验
