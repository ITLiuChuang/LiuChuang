package com.atguigu.liuchuang.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.liuchuang.R;
import com.atguigu.liuchuang.base.BaseFragment;
import com.atguigu.liuchuang.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 刘闯 on 2017/3/9.
 */

public class HomeFragment extends BaseFragment {

    @InjectView(R.id.rv_home)
    RecyclerView rvHome;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFragment();
    }

    private void getDataFragment() {
        OkHttpUtils.get().url(Constants.HOME_URL).id(100)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TAG", "联网失败" + e.getMessage());

            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("TAG", "联网成功" );
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
