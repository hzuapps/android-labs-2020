package edu.hzuapps.androidlabs.net181408903241;
        import android.os.Bundle;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
public class SerachActivity extends  AppCompatActivity {
    private TextView mse_1;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchword);
        mse_1 = (TextView) findViewById(R.id.se_1);
    }
}
