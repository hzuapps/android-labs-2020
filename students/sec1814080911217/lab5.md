# Android存储编程 
## 一、实验目的  
1、了解Andoid的存储手段  
2、掌握Android的文件存储  
3、掌握Android的数据库存储  
## 二、实验内容  
1、将应用产生的数据保存到文件存储中  
2、说明使用的文件存储方式：外部  
3、将运行结果截图  
## 三、实验步骤 
1、在主页面创建本地文件
```
public static File  file = new File("/storage/emulated/0/test/","record.txt");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(thisActivity);
        try {
            Sec1814080911217Activity.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
```
2、赚取和使用积分时，将对应的记录写入record.txt文件里。示例：
```
Earn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view1) {
                try {
                    Sec1814080911217Activity.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                toast1.show();
                Sec1814080911217Activity.h=Sec1814080911217Activity.h+10;
                try {
                    FileInputStream fis = new FileInputStream(Sec1814080911217Activity.file);
                    StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    br.close();
                    String result = stringBuilder.toString();
                    FileOutputStream fos = new FileOutputStream(Sec1814080911217Activity.file);
                    fos.write((result+"完成签到，积分+10").getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
        });
```
```
Exchange1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view1) {
                if(Sec1814080911217Activity.h>=1000)
                {
                toast2.show();
                try {
                    Sec1814080911217Activity.file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Sec1814080911217Activity.h=Sec1814080911217Activity.h-1000;
                try {
                    FileInputStream fis = new FileInputStream(Sec1814080911217Activity.file);
                    StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(inputStreamReader);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    br.close();
                    String result = stringBuilder.toString();
                    FileOutputStream fos = new FileOutputStream(Sec1814080911217Activity.file);
                    fos.write((result+"兑换英雄瑞文，积分-1000").getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                else
                {toast1.show();};
            }

        });
```
3、在积分记录Activity中将record.txt读出
```
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        String result=null;
        TextView textView=(TextView)findViewById(R.id.t);
        try {
            FileInputStream fis = new FileInputStream(Sec1814080911217Activity.file);
            StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            br.close();
            result = stringBuilder.toString();
            textView.setText(result);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
```

## 四、实验结果  
![result](https://raw.githubusercontent.com/1364480222/android-labs-2020/master/students/sec1814080911217/lab5.png)

## 五、实验心得  
这一次实验的内容较为困难实现。我用的是用本地文件记录对应记录，为了让赚取和使用积分的记录并在一起，在主界面上创建文件，并用另一个按钮查看。
到了赚取和兑换的Activity，要调用record.txt相对来说就比较困难。还好最后实现了。
