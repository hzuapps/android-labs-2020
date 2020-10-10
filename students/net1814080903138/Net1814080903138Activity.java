package edu.hzuapps.androidlabs.net1814080903138;



import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;


public class Net1814080903138Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  final Net1814080903138Activity thisActivity = this;
        Button button = (Button)findViewById(R.id.button_check);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Check1814080903138Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}