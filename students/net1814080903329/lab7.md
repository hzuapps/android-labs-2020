
# 实验七 Android设备编程
## 一、 实验目标
1. 理解Android相机、蓝牙、传感器等设备编程方法。
2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。
## 二、 实验内容
1. 获取当前用户的位置信息。
2. 显示用户当前位置信息。
## 三、 实验步骤
1.在AndroidManifest添加权限；
   ```
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.INTERNET" />
```
2.创建JingWeiActivity，在JingWeiActivity中编写getLocation()方法读取用户信息。
```
核心代码
//读取位置信息
@RequiresApi(api = Build.VERSION_CODES.M)
    protected void getLocation() {
        String provider = null;
        LocationManager service = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = service.getProviders(true);//获取所有可用的位置提供器

        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            provider = LocationManager.GPS_PROVIDER;
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            Intent i = new Intent();
            i.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(i);
        }

        //再次确认权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        //监视地理位置变化
        service.requestLocationUpdates(provider, 3000, 1, new LocationListener() {

            //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
            @Override
            public void onLocationChanged(Location location) {
                if (location != null) {
                    //不为空,显示地理位置经纬度
                    Toast.makeText(JingWeiActivity.this, "经度：" + location.getLongitude() + "\n纬度：" + location.getLatitude() + "", Toast.LENGTH_SHORT).show();
                }
            }

            // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            // Provider被enable时触发此函数，比如GPS被打开
            @Override
            public void onProviderEnabled(String provider) {

            }

            // Provider被disable时触发此函数，比如GPS被关闭
            @Override
            public void onProviderDisabled(String provider) {

            }
        });

   ```
3.获取经纬度并显示;
  ```
       //获取经纬度
       Location location = service.getLastKnownLocation(provider);
        TextView textView = findViewById(R.id.txt);
        if (location != null) {
            Toast.makeText(JingWeiActivity.this, "经度：" + location.getLongitude() + "\n纬度：" + location.getLatitude() + "", Toast.LENGTH_SHORT).show();
            textView.setText("经度：" + location.getLongitude() + "\n纬度：" + location.getLatitude());
        } else {
            textView.setText("获取经纬度失败！");
        }
    }

 ```
   

 ## 四、实验结果
![lab7](https://github.com/2950743175/android-labs-2020/blob/master/students/net1814080903329/lab8.png)

## 五、 实验心得体会
本次实验主要是设备编程，我的是新建一个JingWeiActivity读取用户的当前的位置信息经纬度并将其显示出来，本来是打算用高德定位出国家，省份，城市，街道的，因为在网上看到了一篇博主的文章，
他讲了两种方法，一种是导入高德jar包,另一种是通过通过Gradle集成SDK，两种都要到高德申请Key，而且要编写的代码有点多，比较麻烦，所以我就是看了他两种实现的方法，大致的过程都了解了，基
本上了解了Android studio如何实现获取用户当前的信息。
