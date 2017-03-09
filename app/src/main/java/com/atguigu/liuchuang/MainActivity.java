package com.atguigu.liuchuang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.atguigu.liuchuang.base.BaseFragment;
import com.atguigu.liuchuang.fragment.FindFragment;
import com.atguigu.liuchuang.fragment.HomeFragment;
import com.atguigu.liuchuang.fragment.TypeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.rg_main)
    RadioGroup rgMain;
    private List<BaseFragment> list;
    //当前页面
    private Fragment tempFragment;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initFragment();
        initListener();
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_type:
                        position = 1;
                        break;
                    case R.id.rb_find:
                        position = 2;
                        break;
                }
                //根据位置获取Fragment
                switchFragment(list.get(position));
            }
        });
        //默认选中
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(Fragment currentFragment) {
        //判断切换的页面是否为当前页面
        if (tempFragment != currentFragment) {
            //开启事物
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断是否加载过
            if (!currentFragment.isAdded()) {
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }

                ft.add(R.id.fl_mian, currentFragment);
            } else {
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                ft.show(currentFragment);
            }
            //提交事务
            ft.commit();
            tempFragment = currentFragment;

        }

    }

    private void initFragment() {
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new TypeFragment());
        list.add(new FindFragment());


    }
}
