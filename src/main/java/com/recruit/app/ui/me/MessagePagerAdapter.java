package com.recruit.app.ui.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.recruit.app.domain.model.Message;

import java.util.List;

import butterknife.InjectView;

/**
 * jyu - 1/6/14.
 */
public class MessagePagerAdapter extends FragmentStatePagerAdapter {


    private List<Message> messages;

    public MessagePagerAdapter(FragmentManager fm, List<Message> messages) {
        super(fm);
        this.messages = messages;
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = new MessageFragment();

        Bundle args = new Bundle();
        args.putSerializable("message", messages.get(i));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return messages.size();
    }
}
