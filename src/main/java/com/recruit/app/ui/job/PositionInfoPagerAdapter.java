package com.recruit.app.ui.job;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.recruit.R;

public class PositionInfoPagerAdapter extends FragmentPagerAdapter {
	
	private Resources resources;

	public PositionInfoPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public PositionInfoPagerAdapter(FragmentManager fm,Resources resources) {
		this(fm);
		this.resources = resources;
	}

	@Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new PositionInfoFragment();

            default:
                Fragment fragment = new PositionCompanyFragment();
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
