package com.common.mvc.x.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.mvc.x.R;

/**
 * @author xiao
 */
public abstract class BaseLoadFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener {

    private android.support.v7.widget.RecyclerView baseRecycle;
    private android.support.v4.widget.SwipeRefreshLayout baseSwipe;
    private FloatingActionButton fab;
    private BaseQuickAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (viewRoot == null) {
            viewRoot = inflater.inflate(R.layout.fragment_base_load, null);
            this.baseSwipe = (SwipeRefreshLayout)viewRoot.findViewById(R.id.baseSwipe);
            this.baseRecycle = (RecyclerView) viewRoot.findViewById(R.id.baseRecycle);
            this.fab = viewRoot.findViewById(R.id.fab);

            initAdapter();
            initView();
            initVariables();
            loadFnish();
        }
        return viewRoot;
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
     *  必须给一个adapter
     * @return
     */
    protected abstract BaseQuickAdapter getAdapter();

    /**
     * 默认水平布局,可重写更改
     * @return
     */
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mActivity);
    }

    /**
     * view
     */
    protected abstract void initView();

    /**
     * 变量
     */
    protected abstract void initVariables();

    /**
     * 加载数据完毕后做的一些操作
     */
    protected  void loadFnish(){

    }

    @Override
    public void onRefresh() {
        loadData();
        getAdapter().notifyDataSetChanged();
    }
}
