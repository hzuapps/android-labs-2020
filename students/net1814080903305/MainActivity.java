package edu.hzuapps.androidlabs.net1814080903305;

    import androidx.appcompat.app.AppCompatActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainActivity thisActivity=this;
        Button btnitem = (Button) findViewById(R.id.button);
        btnitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,AlarmSetActivity.class);
                startActivity(intent);
            }
        });
        Button btnread = (Button) findViewById(R.id.button1);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,TimeDisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}