package edu.hzuapps.androidlabs.net1814080903109;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class TurnoffScreenActivity extends AppCompatActivity {
    ComponentName mAdminName;
    DevicePolicyManager mDPM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turnoffscreen);

        mAdminName = new ComponentName(this, AdminManageReceiver.class);
        mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

        //如果设备管理器尚未激活，这里会启动一个激活设备管理器的Intent,具体的表现就是第一次打开程序时，手机会弹出激活设备管理器的提示，激活即可。
        if (!mDPM.isAdminActive(mAdminName)) {
            showAdminManagement(mAdminName);
        }
    }

    //执行锁屏
    public void lockScreen(View view){
        if (mDPM.isAdminActive(mAdminName)) {
            mDPM.lockNow();
        }
    }

    //激活设备管理器
    private void showAdminManagement(ComponentName mAdminName) {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mAdminName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "activity device");
        startActivityForResult(intent,1);
    }
}