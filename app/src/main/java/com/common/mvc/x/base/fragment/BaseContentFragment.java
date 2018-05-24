package com.common.mvc.x.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author xiao
 * @date 2018/5/24
 */
public abstract class BaseContentFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (viewRoot == null) {
            viewRoot = inflater.inflate(setContentView(), null);
            onContentView();
            initView();
            initVariables();
            loadFnish();
        }
        return viewRoot;
    }

    /**
     * balabalbala
     */
    protected void onContentView() {
    }

    /**
     * 填充一个布局文件
     *
     * @return
     */
    protected abstract int setContentView();

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
    protected void loadFnish() {

    }
}
