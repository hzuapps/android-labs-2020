# 实验五

## 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、实验内容

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

## 三、实验步骤
1. 根据老师给的代码进行更改
2. 新建一个Activity将数据库的代码放入其中
3. 在Activity中重写相应的代码

存入数据库:
```

private void save_message(String id)
    {

            String thisid=id;
            String goods1=price1.getText().toString();
            ContentValues GOOD = new ContentValues();
           GOOD.put(Database.ID, thisid);
            GOOD.put(Database.goods1, goods1);
        Toast.makeText(getBaseContext(), "123 \n" , Toast.LENGTH_LONG).show();
             Uri uri = getContentResolver().insert(Database.CONTENT_URI, GOOD);
            Toast.makeText(getBaseContext(), "保存成功! \n" , Toast.LENGTH_LONG).show();
    }
```

读取数据库信息：
```
    private String showNextBook() {
        //String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(Database.CONTENT_URI, null, null, null, null);
        String showall="";
        // 随机取1条记录
        if(c.moveToFirst()){
        do {
            String name ;

            String goods;

            int count = 0;

                name = c.getString(c.getColumnIndex(Database.ID));
                //tags = c.getString(c.getColumnIndex(Database.Password));
                goods=c.getString(c.getColumnIndex(Database.goods1));
                showall=showall+name+goods;
            } while (c.moveToNext());}
            // 显示在界面上
            return  showall;
        }
        private void dele()
        {
           int i=getContentResolver().delete(Database.CONTENT_URI,null,null);
            Toast.makeText(getBaseContext(), "okk! \n" , Toast.LENGTH_LONG).show();
        }
```

 ## 四、实验结果
 [第五次实验图片](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/tesephoto/t5.jpg)  


## 五、心得体会
这次的实验内容是将数据传入数据库，这部分内容对于我来说比较困难，由于对于语句的不熟悉，代码经常写错，更改了很久。最后能将数据存入数据库，但有限制，会经常闪退。
