package com.predictor.galaxyutilslibrary.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class GalaxyBaseFragment extends Fragment {
    public Typeface typeface;

    public GalaxyBaseFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater, container);
        return view;
    }

    protected abstract View initView(LayoutInflater inflater, ViewGroup container);


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //逻辑的操作
        initData();
        initListener();
    }

    protected abstract void initData();

    protected abstract void initListener();
}
