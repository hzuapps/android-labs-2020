package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Sec1814080911130Activity extends AppCompatActivity {
    public static final String TAG = Sec1814080911130Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911130);
        prepareExampleButton(R.id.button_play);
        prepareExampleButton(R.id.button_options);

    }

    private void openActivity(Activity activity, Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
    }


    private void prepareExampleButton(final int buttonId) {
        final Activity thisActivity = this;
        Button button = (Button) findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivity(thisActivity, getActivity(buttonId));
                }
            });
        } else {
            Log.e(TAG, "按钮不存在: " + buttonId);
        }
    }
    private Class getActivity(int id) {
        if (R.id.button_play == id) {
            return PlayActivity.class;
        } else if (R.id.button_options == id) {
            return OptionsActivity.class;
        } else {
            Log.e(TAG, "找不到ID: " + id);
            return Sec1814080911130Activity.class;
        }
    }
}
