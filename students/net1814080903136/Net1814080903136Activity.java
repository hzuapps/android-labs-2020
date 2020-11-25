package edu.hzuapps.androidlabs.net1814080903136;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.media.MediaPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Net1814080903136Activity extends AppCompatActivity {
    ListView mp3list;
    List<music> list;
    MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903136Activity thisActivity = this;
        Button btnedit = (Button) findViewById(R.id.button_cut);
        btnedit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity, Edit1814080903136Activity.class);
                thisActivity.startActivity(intent);
            }
        });
        Button btncom = (Button) findViewById(R.id.button_com);
        btncom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(thisActivity, Edit1814080903136Activity.class);
                thisActivity.startActivity(intent);
            }
        });
        Button btnchange = (Button) findViewById(R.id.button_change);
        btnchange.setOnClickListener(new OnClickListener() {
           @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity, Change1814080903136Activity.class);
                thisActivity.startActivity(intent);
           }
        });


        mp3list = (ListView) findViewById(R.id.mp3list);

        list = new ArrayList<>();

        list = Utils.getmusic(this);

        MyAdapter myAdapter = new MyAdapter(this, list);
        mp3list.setAdapter(myAdapter);
        
    }


    class MyAdapter extends BaseAdapter {

        Context context;
        List<music> list;

        public MyAdapter(Net1814080903136Activity net1814080903136Activity, List<music> list) {
            this.context = net1814080903136Activity;
            this.list = list;
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            Myholder myholder;

            if (view == null) {
                myholder = new Myholder();
                view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.text, null);

                myholder.t_position = view.findViewById(R.id.t_postion);
                myholder.t_song = view.findViewById(R.id.t_song);
                myholder.t_singer = view.findViewById(R.id.t_singer);
                myholder.t_duration = view.findViewById(R.id.t_duration);

                view.setTag(myholder);

            } else {
                myholder = (Myholder) view.getTag();
            }

            myholder.t_song.setText(list.get(i).song.toString());
            myholder.t_singer.setText(list.get(i).singer.toString());
            String time = Utils.formatTime(list.get(i).duration);

            myholder.t_duration.setText(time);
            myholder.t_position.setText(i + 1 + "");


            return view;
        }


        class Myholder {
            TextView t_position, t_song, t_singer, t_duration;
        }
    }
} 