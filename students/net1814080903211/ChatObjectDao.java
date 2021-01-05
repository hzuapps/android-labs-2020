package edu.hzuapps.androidlabs.net1814080903211.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903211.ui.home.ChatObject;

@Dao
public interface ChatObjectDao {
    @Query("SELECT * from chat_list")
    LiveData<List<ChatObject>> getAll();

    @Insert
    void insertAll(ChatObject... objects);

    @Delete
    void delete(ChatObject obj);
}
