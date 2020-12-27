package edu.hzuapps.androidlabs.net1814080903211.ui.home;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;

import org.jetbrains.annotations.NotNull;

@Entity(
        tableName = "chat_list",
        primaryKeys = {"Name", "Type"}
)
public class ChatObject {
    @NotNull
    private String name;
    @NotNull
    private String type;

    private @Nullable @Ignore
    String extraInfo;

    public ChatObject(String name, String type) {
        this.name = name;
        this.type = type;
        this.extraInfo = null;
    }

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
