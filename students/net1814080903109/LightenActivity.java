package edu.hzuapps.androidlabs.net1814080903109;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
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

            float cur=seekBar.getProgress();
            LightenActivity.this.setScreenBrightness(cur);
            LightenActivity.this.light.setText("当前屏幕亮度:"+cur/100);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    //改变当前页面亮度
    private void setScreenBrightness(float num){
        Window localWindow = getWindow();
        WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
        float f = num / 255.0F;
        localLayoutParams.screenBrightness = f;
        localWindow.setAttributes(localLayoutParams);
        saveBrightness(getContentResolver(), (int) num);
    }

    //将当前页面亮度同步至系统亮度
    public static void saveBrightness(ContentResolver resolver, int brightness) {
        //改变系统的亮度值
        //设置为手动调节模式
        Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        //保存到系统中
        Uri uri = android.provider.Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS);
        android.provider.Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
        resolver.notifyChange(uri, null);
    }

}