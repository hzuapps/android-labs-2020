# 实验五：Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 使用文件外部存储方式
3. 运行结果截图。

## 三、实验步骤

1.  在PerformanceActivity添加

```java
protected void loadsdCard() throws IOException {


            // 判断SD卡是否存在
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

                // 目录
                File path = new File(PATH);
                // 文件
                File f = new File(PATH + FILENAME);
                FileInputStream fi = new FileInputStream(f);

                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len=fi.read(bytes))!=-1){
                    System.out.print(new String(bytes,0,len));
                }

            }
    }
```

2.在 PlanActivity 添加

```java
// 设置常量
    private final static String PATH = "/sdcard/fover";
    private final static String FILENAME = "/my_plan.db";


protected void sdCard() {

        try {
            // 判断SD卡是否存在
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            // 目录
                File path = new File(PATH);
            // 文件
                File f = new File(PATH + FILENAME);
                if (path.exists() && f.exists()) {
                    Toast.makeText(PlanActivity.this, "文件已经存在，不要再点了 。",
                            Toast.LENGTH_SHORT).show();

                } else {
            // 如果目录文件不存在就创建目录
                if (!path.exists()) {
                        path.mkdirs();
                }
            // 如果文件不存在就创建文件
                    if (!f.exists()) {

                        f.createNewFile();
                    }
                }
            // 异常捕捉
            }
        } catch (Exception e) {
            Log.d("Fover", "OH no write SDcard faild");
        }

    }
```





## 四、运行结果及截图

![实验五图片](https://github.com/zsc-do/android-labs-2020/blob/master/students/sec1814080911222/lab1-4/lab2(1).png)

![实验五图片](https://github.com/zsc-do/android-labs-2020/blob/master/students/sec1814080911222/lab1-4/lab2(2).png)

![实验五图片](https://github.com/zsc-do/android-labs-2020/blob/master/students/sec1814080911222/lab1-4/lab2(3).png)



## 五、实验心得

学会了如何调用文件管理器，获取权限，通过获取读写权限后最终完成了实验，了解了安卓的常见存储手段，对安卓外部存储有了更深的理解。