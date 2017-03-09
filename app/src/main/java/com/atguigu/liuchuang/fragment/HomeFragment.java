package com.atguigu.liuchuang.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.atguigu.liuchuang.R;
import com.atguigu.liuchuang.adapter.HomeAdapter;
import com.atguigu.liuchuang.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 刘闯 on 2017/3/9.
 */

public class HomeFragment extends BaseFragment {


    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    private List<BaseFragment> list;
    private HomeAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        initFragment();
        adapter = new HomeAdapter(getFragmentManager(),list);
        viewPager.setAdapter(adapter);
        //关联
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initFragment() {
        list = new ArrayList<>();
        list.add(new ImgFragment1());
        list.add(new ImgFragment2());
        list.add(new ImgFragment3());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
