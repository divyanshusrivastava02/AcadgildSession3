package com.divyanshu.acadgildprojbatch3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Divyanshu on 29-06-2016.
 */
public class Activity2 extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Toast.makeText(Activity2.this," Activity2  onCreate called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Activity2.this," Activity2  onStart called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Activity2.this," Activity2  onResume called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(Activity2.this," Activity2  onRestart called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Activity2.this," Activity2  onPause called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(Activity2.this," Activity2  onStop called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Activity2.this," Activity2  onDestroy called",Toast.LENGTH_SHORT).show();
    }
}
