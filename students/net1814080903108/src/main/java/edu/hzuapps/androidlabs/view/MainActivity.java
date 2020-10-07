package edu.hzuapps.androidlabs.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavTypeface();
        navButtonLinkRegister();
        replaceFragment(new HomeFragment());
    }

    private void initNavTypeface(){
        Typeface iconFont = Typeface.createFromAsset(getAssets(), "typeface/navIcon.ttf");
        setButtonTypeface(R.id.NavCreateButton,iconFont);
        setButtonTypeface(R.id.NavHomeButton,iconFont);
        setButtonTypeface(R.id.NavListButton,iconFont);
    }

    private void setButtonTypeface(int buttonId,Typeface typeface){
        Button Button = (Button)findViewById(buttonId);
        Button.setTypeface(typeface);
    }

    private void navButtonLinkRegister(){
    bindButtonLink(R.id.NavHomeButton,HomeFragment.class);
    bindButtonLink(R.id.NavListButton,ListFragment.class);
    bindButtonLink(R.id.NavCreateButton,CreateFragment.class);
    }

    private void bindButtonLink(int buttonId,final Class fragmentClass){
        Button button = (Button)findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    replaceFragment((Fragment)fragmentClass.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_content, fragment);
        transaction.commit();
    }

}