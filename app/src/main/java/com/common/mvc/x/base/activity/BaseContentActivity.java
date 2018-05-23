package com.common.mvc.x.base.activity;

import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.common.mvc.x.R;

/**
 * @author xiao
 */
public abstract class BaseContentActivity extends BaseActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private android.widget.RelativeLayout container;

    private View errorView;

    @Override
    protected void onContentView() {
        super.setContentView(R.layout.activity_content);
        this.container = (RelativeLayout) findViewById(R.id.container);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setToolbar();
        initView();
        initVariables();
        loadDate();
    }


    private void setToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            //去除默认Title显示
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    /**
     * 隐藏toolBar
     */
    protected void setToolbarGone() {
        if (toolbar != null) {
            toolbar.setVisibility(View.GONE);
        }
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    /**
     * 设置toolsBar 标题
     *
     * @param text
     */
    @Override
    public void setTitle(CharSequence text) {
        toolbar.setTitle(text);
    }

    @Override
    public void setTitle(int stringId) {
        toolbar.setTitle(getString(stringId));
    }

    /**
     * 重写setContentView,子类填充布局
     *
     * @param layoutResID id
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (container == null) {
            return;
        }
        container.addView(getLayoutInflater().inflate(layoutResID, container, false), new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化变量
     */
    protected abstract void initVariables();

    /**
     * 加载数据
     */
    protected  void loadDate(){
    }

    /**
     * showSnackbar
     *
     * @param msg
     */
    public void showSnackbar(CharSequence msg) {
        View view;
        if (container == null) {
            view = getWindow().getDecorView();
        } else {
            view = container;
        }
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public void showSnackbar(int msg) {
        View view;
        if (container == null) {
            view = getWindow().getDecorView();
        } else {
            view = container;
        }
        Snackbar.make(view, getResources().getString(msg), Snackbar.LENGTH_LONG).show();
    }
}
