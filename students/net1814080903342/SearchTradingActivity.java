package edu.hzuapps.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;
public class SearchTradingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trading);
        final Activity thisActivity = this;
        final Spinner spinner1 = findViewById(R.id.Spinner);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.date, R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);


        Button btn_contentprovider = (Button) findViewById(R.id.button_contentprovider);
        btn_contentprovider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ContentProviderActivity.class);
                thisActivity.startActivity(intent);
            }
        });

    }
}