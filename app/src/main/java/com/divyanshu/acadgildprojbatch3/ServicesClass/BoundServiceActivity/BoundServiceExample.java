package com.divyanshu.acadgildprojbatch3.ServicesClass.BoundServiceActivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 03-08-2016.
 */
public class BoundServiceExample extends Activity {

    private  int REQUEST_CODE = 101;
    private int NOTIFICATION_ID = 102;
    private boolean isBound;
    private BoundService serviceReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Intent intent = new Intent(this,BoundService.class);
        startService(intent);
        sendNotification();

        Button startService  = (Button)findViewById(R.id.startService);
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceReference.startPlaying();
            }
        });

        Button stopService = (Button)findViewById(R.id.stopService);
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceReference.stopPlaying();
            }
        });

    }



    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            serviceReference = ((BoundService.MyLocalBinder)iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            serviceReference = null;
            isBound = false;
        }
    };


    private void doUnBindService(){
        Toast.makeText(getApplicationContext(),"Unbind service called",Toast.LENGTH_SHORT).show();
        unbindService(myConnection);
        isBound = false;
    }

    private void doBindService(){
        Toast.makeText(getApplicationContext(),"Bind service called",Toast.LENGTH_SHORT).show();
        if(!isBound){
            Intent bindIntent = new Intent(this,BoundService.class);
            isBound = bindService(bindIntent,myConnection,BIND_AUTO_CREATE);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        doUnBindService();
    }

    @Override
    protected void onStart() {
        super.onStart();
        doBindService();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(isFinishing()){
            Intent intentService = new Intent(this,BoundService.class);
            stopService(intentService);
        }
    }

    private void sendNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.home)
                .setContentTitle("Service Running")
                .setTicker("Music Playing")
                .setWhen(System.currentTimeMillis())
                .setOngoing(true);

        Intent startIntent = new Intent(this, BoundServiceExample.class);
        PendingIntent contentIntent = PendingIntent.getActivity(BoundServiceExample.this,REQUEST_CODE,startIntent,0);
        builder.setContentIntent(contentIntent);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,notification);
    }
}
