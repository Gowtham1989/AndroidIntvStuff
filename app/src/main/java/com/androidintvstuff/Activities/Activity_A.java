package com.androidintvstuff.Activities;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androidintvstuff.R;
import com.androidintvstuff.utilities.GlobalVarAndFun;

public class Activity_A extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        GlobalVarAndFun.mLogger("-------onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        GlobalVarAndFun.mLogger("-------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        GlobalVarAndFun.mLogger("-------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalVarAndFun.mLogger("-------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalVarAndFun.mLogger("-------onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        GlobalVarAndFun.mLogger("-------onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalVarAndFun.mLogger("-------onDestroy");
    }
}
