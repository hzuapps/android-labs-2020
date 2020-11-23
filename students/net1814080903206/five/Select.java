package com.example.net1814080903206activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Select extends AppCompatActivity {

    ImageView imageView1,imageView2,imageView3,imageView4;
    TextView textView1,textView2,textView3,textView4;
    Button add_goods1,add_goods2,add_goods3,add_goods4;
    String[] iconname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_a);
       final Button shoes=findViewById(R.id.shoes);
        final Button clothes=findViewById(R.id.clothes);
        final Button kids=findViewById(R.id.kids);

      imageView1 = (ImageView) findViewById(R.id.photo1);
        imageView2 = (ImageView) findViewById(R.id.photo2);
        imageView3 = (ImageView) findViewById(R.id.photo3);
        imageView4 = (ImageView) findViewById(R.id.photo4);
        textView1=(TextView)findViewById(R.id.money1);
        textView2=(TextView)findViewById(R.id.money2);
        textView3=(TextView)findViewById(R.id.money3);
        textView4=(TextView)findViewById(R.id.money4);
        add_goods1=(Button)findViewById(R.id.add_goods1);
        add_goods2=(Button)findViewById(R.id.add_goods2);
        add_goods3=(Button)findViewById(R.id.add_goods3);
        add_goods4=(Button)findViewById(R.id.add_goods4);
        add_goods1.setText("添加至购物车");
        add_goods2.setText("添加至购物车");
        add_goods3.setText("添加至购物车");
        add_goods4.setText("添加至购物车");
        final Context context=getBaseContext();


       shoes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                if(v==shoes)
                {
                     iconname=context.getResources().getStringArray(R.array.shoes);
                    final int[] b=new int[iconname.length];
                    for(int i=0;i<4;i++)
                        b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                    imageView1.setImageResource(b[0]);
                    imageView2.setImageResource(b[1]);
                    imageView3.setImageResource(b[2]);
                    imageView4.setImageResource(b[3]);
                    textView1.setText("1299");
                    textView2.setText("1099");
                    textView3.setText("899");
                    textView4.setText("699");

                }
           }
       });
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==clothes)
                {
                     iconname=context.getResources().getStringArray(R.array.clothes);
                    final int[] b=new int[iconname.length];
                    for(int i=0;i<4;i++)
                        b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                    imageView1.setImageResource(b[0]);
                    imageView2.setImageResource(b[1]);
                    imageView3.setImageResource(b[2]);
                    imageView4.setImageResource(b[3]);
                    textView1.setText("699");
                    textView2.setText("599");
                    textView3.setText("499");
                    textView4.setText("299");
                }
            }
        });
        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==kids)
                {
                    iconname=context.getResources().getStringArray(R.array.kids);
                    final int[] b=new int[iconname.length];
                    for(int i=0;i<4;i++)
                        b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                    imageView1.setImageResource(b[0]);
                    imageView2.setImageResource(b[1]);
                    imageView3.setImageResource(b[2]);
                    imageView4.setImageResource(b[3]);
                    textView1.setText("1299");
                    textView2.setText("899");
                    textView3.setText("499");
                    textView4.setText("399");
                }
            }
        });
       add_goods1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Goods goods=new Goods();
            goods.get_goods(((BitmapDrawable)imageView1.getDrawable()).getBitmap(),textView1.getText().toString());
            }
        });
        add_goods2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goods goods=new Goods();
                goods.get_goods(((BitmapDrawable)imageView2.getDrawable()).getBitmap(),textView2.getText().toString());
            }
        });
        add_goods3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goods goods=new Goods();
                goods.get_goods(((BitmapDrawable)imageView3.getDrawable()).getBitmap(),textView3.getText().toString());
            }
        });
        add_goods4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goods goods=new Goods();
                goods.get_goods(((BitmapDrawable)imageView4.getDrawable()).getBitmap(),textView4.getText().toString());
            }
        });

    }

    }
