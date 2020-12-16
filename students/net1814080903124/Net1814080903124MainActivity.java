package edu.hzuapps.androidlabs.net1814080903124;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Net1814080903124MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903124_main);
        // 设置按钮操作 "button_"
        prepareExampleButton(R.id.button_sneaker);
        prepareExampleButton(R.id.button_acc);
        prepareExampleButton(R.id.button_clothes);
    }

    private void prepareExampleButton(final int buttonId) {
        final Activity thisActivity = this;
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(thisActivity, getActivity(buttonId));
            }
        });

    }

    private void openActivity(Activity activity, Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
    }

    private Class getActivity(int id) {
        if (R.id.button_clothes== id) {
            return Net1814080903124ClothesActivity.class;
        } else if (R.id.button_sneaker == id) {
            return Net1814080903124SneakerActivity.class;
        } else if (R.id.button_acc == id) {
            return Net1814080903124AccActivity.class;
        }
        else {
            return Net1814080903124MainActivity.class;
        }
    }


}



