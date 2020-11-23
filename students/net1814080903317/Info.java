package com.example.foundit.model.bean;

import java.sql.Timestamp;

/**
 * author: djx
 * created on: 2020/11/3 8:50
 * description:
 */
public class Info {
    private Integer id;
    private String type;
    private String state;
    private String content;


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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", content='" + content + '\'' +

                '}';
    }
}
