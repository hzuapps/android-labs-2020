package edu.hzuapps.androidlabs.net1814080903211.components;

import androidx.annotation.Nullable;

public class ChatObject {
    String name;
    String type;
    @Nullable
    String extraInfo;

    public ChatObject(String name, String type, @Nullable String extraInfo) {
        this.name = name;
        this.type = type;
        this.extraInfo = extraInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Nullable
    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(@Nullable String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
