package com.divyanshu.acadgildprojbatch3.BroadcastReceiverClass;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Divyanshu on 01-08-2016.
 */
public class UserDefinedBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equalsIgnoreCase("com.divyanshu.acadgildprojbatch3")){
            StringBuilder msgStr = new StringBuilder("Current Time : ");
            Format formatter = new SimpleDateFormat("hh:mm:ss a");
            msgStr.append(formatter.format(new Date()));
            Toast.makeText(context,msgStr,Toast.LENGTH_SHORT).show();
        }
    }
}
