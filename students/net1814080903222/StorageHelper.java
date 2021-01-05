package edu.hzuapps.androidlabs.net1814080903222.components.storage;

import android.content.Context;

import androidx.room.Room;

public class StorageHelper {
    private static ExcludeItemDatabase database;
    private static StorageHelper helper;

    public StorageHelper(Context context) {
        database = Room.databaseBuilder(context,
                ExcludeItemDatabase.class, "kGallery").build();
        helper = this;
    }

    static public StorageHelper getInstance() {
        return helper;
    }

    public ExcludeItemDatabase getDatabase() {
        return database;
    }
}
