package com.example.lliziyan20200320;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {
    public ArrayList<Fragment_one> list = new ArrayList<>();
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        list.add(new Fragment_one());
        list.add(new Fragment_one());
        list.add(new Fragment_one());
        list.add(new Fragment_one());
        list.add(new Fragment_one());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "首页";
            case 1:
                return "订单";
            case 2:
                return "购物车";
            case 3:
                return "显示全部";
            case 4:
                return "我的";
        }
        return "全部订单";
    }
}
