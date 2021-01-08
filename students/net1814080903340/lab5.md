# 实验五

## 1.实验目标
1.	了解Andoid的存储手段
2.	掌握Android的文件存储
3.	掌握Android的数据库存储

## 2.实验内容
1.	将应用产生的数据存储到数据库中；
2.	将应用运行结果截图。


## 3.实验步骤
修改了activity_easy.xml , activity_middle.xml , activity_high.xml ，由原本横排的数字键变成了九宫格的数字键，以便后面填写数独时触发弹出的窗口美观。
```java
           <TableLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
        <TableRow>
            <Button
                android:id="@+id/bt1"
                android:text="1"
                android:textSize="24sp"
                />
            <Button
                android:id="@+id/bt2"
                android:text="2"
                android:textSize="24sp"
                />
            <Button
                android:id="@+id/bt3"
                android:text="3"
                android:textSize="24sp"
                />
        </TableRow>
        <TableRow>
            <Button
                android:id="@+id/bt4"
                android:text="4"
                android:textSize="24sp"
                />
            <Button
                android:id="@+id/bt5"
                android:text="5"
                android:textSize="24sp"
                />
            <Button
                android:id="@+id/bt6"
                android:text="6"
                android:textSize="24sp"
                />
        </TableRow>
        <TableRow>
            <Button
                android:id="@+id/bt7"
                android:text="7"
                android:textSize="24sp"
                />
            <Button
                android:id="@+id/bt8"
                android:text="8"
                android:textSize="24sp"
                />
            <Button
                android:id="@+id/bt9"
                android:text="9"
                android:textSize="24sp"
                />
        </TableRow>
</TableLayout>


</TableLayout>


```
## 4.实验结果
![截图](https://github.com/88hua/android-labs-2020/blob/master/students/net1814080903340/test05.JPG)

## 5.实验心得
本次实验我把我项目三个填写数独时触发的界面进行了改动，将横排的数字键变成了九宫格的数字键。
