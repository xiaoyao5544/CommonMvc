package com.common.mvc.x.main.fragment;

import android.os.Bundle;

import com.common.mvc.x.base.BaseFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class ScenesFragment extends BaseFragment{

    public static ScenesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ScenesFragment fragment = new ScenesFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
