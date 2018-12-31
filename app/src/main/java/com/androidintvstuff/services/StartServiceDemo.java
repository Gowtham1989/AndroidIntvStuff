package com.androidintvstuff.services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.androidintvstuff.R;
import com.androidintvstuff.utilities.GlobalVarAndFun;



public class StartServiceDemo extends Service {

    MediaPlayer mMediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
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
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        GlobalVarAndFun.mLogger("OnStartCommand:------");
        try {
            Notification notification = getNotification("MyService is running");
            startForeground(startId, notification);
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
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();

    }

    public Notification getNotification(String message) {

        Notification notification;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder builder = new Notification.Builder(this, TypesOfservices.id1)
                    .setContentTitle(getString(R.string.app_name))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setOngoing(true)
                    .setChannelId(TypesOfservices.id1)
                    .setContentText(message)
                    .setContentTitle("Service")
                    .setAutoCancel(true);
            notification = builder.build();
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setContentTitle(getString(R.string.app_name))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setOngoing(true)
                    .setContentText(message)
                    .setContentTitle("Service")
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setAutoCancel(true);
            notification = builder.build();
        }
        return notification;
    }
}
