package com.divyanshu.acadgildprojbatch3.BroadcastReceiverClass;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.NotificationCompat.Builder;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 01-08-2016.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    private  static  final int NOTIFy_ID = 201;
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder mBuilder = (Builder)new Builder(
                context.getApplicationContext())
                .setSmallIcon(R.drawable.fab_create)
                .setContentTitle("MAIN TITLE")
                .setContentText("This is the text we have to show the user");
        mBuilder.setAutoCancel(true);


        Intent resultIntent = new Intent(context,NotificationMessage.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context,0,resultIntent,0);
        mBuilder.setContentIntent(resultPendingIntent);


        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFy_ID,mBuilder.build());
    }
}
