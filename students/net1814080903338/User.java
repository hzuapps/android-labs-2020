package edu.hzuapps.model;


public class User {
    private int id;
    private String text;
    private String mood;
    private int isDel;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }
    public int getIsDel() {
        return isDel;
    }
    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }


}