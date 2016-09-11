package com.divyanshu.acadgildprojbatch3.Sensors;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 25-08-2016.
 */
public class SensorActivity extends Activity implements SensorEventListener{
    public  SensorManager sensorManager;
    TextView xCoor;
    TextView yCoor;
    TextView zCoor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        xCoor = (TextView)findViewById(R.id.xcoor);
        yCoor = (TextView)findViewById(R.id.ycoor);
        zCoor = (TextView)findViewById(R.id.zcoor);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),sensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            xCoor.setText("X : "+x);
            yCoor.setText("Y : "+y);
            zCoor.setText("Z : "+z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
