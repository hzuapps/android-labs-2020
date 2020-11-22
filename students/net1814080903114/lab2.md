# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；  
2. 利用Intent实现Activity间的跳转
## 二、实验内容
1.根据功能创建相应的Activity；
2.编写Activity对应的布局文件；
3.实现各个Activity之间的跳转
## 三、实验步骤
1. 创建Net1814080903114Activity、DeleteActivity、 AddActivity三个Activity
2. 添加跳转的按钮
3. 在 Net1814080903114Activity添加跳转事件
```java
public class Net1814080903114Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903114);
        Button but1=(Button)findViewById(R.id.add);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(Net1814080903114Activity.this,AddActivity.class);
                Net1814080903114Activity.this.startActivity(it);
            }
        });
        Button but=(Button)findViewById(R.id.delete);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(Net1814080903114Activity.this,CourseListActivity.class);
                Net1814080903114Activity.this.startActivity(it);
            }
        });
    }
}
```
## 四、实验结果
![](https://github.com/xukaiyue131/android-labs-2020/blob/master/students/net1814080903114/lab2.png)

## 五、实验心得
