package edu.hzuapps.browers.bookmarks;

/**
 * Created by lanying on 2020/11/17
 */
public class Bookmark {
    private String title;
    private int imageId;

    public Bookmark(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
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
