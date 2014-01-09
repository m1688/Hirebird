package com.recruit.app.ui.me;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jialiang.zoujl on 14-1-2.
 */
public class MessageListPageAdapter extends PagerAdapter {

    private List<View> viewList;

    public MessageListPageAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position), 0);
        return viewList.get(position);
    }
    @Override
    public int getCount() {
        return viewList.size();
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "标题" + (position + 1);
    }
}
