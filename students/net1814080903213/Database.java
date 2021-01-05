package com.example.facewords_java;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Word.class}, version = 1)
public abstract class Database extends RoomDatabase {
    private static final String DATABASE_NAME = "Facewords_db";

    private static Database databaseInstance;

    public static synchronized Database getInstance(Context context) {
        if (databaseInstance == null) {
            databaseInstance = Room
                    .databaseBuilder(context.getApplicationContext(), Database.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return databaseInstance;
    }

    public abstract WordDao wordDao();
}
