package com.divyanshu.acadgildprojbatch3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Divyanshu on 30-06-2016.
 */
public class DatePickerExample extends Activity {

    DatePicker datePicker;
    Button btnPick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);


        datePicker  = (DatePicker)findViewById(R.id.datepicker);
        btnPick = (Button)findViewById(R.id.showDate);

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatePickerExample.this,"You have selected : "+datePicker.getDayOfMonth()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getYear(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
