package edu.hzuapps.androidlabs.net1814080903211.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.hzuapps.androidlabs.net1814080903211.ui.home.ChatObject;

@Database(entities = {ChatObject.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ChatObjectDao chatObjectDao();
}
