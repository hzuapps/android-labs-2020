#实验二 
##一、实验目标 
1. 自选题目，创建并且编写多个Activity，确立自己的主题以及功能； 
2. 在Android上修改代码，创建按钮使之能够进行页面的跳转功能。
##二、实验内容 
1.在Issues中创建自己的选题：确定自己的功能；
2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3.将标题设置为自己的学号+对应的功能或题目；’
4.在gitbash上进行代码提交。
##三、实验步骤 
1、创建主界面MainActivity、查找单词SearchActivity、标记单词MarkActivity；
2、布局界面有activity_main.xml、activity_punchtheclock.xml、activity_searchword.xml；
3、在activity_main.xml添加button1（管理闲置）、button2（发布闲置）；
在MainActivity中添加跳转代码如下;
      Button button_tiao1 = (Button) findViewById(R.id.button1);
        final MainActivity thisActivity1 = this;
        button_tiao1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent1 = new Intent(thisActivity1, MarkActivity.class);
                MainActivity.this.startActivity(Intent1);
            }
        });
        Button button_tiao2 = (Button) findViewById(R.id.button2);
        final MainActivity thisActivity2 = this;
        button_tiao2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent2 = new Intent(thisActivity2, SerachActivity.class);
                MainActivity.this.startActivity(Intent2);
            }
        });
    }
}
##四、实验结果


##五、实验心得 
   一开始我不太理解怎么做实验，后面通过问了同学，慢慢理解了按钮，即跳转代码怎么实现，后面模拟机一直没办法显现，重装之后就可以了，最后也用了手机作为真机去显现实验结果。
