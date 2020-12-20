# **实验二** 

 

##   **一、实验目标** 

1. 创建自己的选题 

2. 编写相应的Activity（有n个功能就建立n+1个Activity）

   3.对应自己的选题的功能实现Activity中的功能

  

##    **二、实验内容** 

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ； 

   2.根据自选题目，编写多个Activity，在主窗口类带上学号前缀，放到自己的Java包下； 

3. 将标题设置为自己的学号+对应的功能或题目; 

4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

  

##    **三、实验步骤** 

1. 创建 MainActivity.java(主界面)、GameSceneActivity.java(游戏界面)、FailGameSceneActivity.java(游戏失败界面)；

2. 将创建的 Activity 注册到 AndroidManifest.xml 中；

3. 在布局文件中创建 Button 组件；

4. 为 Button 添加点击事件处理；

5. 通过 MainActivity(Intent) 实现界面跳转**

  

##    **四、 实验代码**

1.MainActivity.java

```
public class MainActivity extends AppCompatActivity {

​```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final MainActivity thisActivity = this;

    Button BtnStart=(Button)findViewById(R.id.button_start);

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_start:
                    Intent intent = new Intent(MainActivity.this,GameSceneActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
​```

}
```

2.GameSceneActivity.java

```
public class GameSceneActivity extends AppCompatActivity {

​```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game_scene);
}
​```

}
```

3.FailGameSceneActivity.java

```
public class FailGameSceneActivity extends AppCompatActivity {

​```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fail_game_scene);
}
​```

}
```

##    **五、实验结果** 

  ![实验结果](https://github.com/1nnocent1/android-labs-2020/blob/master/students/sec1814080911125/lab2.png) 

  

##    **六、实验心得**

  第二次实验是根据自己所选的题目创建几个功能的Activity,然后在主Activity中使用Intent实现各个Activity的跳转。

