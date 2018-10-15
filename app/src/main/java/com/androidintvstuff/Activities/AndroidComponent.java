package com.androidintvstuff.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidintvstuff.R;

/**
 * Created by Gowtham on 10/15/2018.
 */
public class AndroidComponent extends AppCompatActivity implements View.OnClickListener {

    Button mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_component);

        mActivity = (Button) findViewById(R.id.mActivity);
        mActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mActivity:
                startActivity(new Intent(AndroidComponent.this,Activity_A.class));
                break;
        }

    }
}
