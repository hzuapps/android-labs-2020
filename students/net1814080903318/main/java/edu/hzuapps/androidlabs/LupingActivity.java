package edu.hzuapps.androidlabs;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.IOException;

public class LupingActivity<CameraVideoActivity> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luping);
    }

    private File createMediaFile() throws IOException {

            if ((Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))) {
                // 选择自己的文件夹
                String path = Environment.getExternalStorageDirectory().getPath() + "/myvideo/";
                // Constants.video_url 是一个常量，代表存放视频的文件夹
                File mediaStorageDir = new File(path);
                if (!mediaStorageDir.exists()) {
                    if (!mediaStorageDir.mkdirs()) {
                        Log.e("TAG", "文件夹创建失败");
                        return null;
                    }
                }

                // 文件根据当前的毫秒数给自己命名
                String timeStamp = String.valueOf(System.currentTimeMillis());
                timeStamp = timeStamp.substring(7);
                String imageFileName = "V" + timeStamp;
                String suffix = ".mp4";
                File mediaFile = new File(mediaStorageDir + File.separator + imageFileName + suffix);
                return mediaFile;
            }else return null;
    }
}
