# 一、实验目标

1. 了解Android的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

# 二、实验内容

1. 应用数据存储可采用数据库存储。
2. 将应用产生的数据存储到数据库中；
3. 将应用运行结果截图。

# 三、实验步骤

1. 修改了CountActivity，进行了记账本的账本记录的存储，利用里SQLite数据库存储。
2. 修改了CountActivity的布局文件，对计算器实现效果，进行了适当的修改。
3. 增加了一个shop的实体类，封装记账本记录的信息。

```java
// CountActivity部分代码
case R.id.tb_calc_num_done://确定
                // 添加数据
                times = (String) total_time.getText();
                type = (String) total_leibie.getText();
                node = total_note.getText().toString();
                money = (String) total_money.getText();

                db = myHelper.getWritableDatabase();// 写数据库
                values = new ContentValues();
                values.put("type", type);
                values.put("time", times);
                values.put("money", money);
                values.put("node", node);
                long information = db.insert("information", null, values); // 插入数据
                if (information>0)
                    Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
                db.close();
                countTotal++;
                break;
```
```java
// ShowActivity部分代码
    /**
     * 初始化数据
     */
    public void init() {
        db = myHelper.getReadableDatabase();
        Cursor cursor = db.query("information",null,null,null,null,null,null);

        while(cursor.moveToNext()){
            System.out.println(cursor.getInt(0)+ cursor.getString(1)+ cursor.getString(2)+ cursor.getInt(3)+cursor.getString(4));
            count+=cursor.getInt(3);
            Shop shop = new Shop(++num, cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4));
            map.put(num, shop);
            mapList.put(num, cursor.getInt(0));
        }

        cursor.close();
        db.close();
        num = 0;
    }
```
# 四、实验结果

# 五、实验心得
我的题目需要利用到了数据库存储，将记录的账本信息数据暂存到手机中，再之后利用条件进行所有的账本记录查询，并展示，缺点就是，代码都写在了一起，有点乱，之后再慢慢调整代码架构。
