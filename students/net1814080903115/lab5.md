# 实验五：Android存储编程

## 一、实验目标

1. 了解Andoid的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

## 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

## 三、实验步骤

1. 保存图书信息
```
findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });
```
2. 加载下一本书
```
findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextBook();
            }
        });
```
3. 保存图书信息
```
 private void saveBook() {
        String name = ((EditText) findViewById(R.id.book_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.book_tags)).getText().toString();
```
4. 插入新记录
```
  ContentValues book = new ContentValues();
        //book.put("name", name); // Map <- Key:Value
        book.put(ContentProviderOfBooks.NAME, name);
        book.put(ContentProviderOfBooks.TAGS, tags);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfBooks.CONTENT_URI, book);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showBookInfo("", ""); // 清除内容
    }

    private void showBookInfo(String name, String tags) {
        ((EditText) findViewById(R.id.book_name)).setText(name);
        ((EditText) findViewById(R.id.book_tags)).setText(tags);
    }
```
5. 显示新记录
```
private void showNextBook() {
        //String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfBooks.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(ContentProviderOfBooks.NAME));
                tags = c.getString(c.getColumnIndex(ContentProviderOfBooks.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showBookInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的图书!", Toast.LENGTH_LONG).show();
        }
    }
```

## 四、实验结果
![实验五图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab5.png)

## 五、实验心得

　　这次实验目的主要是让我们了解Android的存储手段，掌握Android的文件存储，掌握Android的数据库存储，因为我的选题不用用到这个功能，所以就做了老师给的练习。主要是熟悉运用这些存储功能，了解文件的存储方式还有读取文件的实现。
