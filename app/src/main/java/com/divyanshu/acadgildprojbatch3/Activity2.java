package com.divyanshu.acadgildprojbatch3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Divyanshu on 29-06-2016.
 */
public class Activity2 extends Activity{

    TextView question,answer,optionA,optionB,optionC,optionD,score;

    int maxNumber=30;
    int minNumber=1;
    int method = 2;
    int scoreVal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Toast.makeText(Activity2.this," Activity2  onCreate called",Toast.LENGTH_SHORT).show();
        //Logic logic =new Logic(minNumber,maxNumber,method);
        Logic logic =new Logic(minNumber,maxNumber,method,true);

        question = (TextView)findViewById(R.id.question);
        answer = (TextView)findViewById(R.id.answerTXT);
        optionA = (TextView)findViewById(R.id.optionA);
        optionB = (TextView)findViewById(R.id.optionB);
        optionC = (TextView)findViewById(R.id.optionC);
        optionD = (TextView)findViewById(R.id.optionD);
        score = (TextView)findViewById(R.id.score);

        questionCall();

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Logic.optionA==Logic.answer){
                    answer.setBackgroundColor(getResources().getColor(R.color.green));
                    scoreVal +=1;
                }
                else{
                    answer.setBackgroundColor(getResources().getColor(R.color.red));
                    scoreVal -=1;
                }

                questionCall();

            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Logic.optionB==Logic.answer){
                    answer.setBackgroundColor(getResources().getColor(R.color.green));
                    scoreVal +=1;
                }
                else{
                    answer.setBackgroundColor(getResources().getColor(R.color.red));
                    scoreVal -=1;
                }
                questionCall();
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Logic.optionC==Logic.answer){
                    answer.setBackgroundColor(getResources().getColor(R.color.green));
                    scoreVal +=1;
                }
                else{
                    answer.setBackgroundColor(getResources().getColor(R.color.red));
                    scoreVal -=1;
                }
                questionCall();
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Logic.optionD==Logic.answer){
                    answer.setBackgroundColor(getResources().getColor(R.color.green));
                    scoreVal +=1;
                }
                else{
                    answer.setBackgroundColor(getResources().getColor(R.color.red));
                    scoreVal -=1;
                }
                questionCall();
            }
        });
    }

    public void clickCalled(View view){

        Intent intent = new Intent(Activity2.this, Activity2.class);
        startActivity(intent);
        finish();

    }

    public void questionCall(){
       // Logic logic =new Logic(minNumber,maxNumber,method);
        Logic logic =new Logic(minNumber,maxNumber,method,true);
        question.setText(Logic.question);
        answer.setText(Logic.answer+"");
        optionA.setText(Logic.optionA+"");
        optionB.setText(Logic.optionB+"");
        optionC.setText(Logic.optionC+"");
        optionD.setText(Logic.optionD+"");
        score.setText(scoreVal+"");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Activity2.this," Activity2  onStart called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Activity2.this," Activity2  onResume called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(Activity2.this," Activity2  onRestart called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Activity2.this," Activity2  onPause called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(Activity2.this," Activity2  onStop called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Activity2.this," Activity2  onDestroy called",Toast.LENGTH_SHORT).show();
    }
}
