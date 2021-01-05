package edu.hzuapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.dao.UserDao;
import edu.hzuapps.model.User;

public class ReviseActivity extends AppCompatActivity {
    private Button button_revise;
    private Button button_delete;
    private EditText editText_revise;
    private EditText editText_mood;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise);
        userDao = new UserDao(this);
        final ReviseActivity thisActivity = this;
        // ((EditText) findViewById(R.id.book_name)).setText(name);
        Intent intent=getIntent();
        //TextView tv=findViewById(R.id.textView_revice);
        String data=intent.getStringExtra("data");
        final int id=Integer.parseInt(data);
        User user=userDao.dbQueryOneById(id);
        String text= user.getText();
        String mood= user.getMood();
        editText_revise = (EditText) findViewById(R.id.EditWrite_revise);
        editText_revise.setText(text);
        editText_mood = (EditText) findViewById(R.id.EditWrite_mood);
        editText_mood.setText(mood);
        button_revise = (Button) findViewById(R.id.button_revise);
        button_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                String text = editText_revise.getText() + "";
                String mood = editText_mood.getText() + "";
                if(text != "" && mood != "") {
                    userDao.dbUpdateText(id, text, mood);
                    Toast.makeText(
                            ReviseActivity.this,
                            "修改成功" + text +" "+ mood, Toast.LENGTH_SHORT)
                            .show();
                    Intent intent = new Intent(ReviseActivity.this,
                            ReadActivity.class);
                    startActivity(intent);
                }
                else
                {Toast.makeText(
                        ReviseActivity.this,
                        "请输入完整信息", Toast.LENGTH_SHORT)
                        .show();}

            }
        });
        button_delete = (Button) findViewById(R.id.button_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                userDao.dbDeleteUser(id);
                Toast.makeText(
                        ReviseActivity.this,
                        "成功删除" , Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(ReviseActivity.this,
                        ReadActivity.class);
                startActivity(intent);


            }
        });

    }
}
