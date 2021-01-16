package edu.hzuapps.androidlabs.net1814080903315;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class EnlargeActivity extends AppCompatActivity {
 private int[] imageId = new int[]{
            R.drawable.a,R.drawable.b, R.drawable.c,R.drawable.f, R.drawable.e
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {  GridView gridView = (GridView) findViewById(R.id.gridView);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageId.length;
            }
            @Override
            public Object getItem(int position) {
                return null;
            }
            @Override
            public long getItemId(int position) {
                return 0;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if(convertView ==null)
                {
                    imageView = new ImageView(EnlargeActivity.this);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    imageView.setPadding(5, 5, 5, 5);
                }else
                {
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(imageId[position]);
                return imageView;
            }
        };
        gridView.setAdapter(adapter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId",imageId[position]);
                intent.putExtras(bundle);
                setResult(200,intent);
                finish();
            }
        });
    }
}
