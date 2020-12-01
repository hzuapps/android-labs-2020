package edu.hzuapps.androidlabs.net1814080903223;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ViewandmodifyActivity extends AppCompatActivity {

    private Button fanhui;
    private TextView jieguo,xx;
    String ret;
     @Override
	    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_viewandmodify);
    fanhui=(Button) findViewById(R.id.button_fanhui);
	        jieguo=(TextView)findViewById(R.id.textview_03_01);
	        xx=(TextView)findViewById(R.id.textview_03_02);
	        final Intent intent=getIntent();
	        String st=intent.getStringExtra("quan");
	        int s=Integer.parseInt(st);
	        String sp=null;
	        if(s==2){
	            sp="布 ";
	        }
	        else if(s==1){
	            sp="石头";
	        }
	        else if(s==0){
	            sp="剪刀";
	        }
	        int x=(int)(Math.random()*3);
	        String sx=null;
	        if(x==2){
	            sx="布 ";
	        }
	        else if(x==1){
	            sx="石头";
	        }
	        else if(x==0){
	            sx="剪刀";
	        }
	        if ((s == 0 && x == 1) ||
	                (s == 1 && x == 2) ||
	                (s == 2 && x == 0)){
	            jieguo.setText("^-^  你输了  真瓜怂");
	            ret="输了";
	        }
	        else if (s == x) {
	            jieguo.setText("有缘TnT平手,再来");
	            ret="平手";
	        }
	        else {
	            jieguo.setText("(^v^) oh  你赢了  ");
	            ret="赢了";
	        }
	        xx.setText("你出"+sp+"，电脑出"+sx);
	        ret=xx.getText().toString()+" 因此 "+ret;
	        fanhui.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Intent data=new Intent();
	                data.putExtra("jieguo",ret);
	                setResult(2,data);
	                finish();
	            }
	        });
	        }
}