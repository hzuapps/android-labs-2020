package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchMess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_mess);

        Drawable drawable = getResources().getDrawable(R.drawable.logo);
        drawable.setBounds(0,0,200,200);
        TextView textview = findViewById(R.id.Textview1);
        textview.setCompoundDrawables(null,drawable,null,null);

        Button button = (Button) findViewById(R.id.button_return);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SearchMess.this,Net1814080903104Activity.class);
                SearchMess.this.startActivity(intent);}
                });
}}