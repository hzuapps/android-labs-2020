package edu.hzuapps.androidlabs.net1814080903129;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OperationActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView resultText;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        resultText = findViewById(R.id.result_text);
        final Activity thisActivity = this;
        Button btnOpen = (Button) findViewById(R.id.button_back1);
        btnOpen.setX(000f);
        btnOpen.setY(150f);

        View view = findViewById(R.id.button_back1);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903129Activity.class);
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
                int result = 0;//如果最后面有“=”，先把它删掉方便操作。
                if (str.endsWith("=")) {
                    str = str.substring(0, str.length() - 1);
                }
//中间有“=” 直接提示错误信息
                if (str.contains("=")) {
                    resultText.setText("请正确输入");
                    return;
                }

//正则表达式，有数字，+ - 以外的字符，直接给错误提示
                if (!str.matches("^[0-9\\+\\-]+$")) {
                    resultText.setText("只能做加减法");
                    return;
                }
//只有加法运算
                if (str.contains("+") && !str.contains("-")) {
//字符分割 正则表达式
                    String[] strs = str.split("\\+");
                    for (int i = 0; i < strs.length; i++) {
                        if (!strs[i].isEmpty()) {
                            result += Integer.valueOf(strs[i]);
                        }

                    }
                }
//只有减法运算
                else if (str.contains("-") && !str.contains("+")) {
                    String[] strs = str.split("-");
                    for (int i = 0; i < strs.length; i++) {
                        if (strs[i].isEmpty()) {
                            continue;
                        }
                        if (i == 0) {
                            result += Integer.valueOf(strs[i]);
                        } else {
                            result -= Integer.valueOf(strs[i]);
                        }
                    }
                } else {
                    String[] strs = str.split("\\+");
                    for (String s1 : strs) {
                        if (s1.contains("-")) {
                            String[] strs2 = s1.split("\\-");
                            int count = 0;
                            for (String s : strs2) {
                                if (!s.isEmpty()) {
                                    if (count == 0) {
                                        result += Integer.valueOf(s);
                                    } else {
                                        result -= Integer.valueOf(s);
                                    }
                                }
                                count++;
                            }
                        } else {
                            if (!s1.isEmpty()) {
                                result += +Integer.valueOf(s1);
                            }
                        }
                    }
                }
                resultText.setText(str + "=" + result);
            }
        });
    }
}
