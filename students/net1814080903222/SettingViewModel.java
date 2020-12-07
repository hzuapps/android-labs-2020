package edu.hzuapps.androidlabs.net1814080903222.ui.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<ExcludeItem>> mExcludeList;

    public SettingViewModel() {
        mExcludeList = new MutableLiveData<>();
        ArrayList<ExcludeItem> demoList = new ArrayList<>(
                Arrays.asList(
                        new ExcludeItem("/Pictures/exclude/"),
                        new ExcludeItem("/Pictures/test-exclude/")
                )
        );
        mExcludeList.setValue(demoList);
    }

    LiveData<ArrayList<ExcludeItem>> getExcludeList() {
        return mExcludeList;
    }
}