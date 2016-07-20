package com.divyanshu.acadgildprojbatch3.AsyncTask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 14-07-2016.
 */
public class AsysnTask extends Activity {

    private final static  String TAG="Thread cycle";
    ImageView imageview;
    ProgressBar progressbar;
    int mDelay = 500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        imageview = (ImageView) findViewById(R.id.imageview);
        progressbar = (ProgressBar)findViewById(R.id.progressbar);

        Button button = (Button)findViewById(R.id.loadbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new LoadIconTask().execute(R.drawable.food);
            }
        });
    }


    class LoadIconTask extends AsyncTask<Integer,Integer,Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressbar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {
           Bitmap tmp = BitmapFactory.decodeResource(getResources(),integers[0]);
            for(int i=1;i<11;i++){
                sleep();
                publishProgress(i*10);
            }
            return  tmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressbar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressbar.setVisibility(ProgressBar.INVISIBLE);
            imageview.setImageBitmap(bitmap);
        }

        public void sleep()
        {
            try{
                Thread.sleep(mDelay);
            }catch (InterruptedException e){
                e.printStackTrace();

            }
        }
    }
}
