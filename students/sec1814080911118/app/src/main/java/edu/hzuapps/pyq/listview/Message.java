package edu.hzuapps.pyq.listview;

public class Message {
    private String name;
    private int imageId;

    public Message(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return  imageId;
    }

}
