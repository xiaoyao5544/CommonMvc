package com.common.mvc.x.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author gitxi
 */
@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //横竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        beforeSetContentView();
        super.onCreate(savedInstanceState);
        context = this;
        onContentView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //禁止自动填充
            getWindow().getDecorView()
                    .setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);

        }
    }

    /**
     * setContentView 之前调用
     */
    protected void beforeSetContentView() {
    }


    /**
     * 子类复写view
     */
    protected abstract void onContentView();

    public void starActivity(Class activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
