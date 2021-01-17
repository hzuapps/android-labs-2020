package edu.hzuapp.androidlabs.net1808081001120;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import edu.hzuapp.androidlabs.net1808081001120.dao.FormDao;
import edu.hzuapp.androidlabs.net1808081001120.pojo.Form;
import edu.hzuapp.androidlabs.net1808081001120.utils.LogUtils;

public class HistoryActivity extends Activity {
    private TextView textViewId;
    private TextView textViewDate;
    //    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        initData();
    }

    private void initData() {
        FormDao formDao=new FormDao(HistoryActivity.this);
        List<Form> formList = formDao.dbSelectAllInfos();
        Integer len=formList.size();
        Form form1=formList.get(len-1);
        LogUtils.d(HistoryActivity.class,"id------->"+String.valueOf(form1.getId()));
        LogUtils.d(HistoryActivity.class,"date------->"+form1.getDate());
        textViewId.setText(String.valueOf(form1.getId()));
        textViewDate.setText(form1.getDate());
    }

    private void initView() {

        textViewId = findViewById(R.id.editTextTextPersonName2);
        textViewDate = findViewById(R.id.editTextTextPersonName5);

    }

}