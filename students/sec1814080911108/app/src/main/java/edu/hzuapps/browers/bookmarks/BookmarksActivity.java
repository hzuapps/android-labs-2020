package edu.hzuapps.browers.bookmarks;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.browers.R;


public class BookmarksActivity extends AppCompatActivity {
    private String[] data = {
            "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"
    };
    private List<Bookmark> bookmarkList = new ArrayList<Bookmark>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_list);

        // 初始化书签数据
        initBookmarks();
        // ListView
        BookmarkAdapter adapter = new BookmarkAdapter(
                // 上下文，即当前的activity
                BookmarksActivity.this,
                // 一条数据都显示在这个View中
                R.layout.bookmark_item,
                // 需要显示的数据
                bookmarkList
        );
        ListView listView  = (ListView) findViewById(R.id.list_bookmarks);
        listView.setAdapter(adapter);
    }

    private void initBookmarks(){
        Bookmark bookmark = new Bookmark("太可怕了！女子睡前在床上做了这件事情，酿成惨剧",R.drawable.bookmark_icon);
        bookmarkList.add(bookmark);
        Bookmark bookmark1 = new Bookmark("震惊！朴槿惠终生未嫁原来是心系一个中国男人",R.drawable.bookmark_icon);
        bookmarkList.add(bookmark1);
        Bookmark bookmark2 = new Bookmark("李小璐三次拒绝PigOne，竟是为了这个人",R.drawable.bookmark_icon);
        bookmarkList.add(bookmark2);
        Bookmark bookmark3 = new Bookmark("2年前他为教育事业和高圆圆分手，今成这般，高圆圆：我有一句MMP如鲠在喉",R.drawable.bookmark_icon);
        bookmarkList.add(bookmark3);
        Bookmark bookmark4 = new Bookmark("某李姓程序员因过于帅气被潜规则，杨超越：悬赏50w捉拿凶手",R.drawable.bookmark_icon);
        bookmarkList.add(bookmark4);
    }
}