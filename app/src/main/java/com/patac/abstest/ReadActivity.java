package com.patac.abstest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReadActivity extends Activity {
    private TextView mTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        TextView mTextTitle = (TextView) findViewById(R.id.topTitle_read);
        Intent intent = getIntent();//声明一个对象，并获得跳转过来的Intent对象
        String norm = intent.getStringExtra("norm");//从intent对象中获得数据
        mTextTitle.setText(norm);//设置标题文本
    }

    /* 跳转至阅读操作指南界面*/
    public void OnNext1(View v){
        startActivity(new Intent(ReadActivity.this,TabActivity.class));
    }
}
