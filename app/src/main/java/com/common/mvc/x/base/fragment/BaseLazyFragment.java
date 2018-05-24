package com.common.mvc.x.base.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

/**
 * @author xiao 2017/11/1
 */

public abstract class BaseLazyFragment extends BaseContentFragment {
    /**
     * 判断fragment的UI是否可见过
     */
    protected boolean isVisible = false;

    /**
     * 是否加载过数据 判断是否加载过数据，如果加载过数据不再调用loadData()
     */
    protected boolean isLoaded = false;

    protected FragmentActivity mActivity;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInVisible();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (FragmentActivity) context;
    }

    /**
     * ui可见时执行
     */
    protected void onVisible() {
        if (!isLoaded && isVisible && viewRoot != null) {
            loadData();
            isLoaded = true;
        }
    }

    /**
     * ui 不可见时
     */
    protected void onInVisible() {
    }

    /**
     * 布局填充前加载数据
     * 注意：此方法会在creatview之前执行
     */
    protected abstract void loadData();

}
