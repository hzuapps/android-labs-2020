package edu.hzuapp.androidlabs.net1814080903141;


import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnsave=findViewById(R.id.btnsave);

        final GameActivity thisActivity=this;
        // 保存记录信息
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveRecord();
            }
        });

    }

    private void saveRecord() {
        String score = ((EditText) findViewById(R.id.tscore)).getText().toString();
        String best = ((EditText) findViewById(R.id.tbest)).getText().toString();

        // 插入新记录
        ContentValues record = new ContentValues();
        //book.put("name", name); // Map <- Key:Value
        record.put(ContentProviderOfRecords.SCORE,score);
        record.put(ContentProviderOfRecords.BEST, best);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfRecords.CONTENT_URI, record);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showRecordInfo("", ""); // 清除内容
    }

    private void showRecordInfo(String score, String best) {
        ((EditText) findViewById(R.id.tscore)).setText(score);
        ((EditText) findViewById(R.id.tbest)).setText(best);
    }


}


