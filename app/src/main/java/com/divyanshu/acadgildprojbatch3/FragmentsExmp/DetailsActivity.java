package com.divyanshu.acadgildprojbatch3.FragmentsExmp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Divyanshu on 21-07-2016.
 */
public class DetailsActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DetailsFragment details = new DetailsFragment();

        details.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().add(android.R.id.content,details).commit();
    }
}
