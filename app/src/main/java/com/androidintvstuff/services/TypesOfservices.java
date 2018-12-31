package com.androidintvstuff.services;

import android.Manifest;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.androidintvstuff.R;
import com.androidintvstuff.utilities.GlobalVarAndFun;

public class TypesOfservices extends AppCompatActivity implements View.OnClickListener {

    public static String id1 = "test_channel_01";

    Button mStartService;
    Button mBoundService;

    BoundServiceDemo boundServiceDemo;
    boolean mServiceBound = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.typeofservices);

        mStartService = (Button) findViewById(R.id.mStartService);
        mBoundService = (Button) findViewById(R.id.mBoundService);
        mStartService.setOnClickListener(this);
        mBoundService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mStartService:
                if(isStoragePermissionGranted()){
                    createchannel();
                    Intent number5 = new Intent(getBaseContext(), StartServiceDemo.class);
                    number5.putExtra("times", 5);
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        startForegroundService(number5);
                    } else {
                        startService(number5);
                    }
                } else {
                    GlobalVarAndFun.mLogger("WRITE_PERMISSION Disabled");
                }
                break;
            case R.id.mBoundService:
                mShowDialog();
            default:
                break;
        }
    }

    private void mShowDialog() {
        final Dialog mDialog = new Dialog(this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setCancelable(true);
        mDialog.setContentView(R.layout.media_dialog);
        Button mPlay =  mDialog.findViewById(R.id.mPlayMusic);
        Button mStop =  mDialog.findViewById(R.id.mStopMusic);
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypesOfservices.this, BoundServiceDemo.class);
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mServiceBound){
                    unbindService(mServiceConnection);
                    mServiceBound = false;
                    Intent intent = new Intent(TypesOfservices.this,BoundServiceDemo.class);
                    stopService(intent);
                }
            }
        });
        mDialog.show();
    }

    private void createchannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannel mChannel = new NotificationChannel(id1,
                    getString(R.string.channel_name),
                    NotificationManager.IMPORTANCE_LOW);
            mChannel.setDescription(getString(R.string.channel_description));
            mChannel.enableLights(true);
            mChannel.setShowBadge(true);
            nm.createNotificationChannel(mChannel);
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundServiceDemo.MyLocalBinder myLocalBinder = (BoundServiceDemo.MyLocalBinder) service;
            boundServiceDemo = myLocalBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }
    };

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                GlobalVarAndFun.mLogger("Permission is granted");
                return true;
            } else {

                GlobalVarAndFun.mLogger("Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            GlobalVarAndFun.mLogger("Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            GlobalVarAndFun.mLogger("Permission: "+permissions[0]+ "was "+grantResults[0]);
        }
    }
}
