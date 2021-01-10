# 实验七

## 一.实验目标  
1.总结所学Android知识点；  
2.初步掌握从提出需求到完成App开发的基本过程；  
3.练习并掌握撰写移动App开发技术报告的方法 
  
## 二.实验内容  
1.实现摇一摇的设备功能；    
2.编程实现设备使用。
  
## 三.实验步骤
1.TestSensorActivity Activity文件
```
public class TestSensorActivity extends Activity {
    private SensorManager sensorManager;
    private Vibrator vibrator;
    private static final String TAG = "TestSensorActivity";
    private static final int SENSOR_SHAKE = 10;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (sensorManager != null) {// 注册监听器
            sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
            // 第一个参数是Listener，第二个参数是所得传感器类型，第三个参数值获取传感器信息的频率
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager != null) {// 取消监听器
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    /**
     * 重力感应监听
     */
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            // 传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0]; // x轴方向的重力加速度，向右为正
            float y = values[1]; // y轴方向的重力加速度，向前为正
            float z = values[2]; // z轴方向的重力加速度，向上为正
            Log.i(TAG, "x轴方向的重力加速度" + x +  "；y轴方向的重力加速度" + y +  "；z轴方向的重力加速度" + z);
            // 一般在这三个方向的重力加速度达到40就达到了摇晃手机的状态。
            int medumValue = 19;// 三星 i9250怎么晃都不会超过20，没办法，只设置19了
            if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE;
                handler.sendMessage(msg);
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
   
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SENSOR_SHAKE:
                    Toast.makeText(TestSensorActivity.this, "检测到摇晃，执行操作！", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "检测到摇晃，执行操作！");
                    break;
            }
        }

    };
}
```
## 四.实验结果  
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab7_1.png">  
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab7_2.png">  

## 五.实验体会
本次实验是关于如何调用android设备的编程，本来是想调用摄像机进行拍照功能，但是总是出现 phone keeps stopping的错误，  
多方寻找，都没有解决，无奈下做了一个简单的摇一摇功能

























