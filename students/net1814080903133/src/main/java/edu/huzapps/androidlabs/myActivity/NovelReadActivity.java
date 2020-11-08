package edu.hzuapps.androidlabs.myActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.myContreller.Book;
import edu.hzuapps.androidlabs.myContreller.BookManager;
import edu.hzuapps.androidlabs.myContreller.readViewpagerAdapter;
import edu.hzuapps.androidlabs.myView.readFragment;

public class NovelReadActivity extends AppCompatActivity {

    Intent intent;
    ViewPager2 readViewPager;
    int startIndex;
    BookManager bookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_read);

        intent = getIntent();
        int id = intent.getIntExtra("id",0);

        bookManager = BookManager.getBookManager();
        Book book = bookManager.getItem(id);

        setTitle("阅读界面\t\t\t\t\t\t"+book.getBookName());

        readViewPager = findViewById(R.id.readViewpager);
        readViewpagerAdapter readAdapter = new readViewpagerAdapter(this);
        startIndex=2;
        readAdapter.setOldPosition(startIndex);
        readViewPager.setAdapter(readAdapter);
        readViewPager.setCurrentItem(2);

       }
}