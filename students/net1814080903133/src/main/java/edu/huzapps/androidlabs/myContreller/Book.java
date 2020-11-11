package edu.hzuapps.androidlabs.myContreller;

public class Book{
    String bookURL;
    String image;
    String bookName;
    String author;
    String nowChapter;
    Book(){};
    Book(String SetImage,String SetBookName,String SetAuthor,String SetNowChapter){
        image=SetImage;
        bookName=SetBookName;
        author=SetAuthor;
        nowChapter=SetNowChapter;
    }
    public void setDateil(String SetImage,String SetBookName,String SetAuthor,String SetNowChapter){
        image=SetImage;
        bookName=SetBookName;
        author=SetAuthor;
        nowChapter=SetNowChapter;
    }
    void setURL(String SetURL){
        bookURL = SetURL;
    }
    public String getBookName(){
        return bookName;
    }
}