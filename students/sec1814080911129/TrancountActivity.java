package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

class TranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran);
        Button btnOpen2 =(Button)findViewById(R.id.buttonback2);
        btnOpen2.setX(600f);
        btnOpen2.setY(200f);
        btnOpen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(TranActivity.this,MainActivity.class);
                TranActivity.this.startActivity(intent);
            }
        });
    }
}