package com.divyanshu.acadgildprojbatch3.Batch5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 06-07-2016.
 */
public class ExplicitIntentActivityB extends Activity{

    TextView tv_nameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_example_b);


        tv_nameTxt = (TextView)findViewById(R.id.tv_nameTxt);
//        Bundle bundle = getIntent().getExtras();
//        String value = bundle.getString("USERVALUE").toString();

        String value = getIntent().getExtras().getString("Password");

        tv_nameTxt.setText(value+ ExplicitIntentActivityA.somevalue);
    }
}
