package com.example.lliziyan20200320.Order0402.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lliziyan20200320.Order0402.fragment.FragmentAll;
//viewpager与tablayout联动
import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<FragmentAll> alls = new ArrayList<>();
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        alls.add(FragmentAll.newInstance(0));
        alls.add(FragmentAll.newInstance(1));
        alls.add(FragmentAll.newInstance(2));
        alls.add(FragmentAll.newInstance(3));
        alls.add(FragmentAll.newInstance(4));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return alls.get(position);
    }

    @Override
    public int getCount() {
        return alls.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "全部";
            case 1:
                return "待付款";
            case 2:
                return "待发货";
            case 3:
                return "待收货";
            case 4:
                return "待评价";
        }
        return "全部订单";
    }
}
