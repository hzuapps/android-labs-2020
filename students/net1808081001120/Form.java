package edu.hzuapp.androidlabs.net1808081001120.pojo;

import java.util.Date;

public class Form {
    private Integer id;
    private String date;

    public Form() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
