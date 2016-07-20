package com.divyanshu.acadgildprojbatch3.Dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 17-07-2016.
 */
public class AlertDfragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.upload_photo)
                .setTitle("AlertDFragment Acadgild Title")
                .setMessage("Are you sure you want to DELETE ALert D Fragment.....!")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                })
                .setNegativeButton("NO WAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getBaseContext(),"User Select no button!",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                }).create();
    }
}
