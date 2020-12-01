package edu.hzuapps.androidlabs;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CommentActivity extends AppCompatActivity {

    EditText comment_ht;
    EditText comment_nr;
    @Override
    protected void onCreate(Bundle saveDInstanceState) {
        super.onCreate(saveDInstanceState);
        setContentView(R.layout.activity_comment);
        comment_ht = findViewById(R.id.comment_ht);
        comment_nr = findViewById(R.id.comment_nr);
    }

    public void WriteBtn(View v) {
        //向文件中添加文本
        try {
            FileOutputStream FileOut=openFileOutput("MyTextFile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(FileOut);
            outputWriter.write(comment_nr.getText().toString());
            outputWriter.close();

            //显示文件保存消息
            Toast.makeText(getBaseContext(), "保存成功!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}