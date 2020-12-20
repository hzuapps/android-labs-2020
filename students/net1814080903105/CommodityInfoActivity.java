package edu.hzuapps.androidlabs.net1814080903105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

public class CommodityInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_info);

        Button button1=(Button)findViewById(R.id.button_add);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView textView=(TextView) findViewById(R.id.commodity_name);
                String inputText=textView.getText().toString();
                Intent intent=new Intent(CommodityInfoActivity.this,ShoppingActivity.class);
                intent.putExtra("data",inputText);
                startActivity(intent);
            }
        });

        final CommodityInfoActivity thisActivity = this;
        Button button = findViewById(R.id.button_shopping1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ShoppingActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        DataArray dataArray = new DataArray();
        Intent intent = getIntent();
        final Integer position = intent.getIntExtra("id",0);

        ImageView imageView = findViewById(R.id.commodity_picture);
        imageView.setImageResource(dataArray.Picture[position]);
        TextView textView = null;
        textView = findViewById(R.id.commodity_name);
        textView.setText(dataArray.Name[position]);
        textView = findViewById(R.id.commodity_series);
        textView.setText(dataArray.Series[position]);

    }
}
