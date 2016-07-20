package com.divyanshu.acadgildprojbatch3.Dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 17-07-2016.
 */
public class DialogActivity extends FragmentActivity {

    Button dButton;
    Button alertFragButton;
    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog_main);


        dButton = (Button)findViewById(R.id.dbutton);
        alertFragButton = (Button)findViewById(R.id.alertFragmentButton);

        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DialogActivity.this)
                        .setIcon(R.drawable.home)
                        .setTitle("Alert Acadgild Title")
                        .setMessage("Are you sure you want to DELETE this.....!")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("NO WAY", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DialogActivity.this,"User Select no button!",Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });

        alertFragButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDfragment alertDialog = new AlertDfragment();
                alertDialog.show(fm,"Alert 2nd Dialog Fragment");
            }
        });

    }
}
