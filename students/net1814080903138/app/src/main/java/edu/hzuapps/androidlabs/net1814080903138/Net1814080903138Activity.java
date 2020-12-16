package edu.hzuapps.androidlabs.net1814080903138;



import android.content.SharedPreferences;
import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Net1814080903138Activity extends AppCompatActivity {
    private EditText mEtName;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903138Activity thisActivity = this;

        mSharedPreferences = getSharedPreferences("data",MODE_PRIVATE); //文件名称：data（随便写），模式
        mEditor = mSharedPreferences.edit();

        Button button1 = (Button)findViewById(R.id.button_add);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mEditor.putString("name",mEtName.getText().toString());
////                mEditor.apply();
                Intent intent = new Intent(thisActivity, Add1814080903138Activity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button button2 = (Button)findViewById(R.id.button_check);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Check1814080903138Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }



}