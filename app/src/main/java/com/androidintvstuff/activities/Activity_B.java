package com.androidintvstuff.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.androidintvstuff.R;
import com.androidintvstuff.utilities.GlobalVarAndFun;

public class Activity_B extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        GlobalVarAndFun.mLogger("Act_b-------onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        GlobalVarAndFun.mLogger("Act_b-------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        GlobalVarAndFun.mLogger("Act_b-------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalVarAndFun.mLogger("Act_b-------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalVarAndFun.mLogger("Act_b-------onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        GlobalVarAndFun.mLogger("Act_b-------onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalVarAndFun.mLogger("Act_b-------onDestroy");
    }
}
