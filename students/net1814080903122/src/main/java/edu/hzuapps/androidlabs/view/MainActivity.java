package edu.hzuapps.androidlabs.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import edu.hzuapps.androidlabs.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigate();
        setNavLink();
        chFragment((Fragment) new SchedulesFragment());
    }
    private void navigate(){
        Typeface iconfont = Typeface.createFromAsset(getAssets(),"iconfont/iconfont.ttf");
        setButtonTypeface(R.id.videoButton,iconfont);
        setButtonTypeface(R.id.schedulesButton,iconfont);
        setButtonTypeface(R.id.timerButton,iconfont);
    }

    private void setButtonTypeface(int buttonId,Typeface typeface){
        RadioButton radioButton = (RadioButton)findViewById(buttonId);
        radioButton.setTypeface(typeface);
    }

    private void setNavLink(){
        setButtonLink(R.id.schedulesButton,SchedulesFragment.class);
        setButtonLink(R.id.videoButton,VedioFragment.class);
        setButtonLink(R.id.timerButton,TimerFragment.class);
    }

    private void setButtonLink(int buttonId,final Class fragmentClass){
        Button button = (Button)findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    chFragment((Fragment)fragmentClass.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void chFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_content, fragment);
        transaction.commit();
    }
}
