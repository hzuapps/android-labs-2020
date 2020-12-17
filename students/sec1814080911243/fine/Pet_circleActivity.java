package edu.hzuapps.androidlabs.sec1814080911243;

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

public class Pet_circleActivity extends Activity implements View.OnClickListener {
    private final String mList_view_data_counts = "list_view_data_counts";
    private final int mDefValue = 10;
    private final String mPreference_name = "preference_name";
    private ListView mInforListView;
    private List<UserInfo> mUserInfos;
    private int mDtatCounts = 5;
    private InforAdapter mInforAdapter;
    private EditText mDataCountEditText;
    private Button mConfirmButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_circle_activity);

        FinfView();
        SetData();
        SetListeners();
    }
    private void FinfView() {
        mInforListView = findViewById(R.id.list_view);
        mDataCountEditText = findViewById(R.id.EditText);
        mConfirmButton = findViewById(R.id.confirm_Button);

    }

    private void SetData() {
        SharedPreferences sharedPreferences = Pet_circleActivity.this.getSharedPreferences(mPreference_name, Context.MODE_PRIVATE);

        mDtatCounts = sharedPreferences.getInt(mList_view_data_counts, mDefValue);

        mDataCountEditText.setText(String.valueOf(mDtatCounts));
        mUserInfos = new ArrayList<>();
        for (int index = 0; index < mDtatCounts ; index++) {
            mUserInfos.add(new UserInfo("一: 不能吃巧克力，狗狗吃了会引起呕吐、尿频不安、过度活跃、心跳呼吸加速甚至会因心血管功能丧失而最终导致死亡。"));
            mUserInfos.add(new UserInfo("二: 不能吃动物内脏，动物内脏容易引起宠物皮肤问题，例如长湿疹、皮屑和皮肤瘙痒等种种问题。"));
        }
        mInforAdapter = new InforAdapter(Pet_circleActivity.this, mUserInfos);
        mInforListView.setAdapter(mInforAdapter);

    }

    private void SetListeners() {
        mInforListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    mUserInfos.clear();


                    mInforAdapter.refresData(mUserInfos);
                    mInforAdapter.notifyDataSetChanged();
                }
                Toast.makeText(Pet_circleActivity.this,mUserInfos.get(position).getUserName(),Toast.LENGTH_SHORT).show();
            }
        });

        mInforListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Pet_circleActivity.this,mUserInfos.get(position).getUserName(),Toast.LENGTH_SHORT).show();
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
        SharedPreferences sharedPreferences = Pet_circleActivity.this.getSharedPreferences("preference_name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(mList_view_data_counts,dataCounts);
        editor.apply();

    }

    private void refreshListView() {
        mUserInfos.clear();
        for (int index = 0; index < mDtatCounts ; index++) {
            mUserInfos.add(new UserInfo("一: 不能吃巧克力，狗狗吃了会引起呕吐、尿频不安、过度活跃、心跳呼吸加速甚至会因心血管功能丧失而最终导致死亡。"));
            mUserInfos.add(new UserInfo("二: 不能吃动物内脏，动物内脏容易引起宠物皮肤问题，例如长湿疹、皮屑和皮肤瘙痒等种种问题。"));
            mUserInfos.add(new UserInfo("三：平时一般不要喂食牛奶和生蛋白，虽然牛奶营养价值较高，但猫狗不易消化，可能引起腹泻。切勿喂猫咪吃生蛋白，生蛋白含有一种抗生素蛋白，它会和猫咪体内的重要维生素，令它们缺乏吸收维他命的能力。"));
        }
        mInforAdapter.refresData(mUserInfos);
        mInforAdapter.notifyDataSetChanged();
    }

    public class UserInfo  {
        private String mUserName;


        public UserInfo(String userName){
            mUserName = userName;

        }
        public String getUserName(){return mUserName;}
        public void setUserName(String userName){mUserName = userName;}

    }

}
