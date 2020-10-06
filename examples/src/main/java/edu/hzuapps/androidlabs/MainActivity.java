package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.examples.ActivityBasicActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 设置按钮操作 "button_"
        prepareExampleButton(R.id.button_activitybasic);
        //prepareExampleButton(R.id.button_viewbasic);
        //prepareExampleButton(R.id.button_servicedemo);
        //prepareExampleButton(R.id.button_random);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            System.out.println("Yes");
//         Log.i(this.getClass().getSimpleName(), "View created!");
            Log.i("标题", "信息");
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        if (R.id.button_activitybasic == id) {
            return ActivityBasicActivity.class;
//        } else if (R.id.button_viewbasic == id) {
//            return ViewBasicActivity.class;
//        } else if (R.id.button_servicedemo == id) {
//            return FrameLayoutActivity.class;
//        } else if (R.id.button_random == id) {
//            return LinearLayoutActivity.class;
        } else {
//            Log.e(TAG, "找不到ID: " + id);
//            return BackActivity.class;
        }
        return null;
    }
}
