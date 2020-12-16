package edu.hzuapps.androidlabs.net1814080903222.components.storage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExcludeItemDao {
    @Query("SELECT * FROM ExcludeItem")
    LiveData<List<ExcludeItem>> getAll();

    @Insert
    void insertAll(ExcludeItem... items);

    @Delete
    void delete(ExcludeItem item);
}
