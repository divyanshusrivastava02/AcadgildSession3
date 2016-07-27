package com.divyanshu.acadgildprojbatch3.FragmentsExmp;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Divyanshu on 21-07-2016.
 */
public class DetailsFragment extends Fragment {
    public static DetailsFragment newInstance(int index){
        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index",index);
        f.setArguments(args);
        return  f;
    }

    public int getShowIndex(){
        return  getArguments().getInt("index",0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView text = new TextView(getActivity());
        text.setText(Data.DETAILS[getShowIndex()]);
        text.setTextColor(Color.WHITE);
        return text;
    }
}
