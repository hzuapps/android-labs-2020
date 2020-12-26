package edu.hzuapps.androidlabs.net1814080903127;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {
//接收广播
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, ShowTip.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
