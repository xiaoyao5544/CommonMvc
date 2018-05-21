package com.common.mvc.x.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.common.mvc.commonlibrary.utils.ViewUtil;
import com.common.mvc.commonlibrary.views.NoScrollViewPager;
import com.common.mvc.x.R;
import com.common.mvc.x.adapter.MainViewpagerAdapter;
import com.common.mvc.x.base.BaseContentActivity;
import com.common.mvc.x.main.fragment.DeviceFragment;
import com.common.mvc.x.main.fragment.MineFragment;
import com.common.mvc.x.main.fragment.RoomFragment;
import com.common.mvc.x.main.fragment.ScenesFragment;

/**
 * @author xiao
 */
public class MainActivity extends BaseContentActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private com.common.mvc.commonlibrary.views.NoScrollViewPager viewPager;
    private android.support.design.widget.BottomNavigationView bottomNavigation;
    private MainViewpagerAdapter adapter;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        this.bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        this.viewPager = (NoScrollViewPager) findViewById(R.id.viewPager);
        ViewUtil.disableShiftMode(bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initVariables() {
        adapter = new MainViewpagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DeviceFragment.newInstance());
        adapter.addFragment(RoomFragment.newInstance());
        adapter.addFragment(ScenesFragment.newInstance());
        adapter.addFragment(MineFragment.newInstance());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_device:
                viewPager.setCurrentItem(0);
                break;
            case R.id.item_room:
                viewPager.setCurrentItem(1);
                break;
            case R.id.item_scenes:
                viewPager.setCurrentItem(2);
                break;
            case R.id.item_mine:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;

        }
        return false;
    }
}
