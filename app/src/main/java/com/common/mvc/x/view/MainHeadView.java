package com.common.mvc.x.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.common.mvc.x.R;
import com.common.mvc.x.ui.SplashActivity;


/**
 * @author xiao
 */
public class MainHeadView extends AppBarLayout {

    private Toolbar mToolbar;

    private TextView title;

    public MainHeadView(Context context) {
        super(context);
        initView(context);
    }

    public MainHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_center_head, this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        title = findViewById(R.id.titleName);
        initToolbar(context);
    }

    private void initToolbar(Context context) {
        mToolbar.setNavigationIcon(R.drawable.ic_menu_share);
        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, SplashActivity.class));
            }
        });
        mToolbar.inflateMenu(R.menu.main2);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                context.startActivity(new Intent(context, SplashActivity.class));
                return false;
            }
        });
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void setTitle(CharSequence str) {
        if (!TextUtils.isEmpty(str)) {
            title.setText(str);
        }
    }
}
