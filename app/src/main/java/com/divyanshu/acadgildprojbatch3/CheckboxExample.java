package com.divyanshu.acadgildprojbatch3;

/**
 * Created by Divyanshu on 29-06-2016.
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
public class CheckboxExample extends Activity {

    CheckBox c1, c2, c3;
    Button b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_example);

        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);

        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                if((c1.isChecked()==false) && (c2.isChecked()==false) && (c3.isChecked()==false))
                {
                    Toast.makeText(getBaseContext(),"None Package Selected",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String str = null;

                    if(c1.isChecked())
                    {
                        str="Package 1";
                    }
                    if(c2.isChecked())
                    {
                        str=str.concat(" Package 2");
                    }
                    if(c3.isChecked())
                    {
                        str=str.concat(" Package 3");
                    }

                    int i=str.length();
                    String str1=" are selected";
                    String str2=" is selected";

                    if(i>9)
                    {
                        str=str.concat(str1);

                        Toast.makeText(getBaseContext(), str,
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        str=str.concat(str2);

                        Toast.makeText(getBaseContext(), str,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        b.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub

                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);

                Toast.makeText(getBaseContext(), "Long Pressed & Refreshed ChekBoxes", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }


}