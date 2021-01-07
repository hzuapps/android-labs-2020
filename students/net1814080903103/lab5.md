# 实验五
## 一、实验目标

1.	了解Andoid的存储手段
2.	掌握Android的文件存储
3.	掌握Android的数据库存储

## 二、实验内容

1.	将应用产生的数据保存到文件存储中
2.	说明使用的文件存储方式：内部 or 外部
3.	将运行结果截图

## 三、实验步骤

1.	保存图书信息
```xml
 findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });
```
2.	加载下一本书
```xml
findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextBook();
            }
        });
```
3.	保存图书信息
```xml
 private void saveBook() {
        String name = ((EditText) findViewById(R.id.book_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.book_tags)).getText().toString();

```
4.	插入新记录
```xml
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
5.	显示新记录
```xml
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

![主界面](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab5.png)

## 五、实验心得体会
由于这次实验没有用到存储的内容，所以使用了老师的例子，通过这次实验了解了关于android存储的知识和内容，但是还不够熟练使用，希望下次做的更好。
