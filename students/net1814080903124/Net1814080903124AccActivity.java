package edu.hzuapps.androidlabs.net1814080903124;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903124AccActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903124_acc);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setAdapter(new ImageAdapter2(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 这里可以添加点击图片后的显示处理
                Intent intent = new Intent(getApplicationContext(), AccLook.class);
                // Pass image index
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}
class ImageAdapter2 extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter2(Context c) {
        mContext = c;
    }

    public int getCount() {
        return FindImage.ACC_Image.length;
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
        imageView.setImageResource(FindImage.ACC_Image[position]);
        return imageView;
    }
}
