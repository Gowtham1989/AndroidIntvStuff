package com.androidintvstuff.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.androidintvstuff.R;
import com.androidintvstuff.utilities.GlobalVarAndFun;

public class Activity_A extends AppCompatActivity {

    Button mNextActivity;
    Button mLaunchDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        GlobalVarAndFun.mLogger("Act_a-------onCreate");

        mNextActivity = (Button) findViewById(R.id.mAct_a);
        mLaunchDialog = (Button) findViewById(R.id.mDialog);
        mNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_A.this,Activity_B.class));
            }
        });
        mLaunchDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(Activity_A.this).create();
                alertDialog.setTitle("Hi");
                alertDialog.setMessage("This is my app");
                alertDialog.show();
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            GlobalVarAndFun.mLogger("Lanscape");
        }else{
            GlobalVarAndFun.mLogger("Protrait");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        GlobalVarAndFun.mLogger("Act_a-------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        GlobalVarAndFun.mLogger("Act_a-------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalVarAndFun.mLogger("Act_a-------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalVarAndFun.mLogger("Act_a-------onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        GlobalVarAndFun.mLogger("Act_a-------onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalVarAndFun.mLogger("Act_a-------onDestroy");
    }
}
