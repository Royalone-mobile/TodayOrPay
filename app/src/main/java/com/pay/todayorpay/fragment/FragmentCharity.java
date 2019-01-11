package com.pay.todayorpay.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pay.todayorpay.R;
import com.pay.todayorpay.design.AccordionView;

public class FragmentCharity extends BaseFragment {
    public static final String TAG = FragmentCharity.class.getSimpleName();
    FragmentCharity _instance;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charity, container, false);
        _instance = this;
        return view;
    }

    @Override
    public void onDestroy() {
        _instance = null;
        super.onDestroy();
    }
}