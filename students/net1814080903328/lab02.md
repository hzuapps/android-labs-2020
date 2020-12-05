# 实验二 
  ## 一、实验目标 
  1. 根据自己的选题，创建2-3个Activity 
  2. 实现Activity间的跳转 

   ## 二、实验内容 
  1. 根据功能创建相应的Activity； 
  2. 编写Activity对应的布局文件； 
  3. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。

   ## 三、实验步骤 
  1. 创建 Net1814080903328Activity、RuleActivity(规则讲解界面)、SkillsActivity(技巧讲解界面)；
  2. 配置AndroidManifest.xml；
  3. 在相应的界面中创建 Button 组件；
  4. 为 Button 添加点击事件处理，实现跳转；
     ```java
      Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(thisActivity, RuleActivity.class);
                startActivity(intent);

            }
        });
     ```
     ```java
     button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(thisActivity, SkillsActivity.class);
                startActivity(intent);

            }
        });
     ```
   ## 四、实验结果 
  ![规则讲解界面截图](https://raw.githubusercontent.com/Garfield-zheng/android-labs-2020/master/students/net1814080903328/RuleInterface.PNG) 
  ![技巧讲解界面截图](https://raw.githubusercontent.com/Garfield-zheng/android-labs-2020/master/students/net1814080903328/SkillsInterface.PNG)

   ## 五、实验心得 
   在本次实验中，主要是根据自己的选题以及打算实现的功能创建Activity并通过button（按钮）实现页面间的跳转，以及AndroidMainfest的配置。完成过程比较顺利。
  在本次实验中，根据自己的选题功能创建了Activity，学习到了activity以及AndroidMainfest的配置。在Activity中添加相应的按钮实现不同界面之间的跳转。完成得相对顺利。
