package com.common.mvc.x.base.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.mvc.x.R;
import com.common.mvc.x.view.MainHeadView;

/**
 * @author xiao
 */
public abstract class BaseLoadFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener {

    private android.support.v7.widget.RecyclerView baseRecycle;
    private android.support.v4.widget.SwipeRefreshLayout baseSwipe;
    protected FloatingActionButton fab;
    private BaseQuickAdapter adapter;

    protected MainHeadView mHeadView;


    @Override
    protected int setContentView() {
        return R.layout.fragment_base_load;
    }

    @Override
    protected void onContentView() {
        this.baseSwipe = (SwipeRefreshLayout) viewRoot.findViewById(R.id.baseSwipe);
        this.baseRecycle = (RecyclerView) viewRoot.findViewById(R.id.baseRecycle);
        this.fab = viewRoot.findViewById(R.id.fab);
        this.mHeadView = viewRoot.findViewById(R.id.headView);
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
        return new LinearLayoutManager(mActivity);
    }

    protected void setHeadViewGone() {
        if (mHeadView != null) {
            mHeadView.setVisibility(View.GONE);
        }
    }


    @Override
    public void onRefresh() {
        loadData();
        getAdapter().notifyDataSetChanged();
    }
}
