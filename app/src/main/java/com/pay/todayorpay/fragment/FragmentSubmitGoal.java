package com.pay.todayorpay.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pay.todayorpay.R;
import com.pay.todayorpay.design.CustomTextView;

public class FragmentSubmitGoal extends BaseFragment {
    public static final String TAG = FragmentSubmitGoal.class.getSimpleName();
    FragmentSubmitGoal _instance;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit_goal, container, false);
        _instance = this;
        return view;
    }

    @Override
    public void onDestroy() {
        _instance = null;
        super.onDestroy();
    }
}