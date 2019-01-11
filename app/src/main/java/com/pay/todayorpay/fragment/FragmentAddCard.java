package com.pay.todayorpay.fragment;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pay.todayorpay.R;
import com.pay.todayorpay.design.CustomEditText;
import com.pay.todayorpay.design.FourDigitCardFormatWatcher;

public class FragmentAddCard extends BaseFragment {
    public static final String TAG = FragmentAddCard.class.getSimpleName();
    FragmentAddCard _instance;

    CustomEditText editCardHolderName;
    CustomEditText editExpireDate;
    CustomEditText editCardNumber;
    CustomEditText editCVV;
    private String mLastInput;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_card, container, false);

        _instance = this;

        editCardNumber = view.findViewById(R.id.edit_card_number);
        editCardHolderName = view.findViewById(R.id.edit_card_holder);
        editExpireDate = view.findViewById(R.id.edit_expire_date);
        editCVV = view.findViewById(R.id.edit_cvv);

        editCardNumber.addTextChangedListener(new FourDigitCardFormatWatcher());
        editExpireDate.addTextChangedListener(textWatcher);
        return view;
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            try {
                String input = s.toString();
                if (s.length() == 2 && !mLastInput.endsWith("/")) {
                    int month = Integer.parseInt(input);
                    if (month <= 12) {
                        editExpireDate.setText(editExpireDate.getText().toString() + "/");
                        editExpireDate.setSelection(editExpireDate.getText().toString().length());
                    }
                } else if (s.length() == 2 && mLastInput.endsWith("/")) {
                    int month = Integer.parseInt(input);
                    if (month <= 12) {
                        editExpireDate.setText(editExpireDate.getText().toString().substring(0, 1));
                        editExpireDate.setSelection(editExpireDate.getText().toString().length());
                    } else {
                        editExpireDate.setText("");
                        editExpireDate.setSelection(editExpireDate.getText().toString().length());
                        Toast.makeText(getContext(), "Enter a valid month", Toast.LENGTH_LONG).show();
                    }
                } else if (s.length() == 1) {
                    int month = Integer.parseInt(input);
                    if (month > 1) {
                        editExpireDate.setText("0" + editExpireDate.getText().toString() + "/");
                        editExpireDate.setSelection(editExpireDate.getText().toString().length());
                    }
                } else {

                }
                mLastInput = editExpireDate.getText().toString();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    };


    @Override
    public void onDestroy() {
        _instance = null;
        super.onDestroy();
    }
}