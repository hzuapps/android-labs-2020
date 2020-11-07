package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initStartWeekButton();
    }
    private void initStartWeekButton(){
        LinearLayout startWeek = (LinearLayout) findViewById(R.id.setStartWeek);
        startWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePinker();
            }
        });
    }

    private void datePinker() {
        LayoutInflater inflater = LayoutInflater.from(this);
        final View datePinkerView = inflater.inflate(R.layout.datepiker, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        setDatePinkerButton(datePinkerView);
        builder.setView(datePinkerView).show();
    }

    //TODO
    private void setDatePinkerButton(View view){

    }
}