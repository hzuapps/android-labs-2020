package edu.hzuapps.androidlabs.net1814080903135;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent = new Intent(_this,Buyingtickets1814080903135Activity.class);
                _this.startActivity(intent);
            }
        });

    }
    public void sendMessage(View view){
        Intent intent = new Intent(this,Buyingtickets1814080903135Activity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message1);
        String message = editText.getText().toString();
        intent.putExtra("EXTRA_MESSAGE",message);
        startActivity(intent);
    }
}