# 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。



# 三、实验步骤

1. 编写文件协助类: FileHelper

   ```java
   package edu.hzuapps.browers;
   
   import android.content.Context;
   
   import java.io.FileInputStream;
   import java.io.FileOutputStream;
   import java.io.IOException;
   
   import edu.hzuapps.browers.bookmarks.Bookmark;
   
   /**
    * Created by lanying on 2020/11/30
    */
   public class FileHelper {
       private Context mContext;
   
       public FileHelper() {
       }
   
       public FileHelper(Context mContext) {
           super();
           this.mContext = mContext;
       }
   
       /*
        *  文件保存
        * */
       public void save(String filename, String filecontent) throws Exception {
           //私有模式,创建出来的文件只能被本应用访问,覆盖原文件
           FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
           output.write(filecontent.getBytes());  //字节流写入
           output.close();         //关闭输出流
       }
   
       /*
        * 文件读取
        * */
       public String read(String filename) throws IOException {
           // 打开文件输入流
           FileInputStream input = mContext.openFileInput(filename);
           byte[] temp = new byte[1024];
           StringBuilder sb = new StringBuilder("");
           int len = 0;
           // 读取文件内容:
           while ((len = input.read(temp)) > 0) {
               sb.append(new String(temp, 0, len));
           }
           // 关闭输入流
           input.close();
           return sb.toString();
       }
   
   }
   
   ```

2. 添加收藏按钮和点击事件

   添加按钮：

   ```xml
   <RelativeLayout style="@style/NavItem">
   
       <ImageView
           android:id="@+id/bookmark_collect"
           style="@style/NavIcon"
           android:layout_width="wrap_content"
           android:layout_height="31dp"
           android:src="@drawable/bookmark_collect" />
   </RelativeLayout>
   ```

   点击事件：将内容写入文件中，内容由网页内容决定（先写死）

   ```java
   public void onClick(View view) {
       switch (view.getId()){
           case R.id.address:
               Toast.makeText(Sec1814080911108Activity.this, "遇见爱情", Toast.LENGTH_SHORT).show();
               // 显式Intent
               Intent searchIntent = new Intent(Sec1814080911108Activity.this, SearchActivity.class);
               startActivity(searchIntent);
               break;
           case R.id.bookmarks:
               // 发出Toast
               Toast.makeText(Sec1814080911108Activity.this, "遇见爱情", Toast.LENGTH_SHORT).show();
               // 显式Intent
               Intent bookmarksIntent = new Intent(Sec1814080911108Activity.this, BookmarksActivity.class);
               startActivity(bookmarksIntent);
               break;
           case R.id.bookmark_collect:
               // 往文件中写入内容
               fileHelper = new FileHelper(mContext);
               String title = "服刑相当于住宾馆 狱中“帝王”牵出93名“保护伞。英特纳雄耐尔，就一定要实现。";
               try {
                   fileHelper.save("bookmark",title);
                   Toast.makeText(Sec1814080911108Activity.this, R.string.collect, Toast.LENGTH_SHORT).show();
               } catch (Exception e) {
                   Toast.makeText(Sec1814080911108Activity.this, R.string.fail, Toast.LENGTH_SHORT).show();
                   e.printStackTrace();
               }
               break;
       }
   }
   ```

3. 从文件中读取内容返回到ListView中

   ```java
   private void initBookmarks() throws IOException {
       fileHelper = new FileHelper(getApplicationContext());
   
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
   
       String strs = this.fileHelper.read("bookmark");
       if(!strs.isEmpty()){
           // 文件中有内容
           String[] titles = strs.split("。");
           for(String title : titles){
               Bookmark bookmark5 = new Bookmark(title,R.drawable.bookmark_icon);
               bookmarkList.add(bookmark5);
           }
       }
   
   }
   ```

   



# 四、实验结果

<img src="https://i.loli.net/2020/12/01/6q4AfebW8UzhQyo.png" alt="实验结果" style="zoom:80%;" />





# 五、实验心得

进行实验操作的过程比较顺利，需要注意的是可能抛出的异常和及时关闭输入和输出流。

在使用Context的`openFileInput()`和`openFileOutput()`打开文件输入输出流时，程序打开的都是app的数据文件夹中的文件。

