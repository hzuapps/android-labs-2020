## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

根据选题要求使用文件存储:
1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

## 三、实验步骤

1. 创造一个新的activity并命名为activity_file_storage.xml
2. 在activity_file_storage.xml中创造一个textView
3. 新建java类FileStorageActivity
4. 在FileStorageActivity类中写入下列代码

```java
public class FileStorageActivity extends AppCompatActivity {
    File file;
    final FileStorageActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text);

        ((Button)findViewById(R.id.button_save)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                file = new File ("D:/","lab5.txt");//1 this.getFilesDir()获取的是某个应用data/data/files的路径//this.getFilesDir().getParent()获取的是某个应用data/data/的路径
                try{
                    file.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        EditText text_date = (EditText) findViewById(R.id.text_date);
        String input_date = text_date.getText().toString();
        try{
            FileOutputStream fos = context.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
            fos.write("Hello World".getBytes());
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(input_date);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = context.openFileInput(file.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
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
    }
}
```
## 四、实验结果
![lab5](https://github.com/wuuuxj/android-labs-2020/tree/master/students/sec1814080911205/lab5.png)


## 五、实验心得
通过这次实验，我学会了安州的文件存储功能
