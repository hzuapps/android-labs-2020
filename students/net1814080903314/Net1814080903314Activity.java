package edu.hzuapps.androidlabs.net1814080903314;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Net1814080903314Activity extends AppCompatActivity {
    private Button button;
    private Button Icon;
    private int[] mImage;
    private TextView mText;
    private int num;
    private int index;
    private String[] title;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_button);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Net1814080903314Activity.this , ButtonActivity.class);
            startActivity(intent);
    }
});
        Icon = (Button) findViewById(R.id.icn_icon);
        Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iconIntent = new Intent(Net1814080903314Activity.this , IconActivity.class);
                startActivity(iconIntent);
            }
        });
    }
    public void initData() {
        title = new String[]{"截图1", "截图2"};
        mImage = new int[]{R.drawable.phot, R.drawable.sirr};
    }
    public void updateImageAndTitle() {
        mText.setText(title[index]);
    }
}