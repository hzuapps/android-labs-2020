# 实验五

## 一、实验目标
- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储
## 二、实验内容
- 将应用产生的数据保存到文件存储中
- 说明使用的偏好设置存储方式
- 将运行结果截图
## 三、实验步骤
1.在activity_create.xml中设置好文本输入框
 ```xml
   <EditText
        android:id="@+id/edit1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/s_name" />
 ```
2. 在CreateActivity.java中进行编程，实现文件存储功能，部分代码如下
 ```java   
   
        Button button1 = (Button) findViewById(R.id.button1);
        final File file = new File("D:lab5.txt");
        final Activity thisActivity = this;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

            EditText edit1 = (EditText) findViewById(R.id.edit1);
            String inputText = edit1.getText().toString();

        try{
                FileOutputStream fos = this.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
                fos.write("Hello World".getBytes());
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(inputText);
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
        try{
                FileInputStream fis = this.openFileInput(file.getAbsolutePath());
                StringBuilder stringBuilder = new StringBuilder();
                InputStreamReader inputStreamReader =
                        new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line = null;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line + "\n");
            }
                String result = stringBuilder.toString();
                System.out.println(result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
 ```
## 四、实验结果
![lab5](raw.githubusercontent.com/1728799039/android-labs-2020/master/students/sec1814080911234/lab5.png)
## 五、实验心得
本次实验是Android存储编程，我所做的app有多处需要用到存储功能，将文本输入框输入的数据获取到Activity中进行计算或是显示出来。这里只是参照着老师所给内容试着做一个，其他会在后面慢慢完善。
