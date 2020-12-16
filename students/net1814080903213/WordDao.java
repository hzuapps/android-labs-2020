package com.example.facewords_java;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    public void insertWords(Word... words);

    @Query("SELECT * FROM Word")
    public List<Word> getWordList();
}
