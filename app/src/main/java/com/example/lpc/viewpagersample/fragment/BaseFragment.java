package com.example.lpc.viewpagersample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by lpc on 2016/7/18.
 */
public abstract class BaseFragment extends Fragment {



    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true ;
        prepareFetchData() ;
    }

    public abstract void fetchData() ;

    public boolean prepareFetchData() {
        return prepareFetchData(false) ;
    }

    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData() ;
            isDataInitiated = true ;
            return true ;
        }
        return false ;
    }
}
