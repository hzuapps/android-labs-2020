package edu.hzuapps.androidlabs.net1814080903115;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Net1814080903115Activity extends AppCompatActivity {
            @Override
            protected void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                final Activity thisActivity = this;

                Button btnBrowse = (Button) findViewById(R.id.button_browse);
                View view = findViewById(R.id.button_browse);

                btnBrowse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(thisActivity, BrowseActivity.class);
                        thisActivity.startActivity(intent);
                        //thisActivity.startActivityForResult(intent, 2016);
                    }
                });
                Button btnPlay = (Button) findViewById(R.id.button_play);
                View view2 = findViewById(R.id.button_play);

                btnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(thisActivity, PlayActivity.class);
                        thisActivity.startActivity(intent);
                        //thisActivity.startActivityForResult(intent, 2016);
                    }
                });


            }


        }

