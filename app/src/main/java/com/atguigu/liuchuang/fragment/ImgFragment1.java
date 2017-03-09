package com.atguigu.liuchuang.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.atguigu.liuchuang.R;
import com.atguigu.liuchuang.adapter.Img1Adapter;
import com.atguigu.liuchuang.base.BaseFragment;
import com.atguigu.liuchuang.base.Img1Bean;
import com.atguigu.liuchuang.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 刘闯 on 2017/3/9.
 */

public class ImgFragment1 extends BaseFragment {

    @InjectView(R.id.lv_new_post)
    ListView lvNewPost;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_img1, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFragment();
    }

    private void getDataFragment() {
        OkHttpUtils.get().url(Constants.NEW_POST_URL).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TAG", "联网失败" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("TAG", "联网成功" );
                processData(response);
            }
        });
    }

    private void processData(String response) {
        Img1Bean bean = JSON.parseObject(response, Img1Bean.class);
        List<Img1Bean.ResultEntity> result = bean.getResult();
        if (result != null && result.size() > 0) {
            //设置适配器
            Img1Adapter adapter = new Img1Adapter(mContext,result);
            lvNewPost.setAdapter(adapter);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
