package com.androidintvstuff.services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import com.androidintvstuff.utilities.GlobalVarAndFun;

public class BoundServiceDemo extends Service {

    private IBinder mBinder = new MyLocalBinder();
    MediaPlayer mMediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = new MediaPlayer();
        try {
            GlobalVarAndFun.mLogger("Path of the file: --------"+Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music/Dheera_Dheera.mp3");
            mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music/Dheera_Dheera.mp3");
        } catch (Exception e) {
            GlobalVarAndFun.mLogger("Exception: -----"+e.getMessage());
        }
        mMediaPlayer.setLooping(false);
    }

    @Override
    public IBinder onBind(Intent intent) {
        GlobalVarAndFun.mLogger("OnBind: ------------");
        try {
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.release();
                    stopSelf();
                }
            });
        } catch (Exception e) {
            GlobalVarAndFun.mLogger("Exception:--------"+ e.getMessage());
        }
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        GlobalVarAndFun.mLogger("OnRebind: -----------");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        GlobalVarAndFun.mLogger("OnUnbind: ------------");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GlobalVarAndFun.mLogger("OnDestroy: -----------");
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }

    public class MyLocalBinder extends Binder {
        BoundServiceDemo getService() {
            return BoundServiceDemo.this;
        }
    }

}
