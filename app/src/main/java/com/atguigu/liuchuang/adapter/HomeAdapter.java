package com.atguigu.liuchuang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atguigu.liuchuang.base.BaseFragment;

import java.util.List;

/**
 * Created by 刘闯 on 2017/3/9.
 */

public class HomeAdapter extends FragmentPagerAdapter {
    private final List<BaseFragment> fragments;
    private String[] titles = new String[]{"图片1", "图片2","图片3"};

    public HomeAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * 显示TabLayout的标题才用到的
     * @param position
     * @return
     */
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
