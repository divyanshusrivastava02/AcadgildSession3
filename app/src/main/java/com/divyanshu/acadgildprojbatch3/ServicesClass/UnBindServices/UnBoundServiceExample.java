package com.divyanshu.acadgildprojbatch3.ServicesClass.UnBindServices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 03-08-2016.
 */
public class UnBoundServiceExample extends Activity implements View.OnClickListener {

    Button startServiceBTN, stopServiceBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        startServiceBTN = (Button)findViewById(R.id.startService);
        stopServiceBTN = (Button)findViewById(R.id.stopService);

        startServiceBTN.setOnClickListener(this);
        stopServiceBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.startService:
                Intent startServiceIntent = new Intent(UnBoundServiceExample.this,MyUnBoundServices.class);
                startService(startServiceIntent);
                break;

            case R.id.stopService:
                Intent stopServiceIntent = new Intent(UnBoundServiceExample.this,MyUnBoundServices.class);
                stopService(stopServiceIntent);
                break;
        }

    }
}
