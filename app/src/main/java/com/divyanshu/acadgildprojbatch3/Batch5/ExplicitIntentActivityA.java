package com.divyanshu.acadgildprojbatch3.Batch5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 06-07-2016.
 */
public class ExplicitIntentActivityA extends Activity{

    Button btnSubmit;
    WebView webview;
    EditText et_inputName;
    String userInputVal;

    public static String somevalue = "jkhfkjsfsd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_example_a);

        webview = (WebView)findViewById(R.id.webview);
        et_inputName = (EditText)findViewById(R.id.et_inputName);

        btnSubmit = (Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                userInputVal = et_inputName.getText().toString();
//                Bundle bundle = new Bundle();
//                bundle.putString("USERVALUE",userInputVal);

                Intent intent = new Intent(getApplicationContext(),ExplicitIntentActivityB.class);
                intent.putExtra("Password",userInputVal);
                startActivity(intent);
               // finish();

                /**
                 *   THIS IS THE EXAMPLE FOR IMPLICIT INTENT
                 */

//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://acadgild.com/"));
//                startActivity(intent);

//                webview.loadUrl("https://acadgild.com/");


//                Intent i = new Intent(Intent.ACTION_SEND);
//                i.setType("message/rtc822");
//                i.putExtra(Intent.EXTRA_EMAIL,new String[]{"sai.jagadish.d@gmail.com"});
//                i.putExtra(Intent.EXTRA_SUBJECT,"This is a subject");
//                i.putExtra(Intent.EXTRA_TEXT,"THis is the body of the email");
//                try{
//                    startActivity(Intent.createChooser(i,"Send mail..."));
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                    Toast.makeText(ExplicitIntentActivityA.this,"There is no mail configure!!!!!",Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }
}
