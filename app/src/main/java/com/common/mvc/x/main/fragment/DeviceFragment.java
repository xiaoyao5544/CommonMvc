package com.common.mvc.x.main.fragment;

import android.os.Bundle;

import com.common.mvc.x.base.BaseFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class DeviceFragment extends BaseFragment{

    public static DeviceFragment newInstance() {

        Bundle args = new Bundle();

        DeviceFragment fragment = new DeviceFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
