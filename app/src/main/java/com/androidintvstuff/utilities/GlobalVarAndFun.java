package com.androidintvstuff.utilities;

import android.util.Log;

public class GlobalVarAndFun {

    public static String LOG_TAG = "Gowtham";
    public static String PROJECTNAME = "AIS";
    public static String[] intvTopics = new String[]{
            "Activity",
            "Fragment",
            "Service",
            "Broadcast Receiver",
            "Content Provider",
            "Handler",
    };
    public static String[] colors = new String[]{
            "Red",
            "Violet",
            "Gold",
            "Chocolate",
            "Yellow",
            "Pink",
            "Brown",
            "Purple",
            "Maroon",
            "Green"
    };

    public static void mLogger(String str){
        Log.d(LOG_TAG,""+str);
    }
}
