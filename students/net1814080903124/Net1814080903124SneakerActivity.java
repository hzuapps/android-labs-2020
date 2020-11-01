package edu.hzuapps.androidlabs.net1814080903124;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class Net1814080903124SneakerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903124_sneaker);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 这里可以添加点击图片后的显示处理
                Intent intent = new Intent(getApplicationContext(), Net1814080903124MainActivity.class);
                // Pass image index
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}

class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(450, 450));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.shoes_01,
            R.drawable.shoes_02,
            R.drawable.shoes_03,
            R.drawable.shoes_04,
            R.drawable.shoes_05,
            R.drawable.shoes_06,
            R.drawable.shoes_07,
            R.drawable.shoes_08,
            R.drawable.shoes_09,
            R.drawable.shoes_05,
            R.drawable.shoes_06,
            R.drawable.shoes_07,
            R.drawable.shoes_08,
            R.drawable.shoes_09,
            R.drawable.shoes_03,
            R.drawable.shoes_04,
            R.drawable.shoes_01

    };
}