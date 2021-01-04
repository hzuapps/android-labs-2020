package edu.hzuapps.androidlabs.net1814080903312;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener,MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener{

    private String name[]=new String[1024];
    private String artical[]=new String[1024];
    private String url[]=new String[1024];
    private int id[]=new int[1024];
    private SimpleAdapter adapter;
    private List<Map<String, Object>> list;
    private ListView listView;
    private MediaPlayer mediaPlayer;
    private ImageButton button1,button2,button3,button4;
    private int index=0;//当前播放音乐索引
    private boolean isPause=false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.lv_music_1);
        list = new ArrayList<Map<String, Object>>();
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnCompletionListener(this);
        init();//按钮初始化
    }
    //按钮初始化
    private void init(){
        button1=  findViewById(R.id.IB1);
        button2=  findViewById(R.id.IB3);
        button3=  findViewById(R.id.IB4);
        button4=  findViewById(R.id.IB2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }
    
    public void huoqu(View v){
        ContentResolver contentResolver=getContentResolver();
        Cursor c=contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        if (c!=null){
            int i=0;
            while(c.moveToNext()){
                Map<String,Object> map= new HashMap<String, Object>();
                //歌曲
                name[i]=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                id[i]=c.getInt(c.getColumnIndex(MediaStore.Audio.Media._ID));
                //作者
                artical[i]=c.getString(c.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                //路径
                url[i]=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA));
                map.put("SongName", name[i]);
                map.put("id", id[i]);
                map.put("Artical", artical[i]);
                map.put("url", url[i]);
                list.add(map);
                i++;
            }
            adapter = new SimpleAdapter(getApplicationContext(), list, R.layout.content,
                    new String[] { "SongName","Artical" }, new int[] { R.id.name,R.id.artical});
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //从头开始播放音乐

                    if (i<list.size()){
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                        }
                        Uri conuri= ContentUris.withAppendedId(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,id[i]);
                        try {
                            mediaPlayer.setDataSource(getApplicationContext(),conuri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        index=i;
                        isPause=false;
                        mediaPlayer.prepareAsync();



                    }
                }
            });
        }else{
            Toast.makeText(getApplicationContext(),"本地没有音乐文件",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        mediaPlayer.reset();
        return true;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    //监听事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.IB1:
                try {
                    up();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.IB2:
                try {
                    start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.IB3:
                pause();
                break;
            case R.id.IB4:
                try {
                    next();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
    //上一首
    private void up() throws IOException {
        if (index-1>=0){
            index--;
        }else{
            index=list.size()-1;
        }
        ccstat();

    }

    //下一首
    private void next() throws IOException {
        if (isPause){
            mediaPlayer.stop();
            mediaPlayer.reset();
            isPause=false;
        }
        if (index+1<list.size()){
            index++;
        }else{
            index=0;
        }
        ccstat();
    }

    //暂停
    private void pause() {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            isPause=true;
        }
    }

    //   播放
    private void start() throws IOException {
        //恢复播放或者从头播放
        if (isPause){
            mediaPlayer.start();
            isPause=false;
        }else{
            ccstat();
        }

    }

    //从头开始播放音乐
    private void ccstat() throws IOException {
        if (index<list.size()){
            if (mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
            Uri conuri= ContentUris.withAppendedId(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,id[index]);
            mediaPlayer.setDataSource(getApplicationContext(),conuri);
            mediaPlayer.prepareAsync();
            isPause=false;

        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        try {
            next();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}