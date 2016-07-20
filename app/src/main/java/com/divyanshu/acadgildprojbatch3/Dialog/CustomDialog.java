package com.divyanshu.acadgildprojbatch3.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 17-07-2016.
 */
public class CustomDialog extends Activity {

    EditText etSearch;
    Button btn, btnSearch, btnCancel;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);

        btn = (Button)findViewById(R.id.alertFragmentButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }

    public void showCustomDialog(){
        dialog = new Dialog(CustomDialog.this,android.R.style.Theme_Dialog);
        dialog.setContentView(R.layout.layout_customdialog);
        etSearch = (EditText)dialog.findViewById(R.id.etsearch);

        btnSearch = (Button)dialog.findViewById(R.id.btnsearch);
        btnCancel = (Button)dialog.findViewById(R.id.btncancel);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = etSearch.getText().toString().trim();
                if(TextUtils.isEmpty(userInput)){
                    Toast.makeText(CustomDialog.this,"Search has no value......",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CustomDialog.this,"Search for :"+userInput,Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
