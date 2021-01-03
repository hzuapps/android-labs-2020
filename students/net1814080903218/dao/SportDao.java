package edu.hzuapps.androidlabs.net1814080903218.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903218.entity.Reason;
import edu.hzuapps.androidlabs.net1814080903218.entity.Sport;

@Dao
public interface SportDao {
    @Query("SELECT * FROM sport")
    List<Sport> getAll();

    @Insert
    void insert(Sport sport);

    @Query("delete from sport")
    void deleteAll();
}
