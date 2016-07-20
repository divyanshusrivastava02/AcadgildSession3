package com.divyanshu.acadgildprojbatch3.Sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.divyanshu.acadgildprojbatch3.R;

import java.util.List;

/**
 * Created by Divyanshu on 11-07-2016.
 */
public class AndroidSqliteTutorialActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Inset: ","Inserting values......");

        db.addContacts(new Contacts("SAI 5","8887737373383"));
        db.addContacts(new Contacts("PARTH 6","873624876234"));
        db.addContacts(new Contacts("Priyanka 7","9832873232328723"));
        db.addContacts(new Contacts("RAM 8","382748773284"));


        Log.d("READING : ", "READING all contacts......");

        List<Contacts> contacts = db.getAllContacts();
        for(Contacts cn : contacts){
            String log = "ID: "+cn.get_id()+" , Name: "+cn.get_name()+" ,Phone: "+cn.get_phone_number();
            Log.d("NAME : ",log);
        }

    }
}
