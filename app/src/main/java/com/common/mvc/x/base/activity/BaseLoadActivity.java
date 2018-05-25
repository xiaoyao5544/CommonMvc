package com.common.mvc.x.base.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewStub;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.mvc.x.R;

/**
 * @author xiao
 * @date 2018/5/21
 */
public abstract class BaseLoadActivity extends BaseContentActivity implements SwipeRefreshLayout.OnRefreshListener {


    private ViewStub headContainView;
    private android.support.v7.widget.RecyclerView baseRecycle;
    private android.support.v4.widget.SwipeRefreshLayout baseSwipe;
    private ViewStub footContainView;
    private BaseQuickAdapter adapter;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_base_loading);
        this.footContainView = findViewById(R.id.footContainView);
        this.baseSwipe = (SwipeRefreshLayout) findViewById(R.id.baseSwipe);
        this.baseRecycle = (RecyclerView) findViewById(R.id.baseRecycle);
        this.headContainView = findViewById(R.id.headContainView);

        setContentContainerHeader();
        setContentContainerFoot();
        initAdapter();
    }

    private void initAdapter() {
        this.adapter = getAdapter();
        if (adapter == null) {
            return;
        }
        baseSwipe.setOnRefreshListener(this);
        baseRecycle.setLayoutManager(getLayoutManager());
        //开启默认加载动画
        adapter.openLoadAnimation();
        baseRecycle.setAdapter(adapter);
    }

    /**
     * 必须给一个adapter
     *
     * @return
     */
    protected abstract BaseQuickAdapter getAdapter();

    /**
     * 默认水平布局,可重写更改
     *
     * @return
     */
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    /**
     * 有头部底部填充的需求重写此方法
     */
    private void setContentContainerHeader() {
        if (getContentContainerHeader() != -1 && headContainView != null) {
            headContainView.setLayoutResource(getContentContainerHeader());
            headContainView.inflate();
        }
    }

    protected int getContentContainerHeader() {
        return -1;
    }

    private void setContentContainerFoot() {
        if (getContentContainerFoot() != -1 && footContainView != null) {
            footContainView.setLayoutResource(getContentContainerFoot());
            footContainView.inflate();
        }
    }

    protected int getContentContainerFoot() {
        return -1;
    }

    /**
     * 下拉刷新执行的操作
     */
    @Override
    public void onRefresh() {
        loadDate();
    }

    @Override
    public void showLoadingView() {
        super.showLoadingView();
        showSwipeRefresh();
    }

    @Override
    public void showContentView() {
        super.showContentView();
        hideSwipeRefresh();
    }

    private void showSwipeRefresh() {
        if (baseSwipe != null && !baseSwipe.isRefreshing()) {
            baseSwipe.post(() -> baseSwipe.setRefreshing(true));
        }
    }

    private void hideSwipeRefresh() {
        if (baseSwipe != null) {
            baseSwipe.post(() -> baseSwipe.setRefreshing(false));
        }
    }
}
