package edu.hzuapps.androidlabs.net1814080903222.components.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ExcludeItem.class}, version = 1)
public abstract class ExcludeItemDatabase extends RoomDatabase {
    public abstract ExcludeItemDao excludeItemDao();
}
