package com.common.mvc.x.ui;


import android.os.CountDownTimer;

import com.common.mvc.x.R;
import com.common.mvc.x.base.BaseContentActivity;
import com.common.mvc.x.main.MainActivity;


/**
 * @author xiao
 */
public class SplashActivity extends BaseContentActivity {

    private CountDownTimer timer;

    @Override
    protected void initView() {
        setToolbarGone();
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                starActivity(MainActivity.class);
                finish();
            }
        }.start();
    }
}
