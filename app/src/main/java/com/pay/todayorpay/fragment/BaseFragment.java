package com.pay.todayorpay.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


public class BaseFragment extends Fragment {
    protected Activity mMainActivity;
    protected LayoutInflater mLayoutInflater;
    protected ProgressDialog progressDialog;
    @SuppressWarnings("unused")
    public boolean backAllowed() {
        return true;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mMainActivity =  activity;
        mLayoutInflater = LayoutInflater.from(mMainActivity);
    }

    @SuppressWarnings("unused")
    public void hideKeyboard() {
        View view = mMainActivity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) mMainActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showKeyboard() {
        View view = mMainActivity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    mMainActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    @SuppressWarnings("unused")
    public void showInfoDialog(String title, String description) {
        showInfoDialog(title, description, null);
    }

    public void showInfoDialog(String title, String description, DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(mMainActivity);
        builderSingle.setTitle(title);
        builderSingle.setMessage(description);

        if (okListener == null) {
            okListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            };
        } else {
            builderSingle.setCancelable(false);
        }

        builderSingle.setPositiveButton("OK", okListener);
        builderSingle.show();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    /**
     * Keeps Screen on so as to avoid lock screen.
     * @param bOnOff
     */
    public void setKeepScreenOn(boolean bOnOff) {
        try {
            if (bOnOff)
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            else
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void toggleFullscreen(View view, boolean fullscreen) {
        WindowManager.LayoutParams attrs = getActivity().getWindow().getAttributes();
        if (fullscreen)
        {
            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        else
        {
            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        }

        getActivity().getWindow().setAttributes(attrs);
    }
}
