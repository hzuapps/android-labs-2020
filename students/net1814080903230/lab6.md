# 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

# 二、实验内容

1. 未应用到本次网络编程实验的内容，完善自身选题项目；
2. 获取平移动画的实时坐标；
3. 设置得分判定及游戏结束条件；
4. 将运行结果截图。

# 三、实验步骤

1. 参考网站相似问题的解决办法及讨论；

https://stackoverflow.com/questions/28537655/is-it-possible-to-get-real-time-coordinates-of-an-imageview-while-it-is-in-trans

2. 使用 ObjectAnimator 方法替换原本的平移动画方法 TranslateAnimation；
```
        ImageView myimage = (ImageView)findViewById(R.id.imageView);
        ObjectAnimator translateXAnimation= ObjectAnimator.ofFloat(myimage, "translationX", 0f, 1050f);
        ObjectAnimator translateYAnimation= ObjectAnimator.ofFloat(myimage, "translationY", 1000f, 1000f);
        translateXAnimation.setInterpolator(new LinearInterpolator());
        translateXAnimation.setRepeatMode(ValueAnimator.REVERSE);
        translateXAnimation.setRepeatCount(ValueAnimator.INFINITE);
        translateYAnimation.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(movetime);
        set.playTogether(translateXAnimation, translateYAnimation);
        set.start();

        translateXAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float imageXPosition = (Float) animation.getAnimatedValue();
                aaa[0] =imageXPosition;
            }
        });
```

3. 获取实时坐标与有效区域左右端坐标做得分判断。
```
        buttonScore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if((600 <= aaa[0]) && (aaa[0] <= setright)) {
                    fen += 10;
                }
                else {
                    dialog.show();//显示对话框
                    dialog.setCancelable(false);//点击对话框外区域（及返回键）无效
                }
                displayScore.setText(Integer.toString(fen));
            }
        });
```

# 四、实验结果

![实验六结果](https://raw.githubusercontent.com/LookerSong/android-labs-2020/fefd6864a301efa065664fd182835b1f58ea9769/students/net1814080903230/E6.png)

# 五、实验心得体会

在之前的几次实验就实现了让图片动起来，但当我尝试获取图片的坐标时发现一直是固定的坐标值，因此我怀疑图片只是看起来在移动，但实际上并没有改变坐标。带着疑问我百度了相关的问题关键词，但一直没有找到合适的解决办法。直到在课堂上向老师请教，老师找到一篇外文论坛的相关讨论，并跟着学习后才解决这一问题。

原来使用TranslateAnimation，动画的视图不会真正在屏幕上改变其原始位置，而只是使其看起来像在移动，所以视图基本上不会更改其坐标。而使用ObjectAnimator，其视图就可以更改自身实际位置。于是我选择了后者实现平移动画，一直困扰我的问题终于解决了。
