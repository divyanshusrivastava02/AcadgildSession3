package com.divyanshu.acadgildprojbatch3.Handler;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.divyanshu.acadgildprojbatch3.R;

import java.lang.ref.WeakReference;

/**
 * Created by Divyanshu on 29-07-2016.
 */
public class HandlerActivity extends Activity {

    private  final static int SET_PROGRESS_BAR_VISIBILITY = 0;
    private final static int PROGESS_UPDATE = 1;
    private final static int SET_BITMAP=2;

    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private int mDelay =500;

    static class UIHandler extends Handler{
        WeakReference<HandlerActivity> mParent;

        public UIHandler(WeakReference<HandlerActivity> parent){
            mParent = parent;
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerActivity parent = mParent.get();

            if(null!=mParent){
                switch (msg.what){
                    case SET_PROGRESS_BAR_VISIBILITY:
                        parent.getmProgressBar().setVisibility((Integer)msg.obj);
                        break;
                    case PROGESS_UPDATE:
                        parent.getmProgressBar().setProgress((Integer)msg.obj);
                        break;
                    case SET_BITMAP:
                        parent.getmImageView().setImageBitmap((Bitmap)msg.obj);
                        break;
                }
            }
        }
    }


    Handler handler= new UIHandler(new WeakReference<HandlerActivity>(this));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mImageView = (ImageView)findViewById(R.id.imageView);
        mProgressBar = (ProgressBar)findViewById(R.id.progressbar2);
        Button button = (Button)findViewById(R.id.loadbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new LoadIconTask(R.drawable.home,handler)).start();
            }
        });
    }


    private class LoadIconTask implements Runnable{
        private final int resID;
        private final Handler handler;

        LoadIconTask(int resId, Handler handler){
            this.resID = resId;
            this.handler = handler;
        }
        @Override
        public void run() {

            Message msg = handler.obtainMessage(SET_PROGRESS_BAR_VISIBILITY, ProgressBar.VISIBLE);
            handler.sendMessage(msg);
            final Bitmap tmp = BitmapFactory.decodeResource(getResources(),resID);
            for(int i=1;i<11;i++){
                sleep();
                msg  = handler.obtainMessage(PROGESS_UPDATE,i*10);
                handler.sendMessage(msg);

            }

            msg = handler.obtainMessage(SET_BITMAP,tmp);
            handler.sendMessage(msg);

            msg = handler.obtainMessage(SET_PROGRESS_BAR_VISIBILITY,ProgressBar.INVISIBLE);
            handler.sendMessage(msg);
        }
    }

    private void sleep(){
        try{
            Thread.sleep(mDelay);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public  ImageView getmImageView(){
        return  mImageView;
    }
    public ProgressBar getmProgressBar(){
        return mProgressBar;
    }


}
