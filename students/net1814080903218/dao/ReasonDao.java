package edu.hzuapps.androidlabs.net1814080903218.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903218.entity.Reason;

@Dao
public interface ReasonDao {
    @Query("SELECT * FROM reason")
    List<Reason> getAll();

    @Insert
    void insert(Reason reason);

    @Query("delete from reason")
    void deleteAll();
}
