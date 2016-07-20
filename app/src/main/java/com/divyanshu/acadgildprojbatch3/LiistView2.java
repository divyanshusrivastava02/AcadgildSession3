package com.divyanshu.acadgildprojbatch3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divyanshu on 30-06-2016.
 */
public class LiistView2 extends Activity{

    List<String> listItems;
    boolean val = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);

        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.rl);
        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 10;
        params.topMargin = 200;

        Button btn = (Button)findViewById(R.id.button1);
        final ListView list = new ListView(LiistView2.this);

        listItems = new ArrayList<String>();
        listItems.add("Mumbai");
        listItems.add("Delhi");
        listItems.add("Goa");
        listItems.add("Gurgaon");
        listItems.add("Ahamedabad");
        listItems.add("London");
        listItems.add("Uk");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                if(val) {

                    ArrayAdapter<String> adp = new ArrayAdapter<String>(LiistView2.this, android.R.layout.simple_dropdown_item_1line, listItems);
                    adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    list.setAdapter(adp);
                    list.setLayoutParams(params);
                    rl.removeView(list);
                    rl.addView(list);
                    val = false;

//                }
            }
        });

    }
}
