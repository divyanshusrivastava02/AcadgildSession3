package com.divyanshu.acadgildprojbatch3.Batch6;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 07-07-2016.
 */
public class OptionMenuExample extends SampleMain{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionmenu);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.item1:
//                Toast.makeText(getApplicationContext(),"Item 1 Add click",Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.item2:
//                Toast.makeText(getApplicationContext(),"Item 2 DELETE click",Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.item3:
//                Toast.makeText(getApplicationContext(),"Item 3 SEND MAIL click",Toast.LENGTH_SHORT).show();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
