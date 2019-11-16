package com.patac.abstest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);    // 引用activity_star界面
        Timer timer=new Timer();      // 实例化定时器对象
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this,MainActivity.class));//跳转的逻辑：开始界面-主界面
                finish();    //结束当前活动
            }
        };timer.schedule(timerTask,2000); //设置计时任务2s后跳转
    }
}
