package edu.hzuapps.androidlabs.entity;

public class shop {
    private Integer id;
    private String type;
    private Integer money;
    private String time;
    private String Note;


    public shop(Integer id, String type, String time,Integer money, String note) {
        this.id = id;
        this.type = type;
        this.money = money;
        this.time = time;
        Note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
