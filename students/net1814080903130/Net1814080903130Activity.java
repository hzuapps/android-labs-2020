package edu.hzuapps.androidlabs.net1814080903130;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class Net1814080903130Activity extends AppCompatActivity {
    TextView tV;
    TextView textView1;
    TextView textView3;
    BottomNavigationView bottomNavigationView;
    Xiaoxi xx;
    Lianxiren lxr;
    Resoubang rsb;
    Fragment[] fragments;
    int lastfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        final Net1814080903130Activity t=this;
        textView1=findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread Thread1 = new Thread() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(t, Chat.class);
                        startActivity(intent);
                    }
                };
                Thread1.start();
            }
        });

        textView3=findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread Thread1 = new Thread() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(t, Web.class);
                        startActivity(intent);
                    }
                };
                Thread1.start();
            }
        });

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);

        View drawHeader=navigationView.inflateHeaderView(R.layout.nav_header_main);
        tV=drawHeader.findViewById(R.id.tV);
        tV.setText("编辑你的个性签名，展示你的独特性格");

        tV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread Thread2=new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Intent intent=new Intent();
                        intent.setClass(t, Qm.class);
                        t.startActivity(intent);
                    }
                });
                Thread2.start();
            }
        });
    }

    private void init(){
        xx=new Xiaoxi();
        lxr=new Lianxiren();
        rsb=new Resoubang();
        fragments=new Fragment[]{xx,lxr,rsb};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout,xx).show(xx).commit();
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.id1: {
                    if(lastfragment!=0) {
                        switchFragment(lastfragment,0);
                        lastfragment=0;
                    }
                    return true;
                }
                case R.id.id2: {
                    if(lastfragment!=1) {
                        switchFragment(lastfragment,1);
                        lastfragment=1;
                    }
                    return true;
                }
                case R.id.id3: {
                    if(lastfragment!=2) {
                        switchFragment(lastfragment,2);
                        lastfragment=2;
                    }
                    return true;
                }
            }
            return false;
        }
    };

    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.constraintLayout,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}