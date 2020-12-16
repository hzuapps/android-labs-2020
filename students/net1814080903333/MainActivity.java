package edu.hzuapps.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;import android.view.View;import android.content.Intent;
import android.widget.TableLayout;
public class MainActivity extends AppCompatActivity {
    private Button btn1,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this , Net814080903333TeacherHomeActivity.class);
                startActivity(i);
            }
        });
        btn3=(Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this ,Net1814080903333StudentsInformationActivity2.class);
                startActivity(intent);
            }
        });
    }
}