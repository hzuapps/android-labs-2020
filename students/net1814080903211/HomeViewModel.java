package edu.hzuapps.androidlabs.net1814080903211.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import edu.hzuapps.androidlabs.net1814080903211.components.ChatObject;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<ChatObject>> mChatObjects;

    public HomeViewModel() {
        mChatObjects = new MutableLiveData<>();
        ChatObject[] raw_list = new ChatObject[]{
                new ChatObject("Test Item Person", "Person", "昨天晚上你去哪里了？"),
                new ChatObject("Test Item Room", "Room", "这家店还行吧。"),
                new ChatObject("Test Person 2", "Person", null),
                new ChatObject("Test Person 3", "Person", null),
                new ChatObject("Test Room 2", "Room", "今天有个通知"),
                new ChatObject("Test Room 3", "Room", null),
                new ChatObject("Test Person 4", "Person", null),
                new ChatObject("Test Room 4", "Room", "有没有你感兴趣的？"),
                new ChatObject("Test Person 5", "Person", null),
        };
        ArrayList<ChatObject> list = new ArrayList<>(Arrays.asList(raw_list));

        mChatObjects.setValue(list);
    }

    public LiveData<ArrayList<ChatObject>> getChatObjects() {
        return mChatObjects;
    }
}