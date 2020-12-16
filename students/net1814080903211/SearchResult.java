package edu.hzuapps.androidlabs.net1814080903211.components;

import androidx.annotation.Nullable;

public class SearchResult {
    String title;
    @Nullable
    String extraInfo;

    public SearchResult(String title, @Nullable String extraInfo) {
        this.title = title;
        this.extraInfo = extraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(@Nullable String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
