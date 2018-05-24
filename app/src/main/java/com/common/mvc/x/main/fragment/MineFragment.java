package com.common.mvc.x.main.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.common.mvc.x.R;
import com.common.mvc.x.base.fragment.BaseContentFragment;

/**
 * @author xiao
 * @date 2018/5/21
 */
public class MineFragment extends BaseContentFragment {

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        Toolbar toolbar = viewRoot.findViewById(R.id.toolbar);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }

    @Override
    protected void initVariables() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.activity_main2_drawer, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
