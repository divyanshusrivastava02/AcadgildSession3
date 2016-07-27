package com.divyanshu.acadgildprojbatch3.ViewPagerAcadgild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 25-07-2016.
 */
public class ViewPagerExmp extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_exmp);

        ViewPager viewPager =(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }
}
