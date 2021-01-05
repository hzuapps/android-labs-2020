package com.example.sec1814080911131activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Four_Activity extends Activity implements View.OnClickListener {
    private final String mList_view_data_counts = "list_view_data_counts";
    private final int mDefValue = 10;
    private final String mPreference_name = "preference_name";
    private ListView mFriendListView;
    private List<UserInfo> mUserInfos;
    private int mDtatCounts = 5;
    private FriendAdapter mFriendAdapter;
    private EditText mDataCountEditText;
    private Button mConfirmButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_layout_activity);


        FinfView();
        SetData();
        SetListeners();
    }
    private void FinfView() {
        mFriendListView = findViewById(R.id.list_view);
        mDataCountEditText = findViewById(R.id.EditText);
        mConfirmButton = findViewById(R.id.confirm_Button);

    }

    private void SetData() {
        SharedPreferences sharedPreferences = Four_Activity.this.getSharedPreferences(mPreference_name, Context.MODE_PRIVATE);

        mDtatCounts = sharedPreferences.getInt(mList_view_data_counts, mDefValue);

        mDataCountEditText.setText(String.valueOf(mDtatCounts));
        mUserInfos = new ArrayList<>();
        for (int index = 0; index < mDtatCounts ; index++) {
            mUserInfos.add(new UserInfo("小明",21));
        }
        mFriendAdapter = new FriendAdapter(Four_Activity.this, mUserInfos);
        mFriendListView.setAdapter(mFriendAdapter);

    }

    private void SetListeners() {
        mFriendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    mUserInfos.clear();
                    mUserInfos.add(new UserInfo("1小明",123));
                    mUserInfos.add(new UserInfo("2小红",456));
                    mUserInfos.add(new UserInfo("3小白",789));
                    mUserInfos.add(new UserInfo("4小黑",1234));

                    mFriendAdapter.refresData(mUserInfos);
                    mFriendAdapter.notifyDataSetChanged();
                }
                Toast.makeText(Four_Activity.this,mUserInfos.get(position).getUserName()+"hello world",Toast.LENGTH_SHORT).show();
            }
        });

        mFriendListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Four_Activity.this,mUserInfos.get(position).getUserName()+"长按",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mConfirmButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm_Button:
                String countString = mDataCountEditText.getText().toString();
                mDtatCounts = Integer.parseInt(countString);
                refreshListView();
                saveData2Preference(mDtatCounts);
                break;
        }
    }

    private void saveData2Preference(int dataCounts) {
        SharedPreferences sharedPreferences = Four_Activity.this.getSharedPreferences("preference_name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(mList_view_data_counts,dataCounts);
        editor.apply();

    }

    private void refreshListView() {
        mUserInfos.clear();
        for (int index = 0; index < mDtatCounts ; index++) {
            mUserInfos.add(new UserInfo("小明",12));

        }
        mFriendAdapter.refresData(mUserInfos);
        mFriendAdapter.notifyDataSetChanged();
    }

    public class UserInfo  {
        private String mUserName;
        private int mAge;

        public UserInfo(String userName,int age){
            mUserName = userName;
            mAge = age;
        }
        public String getUserName(){return mUserName;}
        public void setUserName(String userName){mUserName = userName;}
        public int getAge(){return mAge;}
        public void setAge(int age){mAge = age;}
    }

}
