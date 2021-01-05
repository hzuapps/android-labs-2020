package edu.hzuapps.androidlabs.sec1814080911217;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Sec1814080911217Activity extends AppCompatActivity {
    public static int h=0;
    final Activity thisActivity = this;
    //public static File  file = new File(thisActivity.getFilesDir(),"record.txt");
    public static File  file = new File("/storage/emulated/0/test/","record.txt");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(thisActivity);
        try {
            Sec1814080911217Activity.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }



        Button Earn = (Button) findViewById(R.id.button_earn_activity);

        View view1 = findViewById(R.id.button_earn_activity);

        Earn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent = new Intent(thisActivity, EarnIntegralActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        Button Exchange = (Button) findViewById(R.id.button_exchange_activity);

        View view2 = findViewById(R.id.button_exchange_activity);

        Exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intent = new Intent(thisActivity, ExchangeIntegralActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button Record = (Button) findViewById(R.id.record);
        //View view3 = findViewById(R.id.record);
        TextView textView=(TextView)findViewById(R.id.t);
        Record.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view3) {
                Intent intent = new Intent(thisActivity, Record_Activity.class);
                thisActivity.startActivity(intent);
            }
        });


    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };
    public static void verifyStoragePermissions(Activity activity) {
        try {
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}