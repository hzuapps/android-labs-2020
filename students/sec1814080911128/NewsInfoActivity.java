package edu.hzuapps.androidlabs.sec1814080911128;

public class NewInfoActivity {

    private String icon;    //图片路径
    private String title;   //新闻标题
    private String content;    //新闻描述
    private String type;    //新闻类型
    private long comment;   //新闻评论数

    public NewInfoActivity(String icon, String title, String content, String type, long comment) {
        this.icon = icon;
        this.title = title;
        this.content = content;
        this.type = type;
        this.comment = comment;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getComment() {
        return comment;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }
}