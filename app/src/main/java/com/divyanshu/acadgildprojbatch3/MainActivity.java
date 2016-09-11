package com.divyanshu.acadgildprojbatch3;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.GsonExmp.Parser_getGsonExmp;

public class MainActivity extends AppCompatActivity {

    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"onCreate Called",Toast.LENGTH_SHORT).show();

        new fetchGSONExmpAsyncTask().execute();
        btn_submit =(Button)findViewById(R.id.btn_submit);
//        btn_submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this," setOnClickListener (SUBMIT) Called",Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(MainActivity.this,Activity2.class);
////                startActivity(intent);
//            }
//        });
//
        btn_submit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this," setOnLongClickListener (SUBMIT) Called",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btn_submit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this," setOnTouchListener (SUBMIT) Called",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"onStart Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,"onResume Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this,"onRestart Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,"onPause Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this,"onStop Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"onDestroy Called",Toast.LENGTH_SHORT).show();
    }





    class fetchGSONExmpAsyncTask extends AsyncTask<String, Void, String> {

        private Exception exception;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected String doInBackground(String... urls) {
            try {
                Parser_getGsonExmp getTruckList = new Parser_getGsonExmp(MainActivity.this);
                return "";
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        }
    }
}
