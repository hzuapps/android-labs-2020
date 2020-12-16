package edu.hzuapps.pyq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.pyq.listview.Message;
import edu.hzuapps.pyq.listview.MessageAdapter;

public class LookPyqActivity extends AppCompatActivity {
    private List<Message> messageList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_pyq);

        Button btnLook = (Button) findViewById(R.id.btnLook);
        btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LookPyqActivity.this,SendPyqActivity.class);
                startActivity(intent);
            }
        });

//        Button sendBtn = (Button)findViewById(R.id.sendBtn);
//        sendBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                String content = ((EditText) findViewById(R.id.content)).getText().toString();
//                if(!content.isEmpty()){
//                    Message message = new Message(content, R.drawable.pyqlogo);
//                    messageList.add(message);
//                }
//            }
//        });

        final LookPyqActivity thisActivity = this;

//        Button listBtn = (Button) findViewById(R.id.button_main);
//        listBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(thisActivity,LookPyqActivity.class);
//                startActivity(intent);
//            }
//        });

        // 先拿到数据并放在适配器上
        initMessage(); //初始化水果数据
        MessageAdapter adapter=new MessageAdapter(LookPyqActivity.this,R.layout.message_item,messageList);

        // 将适配器上的数据传递给listView
        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // 为ListView注册一个监听器，当用户点击了ListView中的任何一个子项时，就会回调onItemClick()方法
        // 在这个方法中可以通过position参数判断出用户点击的是那一个子项
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Message message=messageList.get(position);
                Toast.makeText(LookPyqActivity.this,message.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 初始化数据
    private void initMessage(){
        Message a=new Message("一万年太长，和你在一起，只争朝夕。",R.drawable.pyqlogo);
        messageList.add(a);
        Message b=new Message("情书给你一封，情话给你一句，余生给你一人。",R.drawable.pyqlogo);
        messageList.add(b);
        Message c=new Message("我想要的未来，就是每天早上起床，都能看见你和阳光都在。",R.drawable.pyqlogo);
        messageList.add(c);
        Message d=new Message("想要的，就是无论有多难，依然有那么一个人和我相依相守。",R.drawable.pyqlogo);
        messageList.add(d);
        Message d2=new Message("没我喜欢风，无拘无束，我喜欢星辰，安静明亮，我喜欢深海中的鲸，孤独澄净，我喜欢动漫，温暖心弦，我喜欢你，没有道理。",R.drawable.pyqlogo);
        messageList.add(d2);
        Message d3=new Message("千世界，处处繁花似锦，能够遇见你三生有幸。",R.drawable.pyqlogo);
        messageList.add(d3);
        Message d4=new Message("终于遇见了你，从此不必在意阴晴风雨，从此随心所欲地老去。",R.drawable.pyqlogo);
        messageList.add(d4);


    }
}