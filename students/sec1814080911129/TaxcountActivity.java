


package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class  TaxcountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taxc);
        Button btnOpen =(Button)findViewById(R.id.buttonback);
        btnOpen.setX(200f);
        btnOpen.setY(200f);
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(TaxcountActivity.this,MainActivity.class);
                TaxcountActivity.this.startActivity(intent);
            }
        });

    }
}