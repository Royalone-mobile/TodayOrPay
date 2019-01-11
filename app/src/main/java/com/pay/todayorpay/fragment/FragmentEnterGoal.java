package com.pay.todayorpay.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pay.todayorpay.R;
import com.pay.todayorpay.design.CustomEditText;
import com.pay.todayorpay.design.CustomTextView;

public class FragmentEnterGoal extends BaseFragment {
    public static final String TAG = FragmentEnterGoal.class.getSimpleName();
    FragmentEnterGoal _instance;
    CustomEditText editGoal;
    CustomTextView txtLengthGoal;
    View btnNext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_goal, container, false);


        _instance = this;

        editGoal = view.findViewById(R.id.edit_goal);
        txtLengthGoal = view.findViewById(R.id.txt_length_goal);
        btnNext = view.findViewById(R.id.btn_next);

        editGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                txtLengthGoal.setText(String.valueOf(editGoal.getText().toString().length()));

                if(editGoal.getText().toString().length() == 0)
                    btnNext.setVisibility(View.GONE);
                else
                    btnNext.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        _instance = null;
        super.onDestroy();
    }
}