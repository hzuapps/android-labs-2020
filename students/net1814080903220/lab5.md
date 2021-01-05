#  一、实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
#  二、实验内容
1. 使用文件内部存储方式
2. 在Net1814080903220EditActivity中点击保存按钮后，存储EditText框中的值
3. 保存完后在布局中读取存储后的数据
4. 存储的数据在界面中显示出来
#  三、实验步骤
1. 创建一个FileOutputStream对象,MODE_APPEND追加模式
2. 将获取过来的值放入文件
3. 关闭数据流
4. 创建一个FileInputStream对象，传入文件
5. 创建字符数组buff读取文件数据
6. 若文件数据大于0则返回字符串
```
private void save(String content){
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try{
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
```
```
mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(editText.getText().toString());
                mtvContent1.setText(read());
            }
        }
```
# 四、实验结果
![result5picture](https://raw.githubusercontent.com/JieBro333/android-labs-2020/844b1e4d8208f96dba40e2d5d9dfa6dff4cbf11f/students/net1814080903220/lab5result.png)
# 五、实验心得
  这次实验学会了如何在Android中实现存储数据，了解到有三种方式：一是文件存储，二是轻量存储、三是SQLite数据库存储，三种存储方式各有各的优势，文件存储和轻量存储比较适合存储简单量少的数据，而SQLlite适合存储比较复杂的结构性数据，在我这款app中，用文件存储方式就够了，实现方式也很简单，和JAVA差不多。
