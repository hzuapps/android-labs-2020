package edu.hzuapps.androidlabs.sec1814080911222;



import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PerformanceActivity extends AppCompatActivity{


    private Button btClick = null;
    private TextView tvCount = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);

        btClick = (Button) findViewById(R.id.btClick);
        tvCount = (TextView) findViewById(R.id.tvCount);

        tvCount.setText("你的任务是"+PlanActivity.countTask+"个俯卧撑");

        btClick.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(PlanActivity.countTask == 0){
                            tvCount.setText("恭喜你完成任务，你做了" + PlanActivity.countTask + " 个俯卧撑");
                            return;
                        }


                        PlanActivity.countTask--;
                        tvCount.setText("你还剩 " + PlanActivity.countTask + " 个俯卧撑");
                    }
                }
        );


}






}