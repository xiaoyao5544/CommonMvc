package com.common.mvc.commonlibrary.views.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.common.mvc.commonlibrary.R;


/**
 * @author xiao
 */
public class CenterHeadView extends AppBarLayout {

    private Toolbar mToolbar;

    private Activity mContext;

    private String titleName;

    private Drawable icon;

    private TextView title;

    public CenterHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.view_center_head, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.widgetView, 0, 0);
        icon = typedArray.getDrawable(R.styleable.widgetView_leftIcon);
        titleName = typedArray.getString(R.styleable.widgetView_title);
        initView();
        initToolbar();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.titleName);

        if (!TextUtils.isEmpty(titleName)) {
            title.setText(titleName);
        }
        if (icon != null) {
            mToolbar.setNavigationIcon(icon);
        }
    }

    private void initToolbar() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.onBackPressed();
            }
        });
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }
}
