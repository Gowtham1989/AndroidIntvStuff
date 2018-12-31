package com.androidintvstuff.activities;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.androidintvstuff.R;
import com.androidintvstuff.fragment.FragmentOne;
import com.androidintvstuff.utilities.GlobalVarAndFun;


public class Fragment_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        GlobalVarAndFun.mLogger("In fragment activity...");

        FragmentManager fm = getSupportFragmentManager();
        FragmentOne mFragOne = new FragmentOne();
        mFragOne.show(fm,"FragmentOne");
    }
}
