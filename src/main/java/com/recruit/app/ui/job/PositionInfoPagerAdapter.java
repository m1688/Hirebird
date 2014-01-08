package com.recruit.app.ui.job;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.recruit.R;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.domain.model.User;

public class PositionInfoPagerAdapter extends FragmentPagerAdapter {
	
	private Resources resources;
	private User currentUser;
	private PositionModel position;

	public PositionInfoPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	public PositionInfoPagerAdapter(FragmentManager fm,Resources resources,User currentUser,PositionModel position) {
		this(fm);
		this.resources = resources;
		this.currentUser = currentUser;
		this.position = position;
	}

	@Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new PositionInfoFragment(currentUser,position);

            default:
                Fragment fragment = new PositionCompanyFragment(currentUser,position);
                Bundle args = new Bundle();
                args.putInt(PositionCompanyFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
    	String pageTitle = resources.getString(R.string.tab_position);
    	if(position == 1){
    		pageTitle = resources.getString(R.string.tab_company);
    	}
        return pageTitle;
    }

}
