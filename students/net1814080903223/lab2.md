# 一、实验目标

 1.创建2-3个与自己选题有关的Activity；     
 2.利用Intent实现Activity间的跳转  

# 二、实验内容  
1.根据自己的选题功能，创建 3 个 Activity，分别是Net1814080903223Activity、PlayActiviy、ViewandmodifyActivity；      
2.在 Activity 上添加按钮，实现各个 Activity 的跳转；    
3.编写Activity对应的布局文件；    
4.在 Ne1814080903223Activity.java 添加按钮点击事件处理，实现跳转   

# 三、实验步骤  
1.创建相应的Activity和xml文件；    
2.在AndroidManifest.xml配置相关的信息;  
``` 
activity android:name=".Net1814080903223Activity"     
activity android:name=".PostActivity"   
activity android:name=".TreeholdActivity"  
``` 
3.在Net1814080903223Activity.java中添加跳转按钮的代码  
``` 
public class Net1814080903223Activity extends AppCompatActivity {  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_net1814080903223);  
        Button btn = (Button) findViewById(R.id.btn);  
        btn.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                Intent it = new Intent();  
                it.setClass(Net1814080903223Activity.this, PlayActivity.class);  
                Net1814080903223Activity.this.startActivity(it);  
            }    });  

        Button btn2= findViewById(R.id.btn2);  
        btn2.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                Intent it=new Intent();  
                it.setClass( Net1814080903223Activity.this, ViewandmodifyActivity.class);  
                Net1814080903223Activity.this.startActivity(it);  
            }    
        });  
    }  
}   
```   
# 四、实验结果
![实验结果](https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan201.jpg)
# 五、实验心得
在这次实验中我学会了使用按钮来进行界面跳转的操作，不过在过程中也遇到或按钮无反应等问题，在查找相关的资料后以及询问同学后发现有些大小写混淆了，在改正之后就顺利运行了。
