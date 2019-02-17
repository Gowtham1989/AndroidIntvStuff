package com.androidintvstuff.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.androidintvstuff.R;
import com.androidintvstuff.adapters.IntvTopicsAdapter;
import com.androidintvstuff.model.IntvTopics;
import com.androidintvstuff.services.TypesOfservices;
import com.androidintvstuff.utilities.GlobalVarAndFun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Gowtham on 10/15/2018.
 */
public class AndroidComponent extends AppCompatActivity {

    Button mActivity;
    Button mFragment;
    Button mService;
    Button mHandler;

    RecyclerView mIntvTopics;
    private IntvTopicsAdapter mIntvTopicsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_component);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(GlobalVarAndFun.PROJECTNAME);

        mIntvTopics = (RecyclerView) findViewById(R.id.mIntvTopics);
        List<IntvTopics> intvTopicsList = new ArrayList<IntvTopics>();

        for(int i=0;i<=GlobalVarAndFun.intvTopics.length -1;i++){
            IntvTopics intvTopics = new IntvTopics(GlobalVarAndFun.intvTopics[i],
                    GlobalVarAndFun.colors[ResourcesCompat.getColor(getResources(),
                            new Random().nextInt(GlobalVarAndFun.colors.length),null)]);
            intvTopicsList.add(intvTopics);
        }

        mIntvTopicsAdapter = new IntvTopicsAdapter(intvTopicsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mIntvTopics.setLayoutManager(mLayoutManager);
        mIntvTopics.setItemAnimator(new DefaultItemAnimator());
        mIntvTopics.setAdapter(mIntvTopicsAdapter);

        /*int colorIndex = new Random().nextInt(GlobalVarAndFun.colors.length);
        GlobalVarAndFun.mLogger("Random color: "+GlobalVarAndFun.colors[colorIndex]);*/

       /* mActivity = (Button) findViewById(R.id.mActivity);
        mFragment = (Button) findViewById(R.id.mFragment);
        mService = (Button) findViewById(R.id.mService);
        mHandler = (Button) findViewById(R.id.mHandler);
        mActivity.setOnClickListener(this);
        mFragment.setOnClickListener(this);
        mService.setOnClickListener(this);
        mHandler.setOnClickListener(this);*/
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mActivity:
                startActivity(new Intent(AndroidComponent.this,Activity_A.class));
                break;
            case R.id.mFragment:
                startActivity(new Intent(AndroidComponent.this,Fragment_Activity.class));
                break;
            case R.id.mService:
                startActivity(new Intent(AndroidComponent.this,TypesOfservices.class));
                break;
            case R.id.mHandler:
                startActivity(new Intent(AndroidComponent.this,HandlerActivity.class));
                break;
            default:
                break;
        }

    }*/
}
