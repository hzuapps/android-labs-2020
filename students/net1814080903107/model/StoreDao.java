package com.example.thefirst.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StoreDao {
    @Query("SELECT * FROM STORE")
    public List<STORE> findAll();

    @Query("SELECT * FROM STORE WHERE storeID = :storeID")
    public List<STORE> findByStoreID(String storeID);

    @Insert(entity = STORE.class)
    public void save(STORE ... store);

    @Delete(entity = STORE.class)
    public void delete(STORE ... store);
}
