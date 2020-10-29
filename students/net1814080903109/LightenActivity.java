package edu.hzuapps.androidlabs.net1814080903109;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LightenActivity extends AppCompatActivity {
    private SeekBar seekbar=null;
    private TextView light=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lighten);
        this.light=(TextView) super.findViewById(R.id.light);
        this.seekbar=(SeekBar) super.findViewById(R.id.sk1);
        this.seekbar.setMax(100);
        this.seekbar.setOnSeekBarChangeListener(new SeekBarChangeListenerImp());
    }

    public class SeekBarChangeListenerImp implements OnSeekBarChangeListener{

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
// TODO Auto-generated method stub
            float cur=seekBar.getProgress();
            LightenActivity.this.setScreenBrightness(cur/100);
            LightenActivity.this.light.setText("当前屏幕亮度:"+cur/100);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }
    }
    //设置屏幕亮度的函数
    private void setScreenBrightness(float num){
        WindowManager.LayoutParams layoutParams=super.getWindow().getAttributes();
        layoutParams.screenBrightness=num;//设置屏幕的亮度

        super.getWindow().setAttributes(layoutParams);
    }
}