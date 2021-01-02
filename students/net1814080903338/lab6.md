# 一、实验目标
1. 掌握数据库操作方法
2. 掌握界面设计方法

# 二、实验内容
1. 更加主页面组件
2. 修改读界面内容
3. 增加修改和删除功能

# 三、实验步骤
1. 删除主页面中修改按钮
2. 在读界面中增加详情按钮，并跳转到详情界面
```java
for (int i = 0; i < userSize; i++) {
                User user = userList.get(i);
                tableRow = new TableRow(this);

                textView = new TextView(this);
                textView.setTextSize(18);
                textView.setText(user.getText());
                tableRow.addView(textView);
                
                Button button_revise = new Button(this);
                button_revise.setText("详情");
                button_revise.setTextSize(18);
                button_revise.setId(user.getId());//设置按钮的id就是用户的id
                button_revise.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ReadActivity.this,
                                ReviseActivity.class);
                        int j = view.getId();
                        intent.putExtra("data",j+"");
                        startActivity(intent);
                    }
                });
```
3. 添加删除和修改功能，删除或修改对应记录。
```java
button_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String text = editText_revise.getText() + "";
                userDao.dbUpdateText(id,text);
                Toast.makeText(
                        ReviseActivity.this,
                        "成功写入：" + text , Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(ReviseActivity.this,
                        ReadActivity.class);
                startActivity(intent);
            }
        });

userDao.dbDeleteUser(id);
```

# 四、实验结果
![详情界面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/%E8%AF%A6%E6%83%85%E9%A1%B5%E9%9D%A2.PNG)
![读界面面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/%E8%AF%BB%E9%A1%B5%E9%9D%A2.PNG)

# 五、实验心得
本次实验继续修改APP的结构，对数据库进行操作，在实验过程中，最困难的便是在读界面中添加详情按钮跳转到详情界面时，在详情界面中输出对应记录的内容。好在通过网上的办法和不断尝试，解决了这个问题。
