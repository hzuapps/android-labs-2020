package edu.hzuapps.androidlabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private RecyclerView rc;

    private Button returnmainview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        rc = findViewById(R.id.linear);
        rc.setLayoutManager(new LinearLayoutManager(MessageActivity.this));
        rc.addItemDecoration(new Mydecoration());//·Ö¸îÏß
        rc.setAdapter(new LinearAdapter(MessageActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                //Toast.makeText(MessageActivity.this,"click..."+pos,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MessageActivity.this,ReceiveMessageActivity.class);
                intent.putExtra("pos",pos+"");
                startActivity(intent);
            }
        }));

        returnmainview  = findViewById(R.id.returnmainview);
        returnmainview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this,Net1814080903226Activity.class);
                startActivity(intent);
            }
        });
    }

    class Mydecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}