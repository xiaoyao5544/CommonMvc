package com.common.mvc.x.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class BaseFragment extends Fragment {

    protected View viewRoot;

    protected Context mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = context;
    }
}
