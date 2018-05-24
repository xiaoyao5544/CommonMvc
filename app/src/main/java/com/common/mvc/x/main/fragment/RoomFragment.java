package com.common.mvc.x.main.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.mvc.x.base.fragment.BaseLoadFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class RoomFragment extends BaseLoadFragment{

    public static RoomFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RoomFragment fragment = new RoomFragment();
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
