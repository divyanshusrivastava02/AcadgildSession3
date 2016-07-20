package com.divyanshu.acadgildprojbatch3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import android.widget.TimePicker.OnTimeChangedListener;

/**
 * Created by Divyanshu on 30-06-2016.
 */
public class TimePickerExample extends Activity {


    Button showTime;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        timePicker = (TimePicker)findViewById(R.id.timepicker);
        showTime = (Button)findViewById(R.id.showTime);



        showTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TimePickerExample.this,"You have selected Time : "+timePicker.getCurrentHour()+" : "+ timePicker.getCurrentMinute(),Toast.LENGTH_SHORT).show();

            }
        });

        timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(TimePickerExample.this,"You  Time : "+i+" : "+i1,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
