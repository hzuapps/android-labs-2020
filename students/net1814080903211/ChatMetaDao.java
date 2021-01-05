package edu.hzuapps.androidlabs.net1814080903211.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903211.ui.chat.ChatMeta;

@Dao
public interface ChatMetaDao {
    @Query("SELECT sequence FROM chats " +
            "WHERE chats.channel = :channel " +
            "ORDER BY sequence ASC " +
            "")
    LiveData<List<ChatMeta>> getChatsFromChannel(String channel);

    @Query("SELECT * FROM chats " +
            "WHERE chats.channel = :channel " +
            "ORDER BY sequence DESC " +
            "LIMIT 1")
    ChatMeta getLatestFromChannel(String channel);

    @Insert
    void insertAll(ChatMeta ... chats);
}
