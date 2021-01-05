# 第五次实验

## 1.实验目标
掌握在Android App中存储数据

## 2.实验步骤
（1）打开已建好的项目net1814080903223;      
      
（2）在playActivity加入文件储存功能,并通过startactivityforresult打开viewandmodifyActivity的进行游戏运算;       
```
  private void initHistoricalRecord()  //初始化记录
       {
           TextView textView = (TextView) findViewById(R.id.textview_history);
           String s = read();
           if(s!=null)
               refreshHistoricalRecord(s);
       }
       public String read() {   //读入存储数据
           try {
               FileInputStream inStream = this.openFileInput("message.txt");
               byte[] buffer = new byte[1024];
               int hasRead = 0;
               StringBuilder sb = new StringBuilder();
               while ((hasRead = inStream.read(buffer)) != -1) {
                   sb.append(new String(buffer, 0, hasRead));
               }
               inStream.close();
               return sb.toString();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return null;
       }
       public void write(String msg){   //写出存储数据
           // 步骤1：获取输入值
           if(msg == null) return;
           try {
               // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
               msg += read();  //前面的也读进来
               FileOutputStream fos = openFileOutput("storage.txt", MODE_APPEND);
               // 步骤3：将获取过来的值放入文件
               fos.write(msg.getBytes());
               // 步骤4：关闭数据流
               fos.close();
           } catch (Exception e) {
               e.printStackTrace();
        }
         }
          }
```  
（3）在viewmodifyActivity用setResult函数进行结果数据回传到playActivity中;    
```
 ret=xx.getText().toString()+" 因此 "+ret;
	        fanhui.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Intent data=new Intent();
	                data.putExtra("jieguo",ret);
	                setResult(2,data);
	                finish();
	            }
	        });
	        }
}
```
（4）在activity_play.xml的文件中创建一个TextView来显示每次通过viewandmodifyActivity传输回来的数据，并根据时间显示;    
```
<TextView
		            android:layout_width="match_parent"
		            android:layout_height="wrap_content"
		            android:textSize="15sp"
		            android:text="历史记录:"/>
		        <TextView
		            android:id="@+id/textview_history"
		            android:layout_width="match_parent"
		            android:layout_height="match_parent"
		            android:textSize="15sp"
		            android:textColor="#636363"/>
	    </LinearLayout>
```
（5）完成并运行成功;  

（6）用git上交。  

## 3.实验结果
![实验截图](https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan501.png)  
![实验结果](https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan502.png) 

## 4.实验体会
这次实验让我学会了简单的文件存储，和使用java.io输入输出流提供的方法来进行读写数据传输，并学会了两个activity之间互相传数据的用法。
