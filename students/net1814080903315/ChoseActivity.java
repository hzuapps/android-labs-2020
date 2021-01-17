package edu.hzuapps.androidlabs.net1814080903315;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class ChoseActivity extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==200 && resultCode == 200)
        {
            Bundle bundle = data.getExtras();
            int imageId = bundle.getInt("imageId");
            ImageView imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageResource(imageId);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);
        Button button = (Button)findViewById(R.id.chose);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoseActivity.this,EnlargeActivity.class);
                startActivityForResult(intent,200);
            }
        });
    }
}