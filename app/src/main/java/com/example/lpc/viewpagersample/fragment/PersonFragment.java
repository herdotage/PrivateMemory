package com.example.lpc.viewpagersample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lpc.viewpagersample.R;

/**
 * Created by lpc on 2016/7/18.
 */
public class PersonFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_person,container,false) ;
        return v ;
    }

    @Override
    public void fetchData() {

    }
}
