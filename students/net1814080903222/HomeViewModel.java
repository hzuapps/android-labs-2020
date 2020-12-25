package edu.hzuapps.androidlabs.net1814080903222.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<FolderItem>> mList;

    public HomeViewModel() {
        mList = new MutableLiveData<>();
    }

    void setList(ArrayList<FolderItem> list) {
        mList.setValue(list);
    }

    public LiveData<ArrayList<FolderItem>> getText() {
        return mList;
    }
}