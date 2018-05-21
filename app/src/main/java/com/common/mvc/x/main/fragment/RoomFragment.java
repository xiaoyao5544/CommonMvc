package com.common.mvc.x.main.fragment;

import android.os.Bundle;

import com.common.mvc.x.base.BaseFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class RoomFragment extends BaseFragment{

    public static RoomFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RoomFragment fragment = new RoomFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
