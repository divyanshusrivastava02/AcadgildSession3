package com.divyanshu.acadgildprojbatch3.Batch6;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 07-07-2016.
 */
public class ContextMenuExample extends Activity {
    ListView listView1;
    String cources[]= {"Android","Cloud compution", "Hadoop","PHp","Java",".Net","SQL"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextmenu);
        listView1 = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cources);
        listView1.setAdapter(adapter);

        registerForContextMenu(listView1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Acadgild Menu");
        menu.add(0,v.getId(), 0,"Opt the course");
        menu.add(0,v.getId(),0,"Payment Option");
        menu.add(0,v.getId(),0,"Test Series");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle()=="Opt the course"){
            Toast.makeText(getApplicationContext(),"Opt the course  click",Toast.LENGTH_SHORT).show();
        }
        else  if(item.getTitle()=="Payment Option"){
            Toast.makeText(getApplicationContext(),"Payment Option click",Toast.LENGTH_SHORT).show();
        }
        else  if(item.getTitle()=="Test Series"){
            Toast.makeText(getApplicationContext(),"Test Series click",Toast.LENGTH_SHORT).show();
        }
        else {
            return false;
        }
        return true;
    }
}
