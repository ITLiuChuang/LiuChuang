package com.atguigu.liuchuang.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.liuchuang.base.BaseFragment;

/**
 * Created by 刘闯 on 2017/3/9.
 */

public class TypeFragment extends BaseFragment {
    TextView textView;
    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("分类");
    }
}
