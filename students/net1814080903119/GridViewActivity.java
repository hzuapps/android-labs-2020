package edu.hzuapps.androidlabs.net1814080903119;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GridViewActivity extends AppCompatActivity implements View.OnClickListener {
    private Button staticPaper;
    private Button dynamicPaper;
    ImageView imageView;
    GridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridview = findViewById(R.id.grid_view);
        staticPaper = findViewById(R.id.button2);
        staticPaper.setOnClickListener(this);
        dynamicPaper = findViewById(R.id.button3);
        dynamicPaper.setOnClickListener(this);
        gridview.setAdapter(new ImageAdapter(this));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                gridview.setAdapter(new ImageAdapter(this));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        // 这里可以添加点击图片后的显示处理
                        Intent intent = new Intent(getApplicationContext(), StaticPageActivity.class);
                        // Pass image index
                        intent.putExtra("id", position);
                        startActivity(intent);
                    }
                });break;
            case R.id.button3:
                gridview.setAdapter(new VideoAdapter(this));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        // 这里可以添加点击图片后的显示处理
                        Intent intent = new Intent(getApplicationContext(), DynamicPaperActivity.class);
                        // Pass image index
                        intent.putExtra("id", position);
                        startActivity(intent);
                    }
                });break;
            default:break;
        }
        //显示图片
      //  displayPhoto.setImageResource(photos[photoIndex]);
    }
}

class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Intent intent;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imagecol.length;
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
            imageView.setLayoutParams(new GridView.LayoutParams(540,870 ));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(12, 8, 12, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imagecol[position]);
        return imageView;
    }
    // Keep all Images in array
    public Integer[] imagecol = {
            R.drawable.picture1,
            R.drawable.picture2,
            R.drawable.picture3,
            R.drawable.picture4,
            R.drawable.picture5,
            R.drawable.picture6,
            R.drawable.picture7,
            R.drawable.picture8,
            R.drawable.picture9,
    };
}


class VideoAdapter extends BaseAdapter {
    private Context mContext;
    private Intent intent;

    // Constructor
    public VideoAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return videocol.length;
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
            imageView.setLayoutParams(new GridView.LayoutParams(540,870 ));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(12, 8, 12, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(videocol[position]);
        return imageView;
    }
    // Keep all Images in array
    public Integer[] videocol = {
            R.drawable.picturevideo1,
            R.drawable.picturevideo3,
            R.drawable.picturevideo4,
            R.drawable.picturevideo5,
            R.drawable.picturevideo6,
            R.drawable.picturevideo7,
            R.drawable.picturevideo8,
            R.drawable.picturevideo9,
            R.drawable.picturevideo10,
            R.drawable.picturevideo11,
            R.drawable.picturevideo12,
            R.drawable.picturevideo13,
    };
}