# 一、实验目标

1. 了解Android的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

# 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 使用内部存储将产生的数据保存到文件存储中；
3. 将运行结果截图。

# 三、实验步骤

1. 在 GameActivity 界面添加 Textview 用于显示历史最高记录；
2. 编写 read 函数在游戏界面启动后显示记录；
3. 编写 save 函数及其在游戏结束后是否执行写入的判断条件；
4. 完善选题的其他功能。

```
public String read(){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try{
            in=openFileInput("ASRS");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
    public void save(int fen){
        String data=Integer.toString(fen);
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            out=openFileOutput("ASRS",Context.MODE_PRIVATE);
            writer =new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer!=null){
                    writer.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
```

# 四、实验结果

![实验四结果](https://raw.githubusercontent.com/LookerSong/android-labs-2020/db845416896e11c13d5d70a1a3102e7a98ff0773/students/net1814080903230/E5.png)

# 五、实验心得体会

原本在游戏构思初期没有考虑到这个项目关于数据存储方面的必要，是中途加上了“历史最高得分”这一记录。在编写写入判断时出了错误，因为一开始没考虑到第一次游戏时记录为空，无法从中读取记录进行是否刷新记录的判断从而报错。

除此之外，这次实验还完善了界面间跳转返回的功能，实装了游戏得分区域大小和动图移动速度随设置界面改变的功能，以及游戏结束时的弹窗提示。离选题项目的完成又近了一步。
