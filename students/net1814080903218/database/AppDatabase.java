package edu.hzuapps.androidlabs.net1814080903218.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.hzuapps.androidlabs.net1814080903218.dao.ReasonDao;
import edu.hzuapps.androidlabs.net1814080903218.dao.SportDao;
import edu.hzuapps.androidlabs.net1814080903218.entity.Reason;
import edu.hzuapps.androidlabs.net1814080903218.entity.Sport;

@Database(entities = {Reason.class, Sport.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ReasonDao getReasonDao();
    public abstract SportDao getSportDao();
}
