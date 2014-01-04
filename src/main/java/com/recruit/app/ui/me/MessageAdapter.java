package com.recruit.app.ui.me;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jialiang.zoujl on 14-1-2.
 */
public class MessageAdapter extends FragmentPagerAdapter {

    public MessageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new MessageApplyFragment();
            case 1:
                // Games fragment activity
                return new MessageNoteFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
}
