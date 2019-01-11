package com.pay.todayorpay.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pay.todayorpay.R;

public class FragmentFail extends BaseFragment {
    public static final String TAG = FragmentFail.class.getSimpleName();
    FragmentFail _instance;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fail, container, false);
        _instance = this;
        return view;
    }

    @Override
    public void onDestroy() {
        _instance = null;
        super.onDestroy();
    }
}