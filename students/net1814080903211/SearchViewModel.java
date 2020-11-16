package edu.hzuapps.androidlabs.net1814080903211.ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import edu.hzuapps.androidlabs.net1814080903211.components.SearchResult;

public class SearchViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<SearchResult>> mResults;

    public SearchViewModel() {
        mResults = new MutableLiveData<>();
        ArrayList<SearchResult> list = new ArrayList<>(Arrays.asList(
                new SearchResult("Test Search Result", "这是一条额外附加信息"),
                new SearchResult("Search Result 2", null),
                new SearchResult("搜索结果页面测试", "这是一条多行的额外信息，" +
                        "为了测试布局能够完善的显示超过一行的信息而设立。如果看到这一行，说明" +
                        "其能正常显示多行信息。"),
                new SearchResult("Result Person", null),
                new SearchResult("Result Room", "This is a room for noobs.")
        )
        );
        mResults.setValue(list);
    }

    public LiveData<ArrayList<SearchResult>> getResults() {
        return mResults;
    }
}