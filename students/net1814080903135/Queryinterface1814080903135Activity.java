package edu.hzuapps.androidlabs.net1814080903135;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class Queryinterface1814080903135Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queryinterface1814080903135);
        Button button = findViewById(R.id.button3);
        final Queryinterface1814080903135Activity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this,Net1814080903135Activity.class);
                _this.startActivity(intent);
            }
        });

    }
}
