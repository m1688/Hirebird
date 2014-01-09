package com.recruit.app.ui.job;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.recruit.R;

public class PostJobActivity extends FragmentActivity implements ActionBar.TabListener{
	protected static final String COMPANY_TAB = "companyInfo";
	protected static final String JOB_TAB = "jobInfo";

	private ActionBar actionBar;

	private ViewPager viewPager;
	
	private FragmentPagerAdapter pageAdapter;

	private Fragment companyInfo;

	private Fragment jobInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_job);
		companyInfo = new PostJobCompanyFragment();
		jobInfo = new PostJobJobFragment();

		setUpActionBar();
		setUpViewPager();
		setUpTabs();
	}
	
	 private void setUpTabs() {  
	        final ActionBar actionBar = getActionBar();  
	        for (int i = 0; i < pageAdapter.getCount(); ++i) {  
	            actionBar.addTab(actionBar.newTab()  
	                    .setText(pageAdapter.getPageTitle(i))  
	                    .setTabListener(this));  
	        }  
	    } 

	private void setUpActionBar() {
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
	}
	
	private void setUpViewPager(){
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		pageAdapter = new PostJobViewPagerAdaptor(
				getSupportFragmentManager());
		viewPager.setAdapter(pageAdapter);
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				 final ActionBar actionBar = getActionBar();  
	                actionBar.setSelectedNavigationItem(position);  
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class PostJobViewPagerAdaptor extends FragmentPagerAdapter {

		public PostJobViewPagerAdaptor(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0:
				return companyInfo;
			case 1:
				return jobInfo;
			}
			return fragment;
		}

		@Override
		public int getCount() {

			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch(position) {
			case 0:
				return getString(R.string.post_job_company);
			case 1:
				return getString(R.string.post_job_job);
			}
			return super.getPageTitle(position);
		}
		
		
	}

	class PageChangeListener implements ViewPager.OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
