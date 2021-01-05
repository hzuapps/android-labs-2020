package edu.hzuapps.androidlabs.net1814080903211.database;

import android.content.Context;

import androidx.room.Room;

public class Database {
    private static final String DATABASE_NAME = "kChatPrototype";

    public static AppDatabase getFromContext(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
    }
}
