package edu.hzuapps.androidlabs.myActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.IOException;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.myContreller.Book;
import edu.hzuapps.androidlabs.myContreller.BookManager;
import edu.hzuapps.androidlabs.myContreller.DatabaseHelper;
import edu.hzuapps.androidlabs.myContreller.readViewpagerAdapter;

public class NovelReadActivity extends AppCompatActivity {

//    ViewPager容器
    ViewPager2 readViewPager;
//    阅读进度,默认第一章节
    int startIndex=0;
//    获取本次活动书本实例
    Book book;
//    书本ID
    int id;
//    自动跳转函数
    Handler handler;
//    数据库操作类
DatabaseHelper databaseHelper;
//    设置阅读进度的状态
    Boolean fla;

    NovelReadActivity that = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_read);

        databaseHelper = DatabaseHelper.getData();

//        获取参数ID
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

//        获取本次活动书本实例
        BookManager bookManager = BookManager.getBookManager();
        book = bookManager.getItem(id);

        fla = book.getInitState();

        setTitle("阅读界面\t\t\t\t\t\t"+book.getBookName());

//        ViewPager绑定适配器
        readViewPager = findViewById(R.id.readViewpager);
        final readViewpagerAdapter readAdapter = new readViewpagerAdapter(this,book);
        readViewPager.setAdapter(readAdapter);

//        判断是否初始化进行不同处理
        if (book.getInitState()){
            if (book.getChapter().size()==0){
                book.setChapter(databaseHelper.getChapter(book.getId()));
                book.setPagerNUm();
                readAdapter.notifyDataSetChanged();
            }
            readViewPager.setCurrentItem(book.getNowChapter());
        }else {
//            分章处理
            try {
                book.initGetText();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            页数跳动，实现分页
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int item = readViewPager.getCurrentItem();
                    if ((item+1)<book.getChaLength()){
                        readViewPager.setCurrentItem(item+1);
                        handler.postDelayed(this,1);
                    }else {
                        handler = null;
//                    延时设置初始状态为true,并返回0页面
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
//                                将初始化标志设置为Ture
                                book.setInitState(true);
//                                设置总页数
                                book.setPagerNUm();
//                                设置当前阅读历史为0
                                book.setNowChapter(0);
//                                清除章节缓存
                                book.getI().clear();
//                                录入书籍进入数据库
//                                判断书本是否已存在
                                    databaseHelper.addBook(book.getBookName(),book.getAuthor(),book.getImageURL(),book.getBookURL(),book.getNowChapter(),book.getChapter());
                                    book.setId(databaseHelper.getId(book.getBookURL()));
//                                退出初始化Activity
                                finish();
                            }
                        }.start();
                    }
                }
            },10);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!fla){
            book.setNowChapter(0);
            databaseHelper.updateHistory(book.getId(),0);
        }else {
            int tem = readViewPager.getCurrentItem();
            book.setNowChapter(tem);
            databaseHelper.updateHistory(book.getId(),tem);
        }
    }

}