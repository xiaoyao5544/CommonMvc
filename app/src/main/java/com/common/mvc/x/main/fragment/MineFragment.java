package com.common.mvc.x.main.fragment;

import android.os.Bundle;

import com.common.mvc.x.base.BaseFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class MineFragment extends BaseFragment{

    public static MineFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
