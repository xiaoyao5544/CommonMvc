package com.common.mvc.x.main.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.mvc.x.base.fragment.BaseLoadFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class ScenesFragment extends BaseLoadFragment{

    public static ScenesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ScenesFragment fragment = new ScenesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter getAdapter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void loadData() {

    }
}
