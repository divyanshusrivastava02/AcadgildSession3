package com.divyanshu.acadgildprojbatch3.ViewPagerAcadgild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.divyanshu.acadgildprojbatch3.R;

/**
 * Created by Divyanshu on 25-07-2016.
 */
public class FragmentTab1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmenttab1,container,false);
    }
}
