# 一、实验目标 

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容 

1. 根据功能创建相应的Activity
2. 编写AndroidManifest.xml
3. 编写Activity对应的布局文件
4. 编写Activity的Java代码
5. 使用Intent实现跳转

# 三、实验步骤 

1. 将创建的Activity注册到AndroidManifest.xml
2. 在页面中创建按钮，在主类中实现页面跳转：
```
    public class Net1814080903337Activity extends AppCompatActivity {
    
        public void Record(View view) {
        
            Intent intent = new Intent(this,RecordActivity.class);
            
            startActivity(intent);
            
        }
        
        public void Seek(View view) {
        
            Intent intent = new Intent(this,SeekActivity.class);
            
            startActivity(intent);
            
        }
        
        public void Overdue(View view) {
        
            Intent intent = new Intent(this,OverdueActivity.class);
            
            startActivity(intent);
            
        }
        
        @Override
        
        protected void onCreate(Bundle savedInstanceState) {
        
            super.onCreate(savedInstanceState);
            
            setContentView(R.layout.activity_net1814080903337);
            
        }
        
    }
   ```
# 四、实验结果 

![主页面](https://github.com/fairy-lee/android-labs-2020/blob/master/students/net1814080903337/picture/2.png)

![添加页面](https://github.com/fairy-lee/android-labs-2020/blob/master/students/net1814080903337/picture/3.png)

![搜索页面](https://github.com/fairy-lee/android-labs-2020/blob/master/students/net1814080903337/picture/4.png)

# 五、实验心得 
本次实验的内容是设置按钮并且实现页面跳转，比起上一个实验难度加大了一些，但也学习到了布局的知识。
