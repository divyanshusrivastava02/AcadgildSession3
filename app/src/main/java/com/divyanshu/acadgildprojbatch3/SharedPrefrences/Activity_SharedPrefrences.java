package com.divyanshu.acadgildprojbatch3.SharedPrefrences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 14-07-2016.
 */
public class Activity_SharedPrefrences extends Activity {


    Button btn_setting, btn_show,btn_savevalues,btn_showvalues;
    EditText userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedprefrences);

        userName = (EditText)findViewById(R.id.userName);
        password= (EditText)findViewById(R.id.password);
        btn_setting = (Button)findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentSetting = new Intent(Activity_SharedPrefrences.this, SettingActivity.class);
                startActivity(intentSetting);
            }
        });



        btn_show = (Button)findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //throwANR();
            }
        });


        btn_savevalues = (Button)findViewById(R.id.btn_savevalues);
        btn_savevalues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("Acadgild", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("usernameKEY",userName.getText().toString());
                editor.putString("passwordKEY",password.getText().toString());

                editor.putInt("INT EXMP",1);
                editor.putBoolean("bool exmp", true);

                editor.commit();
            }
        });


        btn_showvalues = (Button)findViewById(R.id.btn_showvalues);
        btn_showvalues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("Acadgild", MODE_PRIVATE);
                String fetchUerName = pref.getString("usernameKEY","No Value saved yet.....!");
                String fetchPassword = pref.getString("passwordKEY","No password stored yet....! #$#@#");

                int val = pref.getInt("INT EXMP",0);
                boolean valBool = pref.getBoolean("bool exmp",false);
                Toast.makeText(Activity_SharedPrefrences.this,"Username: "+fetchUerName+"  Password: "+fetchPassword+"   "+val+" "+valBool,Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void throwANR(){
        long finishTime = System.currentTimeMillis() + 20*100;

        while (System.currentTimeMillis() <finishTime){
            synchronized (this){
                try{
                    wait(finishTime - System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
