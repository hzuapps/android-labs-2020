package edu.hzuapps.androidlabs.application;

import android.app.Application;
import android.content.Context;

/**
 * 创建人: zhang376358913
 * 创建时间: 2019/5/10 23:23
 * 类描述:
 * 修改人: zhang376358913
 * 修改时间: zhang376358913
 * 修改备注:
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
