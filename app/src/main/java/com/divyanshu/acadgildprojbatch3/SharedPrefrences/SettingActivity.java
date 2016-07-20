package com.divyanshu.acadgildprojbatch3.SharedPrefrences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 14-07-2016.
 */
public class SettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
