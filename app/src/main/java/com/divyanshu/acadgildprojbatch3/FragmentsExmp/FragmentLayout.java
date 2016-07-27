package com.divyanshu.acadgildprojbatch3.FragmentsExmp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 21-07-2016.
 */
public class FragmentLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Our first activity called: OnCreate() ",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_fragment_layout);
    }
}
