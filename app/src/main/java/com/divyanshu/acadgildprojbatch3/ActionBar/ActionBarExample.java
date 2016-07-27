package com.divyanshu.acadgildprojbatch3.ActionBar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 25-07-2016.
 */
public class ActionBarExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar_example);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){

            case R.id.item1:
                Intent dialer = new Intent(Intent.ACTION_DIAL);
                startActivity(dialer);
                return true;

            case R.id.item2:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent,1234);
                return true;

            case R.id.item3:
                Toast.makeText(ActionBarExample.this,"item3",Toast.LENGTH_LONG).show();
                return true;

            case R.id.item4:
                Toast.makeText(ActionBarExample.this,"item4",Toast.LENGTH_LONG).show();
                return true;

            case R.id.item5:
                Toast.makeText(ActionBarExample.this,"item5",Toast.LENGTH_LONG).show();
                return true;

            case R.id.item6:
                Toast.makeText(ActionBarExample.this,"item6",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234 && requestCode==RESULT_OK){
            String voice_txt = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0);
            Toast.makeText(ActionBarExample.this,voice_txt,Toast.LENGTH_LONG).show();
        }
    }
}
