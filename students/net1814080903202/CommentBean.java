package edu.hzuapps.androidlabs.net1814080903202;

public class CommentBean {
    private String name;
    private String time;
    private String content;
    private int head;

    public CommentBean() {
    }

    public CommentBean(String name, String time, String content, int head) {
        this.name = name;
        this.time = time;
        this.content = content;
        this.head = head;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
