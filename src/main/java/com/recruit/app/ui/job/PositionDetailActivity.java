package com.recruit.app.ui.job;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.recruit.R;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.domain.model.User;
import com.recruit.app.service.PositionService;
import com.recruit.app.service.UserService;
import com.recruit.app.service.sqlite.SQLitePositionService;
import com.recruit.app.service.sqlite.SQLiteUserService;

public class PositionDetailActivity extends FragmentActivity implements
		ActionBar.TabListener {

	private static final String TAG = "position_detail";

	private PositionInfoPagerAdapter positionPagerAdapter;

	private ViewPager mViewPager;

	private Long positionId = 0L;

	private User currentUser = null;

	private PositionModel position = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.position_detail);
		initData();

		positionPagerAdapter = new PositionInfoPagerAdapter(
				getSupportFragmentManager(), getResources(), currentUser,
				position);

		final ActionBar actionBar = getActionBar();

		//actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);

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

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent upIntent = NavUtils.getParentActivityIntent(this);
			if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
				TaskStackBuilder.create(this)
						.addNextIntentWithParentStack(upIntent)
						.startActivities();
			} else {
				NavUtils.navigateUpTo(this, upIntent);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initData() {
		// 接受参数
		Intent intent = getIntent();
		if (intent != null) {
			positionId = intent.getLongExtra("positionId", 0L);
			Log.i(TAG, positionId + "");
		}
		// 当前用户
		UserService userService = new SQLiteUserService();
		PositionService positionService = new SQLitePositionService();
		Long currentUserId = 0L;
		SharedPreferences sharedPreferences = getSharedPreferences("config",
				Context.MODE_PRIVATE);
		currentUserId = sharedPreferences.getLong("userId", 0L);
		Log.i(TAG, "currentUserId=" + currentUserId);
		currentUser = userService.queryById(currentUserId);
		Log.i(TAG, "currentUser=" + currentUser.toString());
		Log.i(TAG, "positionId=" + positionId);
		position = positionService.queryPositionById(positionId);
		Log.i(TAG, "position=" + position.toString());
	}
}
