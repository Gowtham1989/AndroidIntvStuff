package com.androidintvstuff.utilities;

import android.util.Log;

public class GlobalVarAndFun {

    public static String LOG_TAG = "AndroidIntvStuff";

    public static void mLogger(String str){
        Log.d(LOG_TAG,""+str);
    }
}
