package com.common.mvc.x.main.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.mvc.x.base.fragment.BaseLoadFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class DeviceFragment extends BaseLoadFragment {

    public static DeviceFragment newInstance() {

        Bundle args = new Bundle();

        DeviceFragment fragment = new DeviceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter getAdapter() {
        return null;
    }

    @Override
    protected void initView() {
        mHeadView.setTitle("设备");
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void loadData() {

    }
}
