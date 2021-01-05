# 实验五 Android存储编程

## 一、实验要求

1、了解Andoid的存储手段

2、掌握Android的文件存储

3、掌握Android的数据库存储

## 二、实验内容

1、根据选题要求使用文件存储

2、将应用产生的数据保存到文件存储中

3、说明使用的文件存储方式：内部 or 外部

4、将运行结果截图。

## 三、实验步骤

1、在点击保存的时候将玩家名字和得分保存在文件中

```java
    btnSavePlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveCurrentText();
                }
            });


    private void saveCurrentText(){
        try {
            OutputStream os=openFileOutput("Player", Context.MODE_PRIVATE);
            os.write(input1.getText().toString().getBytes("utf-8"));
            os.flush();
            os.close();
            OutputStream os2=openFileOutput("mark",Context.MODE_PRIVATE);
            os2.write(input2.getText().toString().getBytes("utf-8"));
            os2.flush();
            os2.close();
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
            return;

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
```

2、在rank中点击刷新调用文件中的内容

```java

    sx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    readSaveText();
                }
            });
        
    private void readSaveText(){

        try {
            InputStream is1=openFileInput("Player");
            byte[] bytes1=new byte[is1.available()];
            is1.read(bytes1);
            is1.close();

            InputStream is2=openFileInput("mark");
            byte[] bytes2=new byte[is2.available()];
            is2.read(bytes2);
            is2.close();

            String str1=new String(bytes1,"utf-8");
            Player1.setText(str1);
            String str2=new String(bytes2,"utf-8");
            mark1.setText(str2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
```

## 四、实验结果

![lab5(1)](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab5(1).png)
![lab5(2)](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab5(2).png)

## 五、实验心得

  这次实验我是使用了文件存储的方法，这种方法不需要导入数据库，相对比会比较简单，主要就是一个函数来存取需要保存的数据，并且把它放在手机内部的存储文件中，然后再调用显示出来文件中的内容。
