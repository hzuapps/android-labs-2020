package edu.hzuapps.androidlabs.net1814080903129;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class ShiftActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private EditText resultText;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        resultText = findViewById(R.id.result_text);
        button2 = findViewById(R.id.button2);


        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_back2);
        View view = findViewById(R.id.button_back2);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903129Activity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.button3);
        View view2 = findViewById(R.id.button3);

        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, knowledge.class);
                thisActivity.startActivity(intent);
            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText.setText("");
                editText.setText("");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString().trim();
                if (!str.matches("^[0-9]+$")) {
                    resultText.setText("请输入正整数");
                    return;
                }
                else{
                    String two = Integer.toBinaryString(parseInt(str));
                    resultText.setText(two);

                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String he = resultText.getText().toString();
                if (!he.matches("^[0-1]+$")) {
                    editText.setText("请输入数字0或1");
                    return;
                }
                else{
                    String ten = Integer.valueOf(he, 2).toString();
                    editText.setText(ten);
                }
            }
        });
    }
}
