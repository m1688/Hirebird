package com.recruit.app.ui.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import butterknife.InjectView;

/**
 * jyu - 1/6/14.
 */
public class MessagePagerAdapter extends FragmentStatePagerAdapter {


    public MessagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt("message", i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
