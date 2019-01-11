package com.pay.todayorpay.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pay.todayorpay.R;

public class FragmentSelectCard extends BaseFragment {
    public static final String TAG = FragmentSelectCard.class.getSimpleName();
    FragmentSelectCard _instance;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_card, container, false);
        _instance = this;
        return view;
    }

    @Override
    public void onDestroy() {
        _instance = null;
        super.onDestroy();
    }
}