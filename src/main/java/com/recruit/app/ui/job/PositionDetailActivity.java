package com.recruit.app.ui.job;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.recruit.R;

public class PositionDetailActivity extends FragmentActivity implements
		ActionBar.TabListener {

	private PositionInfoPagerAdapter positionPagerAdapter;

	private ViewPager mViewPager;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.position_detail);

		positionPagerAdapter = new PositionInfoPagerAdapter(
				getSupportFragmentManager(),getResources());

		final ActionBar actionBar = getActionBar();

		actionBar.setHomeButtonEnabled(false);

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(positionPagerAdapter);
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		for (int i = 0; i < positionPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab()
					.setText(positionPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

	}

	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		mViewPager.setCurrentItem(arg0.getPosition());
	}

	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

	}
}
