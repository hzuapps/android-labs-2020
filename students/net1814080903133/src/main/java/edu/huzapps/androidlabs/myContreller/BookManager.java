package edu.hzuapps.androidlabs.myContreller;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManager{
    static BookManager bookManager;
    static List<Book> bookList;
    private BookManager(){ }

//    单例模式获取
    public static BookManager getBookManager(){
        if (bookManager==null){
            bookManager = new BookManager();
        }
        if (bookList==null){
            bookList = new ArrayList<Book>();
        }
        return bookManager;
    }
//    添加书本
    public void addBook(String SetBookName, String SetAuthor, String SetImage, String SetURL, Context context) throws IOException {
            Book book = new Book(SetBookName,SetAuthor,SetImage,SetURL,context);
            bookList.add(book);
    }
    public void addBook(ArrayList<Book> bookArrayList){
        for (int i=0;i<bookArrayList.size();i++)
            bookList.add(bookArrayList.get(i));
    }
//    清除所有书本
    public void clear(){
    bookList.clear();
}
//    移除书本
    public void removeBook(int index){
        bookList.remove(index);
    }
//    打印全部书本
    public void showBookList(){
        int i=0;
        for(Book book:bookList){
            System.out.println((i++)+book.getBookName());
        }
    }
//    获取书本数量
    public int getSize(){
        return bookList.size();
    }
//    获取第index书本，从0开始
    public Book getItem(int index){
        return bookList.get(index);
    }
}