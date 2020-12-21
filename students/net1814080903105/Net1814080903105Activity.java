package edu.hzuapps.androidlabs.net1814080903105;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Net1814080903105Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareButton(R.id.button_shopping);
        prepareButton(R.id.button_list);
    }

    private void prepareButton (final int buttonId) {
        final Activity thisActivity = this;
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(thisActivity, getActivity(buttonId));
            }
        });
    }

    private void openActivity (Activity activity, Class activityClass){
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
    }

    private Class getActivity ( int id){
        if (R.id.button_list == id) {
            return ListActivity.class;
        } else if (R.id.button_shopping == id) {
            return ShoppingActivity.class;
        } else {
            return Net1814080903105Activity.class;
        }
    }

}
