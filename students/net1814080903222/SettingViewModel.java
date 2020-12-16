package edu.hzuapps.androidlabs.net1814080903222.ui.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903222.components.storage.ExcludeItem;
import edu.hzuapps.androidlabs.net1814080903222.components.storage.ExcludeItemDatabase;
import edu.hzuapps.androidlabs.net1814080903222.components.storage.StorageHelper;

public class SettingViewModel extends ViewModel {

    private final ExcludeItemDatabase db;

    public SettingViewModel() {
        db = StorageHelper.getInstance().getDatabase();
    }

    LiveData<List<ExcludeItem>> getExcludeList() {
        return db.excludeItemDao().getAll();
    }
}