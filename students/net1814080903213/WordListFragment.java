package com.example.facewords_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WordListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WordListFragment extends Fragment {
    // Listing Data
    private List<Word> wordList = new ArrayList<>();

    // 声明数据库对象
    Database db;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WordListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment wordListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WordListFragment newInstance(String param1, String param2) {
        WordListFragment fragment = new WordListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // 获取数据库对象
        db = Database.getInstance(getActivity());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initialize fake data
        initWords();
        // 注册 RecyclerView
        RecyclerView recyclerView = requireView().findViewById(R.id.word_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        WordAdapter wordAdapter = new WordAdapter(wordList);
        recyclerView.setAdapter(wordAdapter);
    }

    private void initWords() {
        // 从数据库中获取 WordList 数据
        wordList = db.wordDao().getWordList();

        Log.d(TAG, "initWords: " + wordList.get(0).getContent());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word_list, container, false);
    }

}