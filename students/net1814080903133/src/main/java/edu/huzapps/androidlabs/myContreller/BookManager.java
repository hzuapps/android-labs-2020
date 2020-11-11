package edu.hzuapps.androidlabs.myContreller;

import java.util.ArrayList;
import java.util.List;

public class BookManager{
    static BookManager bookManager;
    static List<Book> bookList;
    private BookManager(){ }

    public void clear(){
        bookList.clear();
    }

    public static BookManager getBookManager(){
        if (bookManager==null){
            bookManager = new BookManager();
        }
        if (bookList==null){
            bookList = new ArrayList<Book>();
        }
        return bookManager;
    }
    public void addBook(String SetImage,String SetBookName,String SetAuthor,String SetNowChapter){
        Book book = new Book(SetImage,SetBookName,SetAuthor,SetNowChapter);
        bookList.add(book);
    }
    public void removeBook(int index){
        bookList.remove(index);
    }
    public void showBookList(){
        int i=0;
        for(Book book:bookList){
            System.out.println((i++)+book.getBookName());
        }
    }
    public int getSize(){
        return bookList.size();
    }
    public Book getItem(int index){
        return bookList.get(index);
    }
}