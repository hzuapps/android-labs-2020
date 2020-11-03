# 一、实验目标
1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能(选做);
# 二、实验内容
1. 自定义选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）;
# 三、实验步骤
1. 在https://github.com/hzuapps/android-labs-2020/issues 下提交自选题“QQ网络通信”；
2. 打开Android Studio,在java包下创建三个相关功能Activity；
Net1814080903234Activity.java
ContactActivity.java
DynamicActivity.java
3. 在Net1814080903220MainActivity的layout文件中设置两个按钮,分别为Contact、Dynamic按钮
4. 在Net1814080903220MainActivity.java中创建按钮对象btnCon和btnDyn
5. 使用findViewById方法引用布局文件中的对应按钮(按钮id分别为net_con1、net_dyn1)，使得在写.java的按钮时能与布局文件里的一致；
6. 设置Contact、Dynamic按钮点击事件；
7. 创建intent跳转对象，使用显式方法Intent(源Activity.this,目标Activity.class)；
8. startActivity(intent)实现点击跳转
```
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903234Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903234);

        final Activity thisActivity = this;

        Button btnCon = (Button) findViewById(R.id.net_con1);
        btnCon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ContactActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button btnDyn = (Button) findViewById(R.id.net_dyn1);
        btnDyn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(thisActivity,DynamicActivity.class);
                thisActivity.startActivity(intent1);
            }
        });

    }
}
```
# 四、实验结果
 ![lab2_mian](https://raw.githubusercontent.com/jun-stack/android-labs-2020/master/students/net1814080903234/lab2.png)

# 五、实验心得
1. 遇到的问题：
做实验二的时候刚接触Android studio,许多操作都不熟练，其中比较严重的问题是findViewById没有转换成Button控件类型
2. 解决方法
通过网上查资料，看视频，一步步跟着学习，慢慢熟练
