package edu.hzuapps.androidlabs.myContreller;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book implements Serializable {

//Context
    Context context;
//    书本ID
    int id;
//    书本本地地址
    String bookURL;
//    书本本地图片地址
    String imageURL;
//    书名
    String bookName;
//    作者
    String author;
//    阅读进度
    int nowChapter = 0;
//    书本章节分页数据，结构为[章节首行偏移数（从1开始），章节首页数(从0开始)，章内页偏移量（从0开始）,章内页偏移量.....]
    ArrayList<ArrayList<Integer>> chapter = new ArrayList<>();
//    书本页数
    int pagerNUm;
//    是否初始化标志
    Boolean initState = false;
//    文件输入流
    BufferedReader bufferedReader;
//    章节数组
    ArrayList<String> i = new ArrayList<String>();
//    上一次章节
    int oldChapter = -1;
//    存放当前章节数据
    StringBuilder st = new StringBuilder();

//    构造函数，书本属性初始化
    Book(){}
    Book(String SetBookName,String SetAuthor,String SetImage,String SetURL,Context context) throws IOException {
        imageURL=SetImage;
        bookName=SetBookName;
        author=SetAuthor;
        bookURL = SetURL;
        this.context =context;
    }
//    初始化,将text文件分章处理
    public void initGetText() throws IOException {
//        临时存放字符串
        StringBuilder t = new StringBuilder();
        String st;
//        正则匹配章节标题
        Pattern p;
        Matcher m;
//        章节首行偏移数
        int tem2 = 0;
//        数组临时量
        ArrayList<Integer> tem3;

        p = Pattern.compile("第.*章");
        bufferedReader = MyTools.getBUffStream(bookURL,context);
        while ((st = bufferedReader.readLine()).equals("")){
            tem2++;
        };
        if (st!=null){

            m = p.matcher(st);
            t.append(st+"\n");
//            首行不是第。章格式处理
            if (m.lookingAt()){
                t.append(st+"\n");
            }
            tem3 = new ArrayList<Integer>();
            tem3.add(tem2-1);
            chapter.add(tem3);
            while ((st = bufferedReader.readLine())!=null){
                tem2++;
                m = p.matcher(st);
                if (m.lookingAt()||t.length()>8000){
                    i.add(t.toString());
                    t.replace(0,t.length(),st+"\n");
                    tem3 = new ArrayList<Integer>();
                    tem3.add(tem2);
                    chapter.add(tem3);
                    continue;
                }
                if (!st.equals(""))
                    t.append(st+"\n");
            }
            i.add(t.toString());
            bufferedReader.close();
        }
    }

//    get书本属性
//    id
    public int getId() {
        return id;
    }
    //    书名
    public String getBookName(){
        return bookName;
    }
//    作者
    public String getAuthor() {
        return author;
    }
//     图片地址

    public String getImageURL() {
        return imageURL;
    }
//    书本地址
    public String getBookURL() {
        return bookURL;
    }
    //     阅读进度
    public int getNowChapter() {
        return nowChapter;
    }
//    是否初始状态
    public Boolean getInitState(){
        return initState;
    }
//    书本页数数组
    public ArrayList<ArrayList<Integer>> getChapter(){return chapter;}
//    返回所求页面,第position章文字
    public String getText(int position) throws IOException {
        if (initState){
            String tem;
            int tem1 = 0;
            int oldpager;

//            将页数转化为章数
            while (tem1<getChaLength()&&chapter.get(tem1).get(1)<=position){
                tem1++;
            }
            tem1--;

            if (oldChapter!=tem1) {
                st.replace(0,st.length(),"");

                if (tem1<oldChapter||oldChapter==-1){
                    oldpager = 0;
//            重置bufferreader
                    if (bufferedReader!=null)
                        bufferedReader.close();
                    bufferedReader = MyTools.getBUffStream(bookURL,context);
                }else {
                    oldpager = chapter.get(oldChapter+1).get(0);
                }
                oldChapter=tem1;
//            跳过前面章节
                for (int i = oldpager;i<chapter.get(tem1).get(0);i++){
                    bufferedReader.readLine();
                }
//            判断是否为最后一章
                if (tem1==(getChaLength()-1)){
                    while ((tem=bufferedReader.readLine())!=null){
                        if (!tem.equals(""))
                            st.append(tem+"\n");
                    }
                }else {
                    for (int i =0;i<(chapter.get(tem1+1).get(0)-chapter.get(tem1).get(0));i++)
                        if (!(tem=bufferedReader.readLine()).equals(""))
                            st.append(tem+"\n");
                }
            }
//            获得当前页数偏移量
            int tem2;
            if (tem1==0){
                tem2 = position + 2;
            }else {
                tem2 = position - chapter.get(tem1).get(1)+2;
            }
            if (tem2==2){
               return st.substring(0,chapter.get(tem1).get(tem2));
            }else if (tem2==chapter.get(tem1).size()){
                return st.substring(chapter.get(tem1).get(tem2-1),chapter.get(tem1).get(tem2));
            }else {
                return st.substring(chapter.get(tem1).get(tem2-1),chapter.get(tem1).get(tem2));
            }
        }else {
            return i.get(position);
        }
    }
//    书本最大章节数
    public int getChaLength(){
        if (initState){
            return chapter.size();
        }else {
            return i.size();
        }
    }
//    书本最大页数
    public int getPagerNUm(){return pagerNUm;}
//    章节数组
    public ArrayList<String> getI(){return i;}

//    set书本属性

//    分页完成后计算最大页数并赋值
    public void setPagerNUm() {
        int num = 0;
        for (int i = 0;i<chapter.size();i++){
            num = num + chapter.get(i).size()-2;
        }
        this.pagerNUm = num;
    }
    public void setInitState(Boolean state){
        this.initState=state;
    }
    public void setNowChapter(int position){
        nowChapter = position;
    }
    public void setId(int id){this.id=id;}

    public void setChapter(ArrayList<ArrayList<Integer>> chapter) {
        this.chapter = chapter;
    }

    //    add书本属性
    public void addChapter(ArrayList<Integer> cha){
        chapter.add(cha);
    }
}