package edu.hzuapps.androidlabs.net1814080903222.components.storage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class ExcludeItem {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "item_path")
    private String itemPath;

    public ExcludeItem(@NotNull String itemPath) {
        this.itemPath = itemPath;
    }

    @NotNull
    public String getItemPath() {
        return itemPath;
    }

    public void setItemPath(@NotNull String itemPath) {
        this.itemPath = itemPath;
    }
}
