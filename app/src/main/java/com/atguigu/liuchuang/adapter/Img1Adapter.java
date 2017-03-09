package com.atguigu.liuchuang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.atguigu.liuchuang.R;
import com.atguigu.liuchuang.base.Img1Bean;
import com.atguigu.liuchuang.utils.Constants;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 刘闯 on 2017/3/9.
 */

public class Img1Adapter extends BaseAdapter {
    private final Context mContext;
    private final List<Img1Bean.ResultEntity> datas;

    public Img1Adapter(Context mContext, List<Img1Bean.ResultEntity> result) {
        this.mContext = mContext;
        this.datas = result;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_listview_img1, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据位置获取相应的数据
        Img1Bean.ResultEntity resultEntity = datas.get(position);

        //图片
        Glide.with(mContext).load(Constants.BASE_URL_IMAGE + resultEntity.getFigure()).into(viewHolder.ivCommunityFigure);
        return convertView;
    }

    class ViewHolder {
        @InjectView(R.id.iv_community_figure)
        ImageView ivCommunityFigure;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
