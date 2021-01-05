package edu.hzuapps.androidlabs.net1814080903319;

public class Message {
    private Integer id;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", singname='" + singname + '\'' +
                ", fangshi='" + fangshi + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSingname() {
        return singname;
    }

    public void setSingname(String singname) {
        this.singname = singname;
    }

    public String getFangshi() {
        return fangshi;
    }

    public void setFangshi(String fangshi) {
        this.fangshi = fangshi;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    private String singname;
    private String fangshi;
    private String singer;
}
