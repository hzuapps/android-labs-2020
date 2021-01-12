package edu.hzuapps.androidlabs.net1814080903308;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Song1Activity extends Fragment {
    private View view;
    public String[] name={"Taylor Swift - Ready For It","Taylor Swift - Afterglow","Taylor Swift - Call It What You Want"};
    public static int[] icons={R.drawable.music,R.drawable.music,R.drawable.music};
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.music_list,null);
        ListView listView=view.findViewById(R.id.lv);
        MyBaseAdapter adapter=new MyBaseAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Song1Activity.this.getContext(),SingActivity.class);//创建Intent对象，启动check
                //将数据存入Intent对象
                intent.putExtra("name",name[position]);
                intent.putExtra("position",String.valueOf(position));
                startActivity(intent);
            }
        });
        return view;
    }
    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){return  name.length;}
        @Override
        public Object getItem(int i){return name[i];}
        @Override
        public long getItemId(int i){return i;}

        @Override
        public View getView(int i ,View convertView, ViewGroup parent) {
            View view=View.inflate(Song1Activity.this.getContext(),R.layout.item_layout,null);
            TextView tv_name=view.findViewById(R.id.item_name);
            ImageView iv=view.findViewById(R.id.iv);

            tv_name.setText(name[i]);
            iv.setImageResource(icons[i]);
            return view;
        }
    }


}