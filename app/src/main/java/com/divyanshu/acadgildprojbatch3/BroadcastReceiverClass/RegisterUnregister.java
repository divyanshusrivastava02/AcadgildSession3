package com.divyanshu.acadgildprojbatch3.BroadcastReceiverClass;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 01-08-2016.
 */
public class RegisterUnregister extends Activity {

    UserDefinedBroadcastReceiver broadcastReceiver = new UserDefinedBroadcastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_unregister);
    }

    public void registerBroadcastClick(View view){
        Toast.makeText(RegisterUnregister.this,"Enable bradcast receiver", Toast.LENGTH_SHORT).show();
    }

    public void unregisterBroadcastClick(View v){
        Toast.makeText(RegisterUnregister.this,"Disable bradcast receiver", Toast.LENGTH_SHORT).show();
    }

}
