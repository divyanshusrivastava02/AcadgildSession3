package com.divyanshu.acadgildprojbatch3.ServicesClass.BoundServiceActivity;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 03-08-2016.
 */
public class BoundService extends Service {

    private final IBinder myBinder = new MyLocalBinder();
    private Thread backgroundThread;
    private MediaPlayer player;
    private int NOTIFICATION_ID = 102;
    private String TAG="bound";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                playMusic();
            }
        });
        backgroundThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    private void playMusic(){
        if(player!=null){
            player.release();
        }
        player =MediaPlayer.create(this, R.raw.thunder);
        player.setLooping(true);
    }

    public void startPlaying(){
        if(!player.isPlaying()){
            player.start();
        }
    }

    public void stopPlaying(){
        if(player.isPlaying()){
            player.pause();
        }
    }


    public class MyLocalBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        player.release();
        player = null;

        Thread threadDummy = backgroundThread;
        backgroundThread=null;
        threadDummy.interrupt();

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Toast.makeText(getApplicationContext(),"Cancelling Notification is called", Toast.LENGTH_SHORT).show();
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
