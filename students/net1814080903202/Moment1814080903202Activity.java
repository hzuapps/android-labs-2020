package edu.hzuapps.androidlabs.net1814080903202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Moment1814080903202Activity extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;
    private ImageButton back;
    private ImageButton scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment1814080903202);
        listView = findViewById(R.id.MomentList);
        back = findViewById(R.id.back);
        scan = findViewById(R.id.scan);
        back.setOnClickListener(this);
        scan.setOnClickListener(this);
        listView.setAdapter(new MomentAdapter(this));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
            case R.id.scan:
                intent = new Intent(this, Scan1814080903202Activity.class);
                startActivity(intent);
                break;
        }
    }
}

class MomentAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater layoutInflater;
    public MomentAdapter(Context context){
        mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder{
        public ImageView head;
        public TextView name;
        public TextView time;
        public TextView content;
        public ImageView img1;
        public ImageView img2;
        public ImageView img3;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.moment_listview_item,null);
            viewHolder = new ViewHolder();
            viewHolder.head = convertView.findViewById(R.id.head);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.time = convertView.findViewById(R.id.time);
            viewHolder.content = convertView.findViewById(R.id.content);
            viewHolder.img1 = convertView.findViewById(R.id.img1);
            viewHolder.img2 = convertView.findViewById(R.id.img2);
            viewHolder.img3 = convertView.findViewById(R.id.img3);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.head.setBackgroundResource(heads[position]);
        viewHolder.name.setText(names[position]);
        viewHolder.time.setText(times[position]);
        viewHolder.content.setText(contents[position]);
        viewHolder.img1.setBackgroundResource(img[0]);
        viewHolder.img2.setBackgroundResource(img[1]);
        if (position != 1){
            viewHolder.img3.setBackgroundResource(img[0]);
        }

        return convertView;
    }
    public Integer[] heads = {
        R.drawable.head1,
        R.drawable.head2,

    };
    public String[] names = {
            "Lunette",
            "viices",
    };
    public String[] times = {
            "2小时前",
            "3小时前",
    };
    public String[] contents = {
            "123",
            "456"
    };
    public Integer[] img = {
            R.drawable.head1,
            R.drawable.head2,

    };
}