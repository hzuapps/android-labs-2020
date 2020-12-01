package edu.hzuapps.androidlabs.net1814080903127;

public class Note {
    private int id;
    private String title;
    private String context;
    private String date;

    public Note(int id,String title,String context,String date){
        this.id=id;
        this.title=title;
        this.context=context;
        this.date=date;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getContext(){return context;}
    public void setContext(String context){this.context=context;}
}
