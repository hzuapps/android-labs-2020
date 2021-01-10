package edu.hzuapps.androidlabs.util;

import android.util.Log;

import edu.hzuapps.androidlabs.BuildConfig;

/**
 * 创建人: zhang376358913
 * 创建时间: 2019/5/8 23:21
 * 类描述:
 * 修改人: zhang376358913
 * 修改时间: zhang376358913
 * 修改备注:
 */
public class LogUtil {

    private final static boolean DEBUG = BuildConfig.DEBUG;

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void i(String tag, String msg, Exception e) {
        if (DEBUG) {
            Log.i(tag, msg, e);
        }
    }

    public static void d(String tag, String msg, Exception e) {
        if (DEBUG) {
            Log.d(tag, msg, e);
        }
    }

    public static void w(String tag, String msg, Exception e) {
        if (DEBUG) {
            Log.w(tag, msg, e);
        }
    }

    public static void e(String tag, String msg, Exception e) {
        if (DEBUG) {
            Log.e(tag, msg, e);
        }
    }
}
