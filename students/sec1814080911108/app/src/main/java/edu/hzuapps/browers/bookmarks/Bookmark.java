package edu.hzuapps.browers.bookmarks;

/**
 * Created by lanying on 2020/11/17
 */
public class Bookmark {
    private String title;
    private int imageId;
    private String url;

    public Bookmark(String title, int imageId,String url) {
        this.title = title;
        this.imageId = imageId;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
