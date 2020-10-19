package androidlabs.hzuapps.edu.sec1814080911127;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Sec1814080911127Activity extends Activity {

    private Button button;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button:
                        Intent intent = new Intent(Sec1814080911127Activity.this,AddActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button2:
                        Intent intent1 = new Intent(Sec1814080911127Activity.this,AddActivity.class);
                        startActivity(intent1);
                        break;
                }

            }
        };

        button = findViewById(R.id.button);
        button.setOnClickListener(onClickListener);

        button = findViewById(R.id.button2);
        button.setOnClickListener(onClickListener);

    }
}
