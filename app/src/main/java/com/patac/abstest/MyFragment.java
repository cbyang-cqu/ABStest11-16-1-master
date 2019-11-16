package com.patac.abstest;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*Avoid non-default constructors in fragments;这个是android带的lint工具提示。在代码前加入@SuppressLint("ValidFragment")即可*/
@SuppressLint("ValidFragment")public class MyFragment extends Fragment{
    private String context;
    private TextView mTextView;

    public MyFragment(String context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        mTextView = (TextView)view.findViewById(R.id.textView);
        mTextView.setText(context);
        return view;
    }
}