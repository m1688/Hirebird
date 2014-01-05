package com.recruit.app.ui.common;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.recruit.R;
import com.recruit.app.ui.job.PostPositionFragment;

/**
 * 慢慢重构
 * @author Administrator
 *
 */
public class SlidingMenuActivity extends ActionBarActivity {
	private ActionBarDrawerToggle drawerToggle;
	private View drawerFrame;
	protected ActionBar actionBar;
	protected List<SlidingMenuItemBean> menuItems = new ArrayList<SlidingMenuItemBean>();
	protected DrawerLayout drawerLayout;
	protected ListView menuDrawerList;
	protected TextView actionBarTitle;
	
	/**
	 * 菜单对应的Fragment从SlidingMenuItemBean的参数中传过去
	 */
	private void initMenuItems() {
		menuItems.add(new SlidingMenuItemBean(R.string.begin_search, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.search_record, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.my_center, false));
		menuItems.add(new SlidingMenuItemBean(R.string.my_resume, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.my_message, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.my_position, R.drawable.ic_menu_sample_icon, new PostPositionFragment(), true));
		menuItems.add(new SlidingMenuItemBean(R.string.my_job, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.system, false));
		menuItems.add(new SlidingMenuItemBean(R.string.sys_setting, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.suggestion, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.about_us, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.check_for_update, R.drawable.ic_menu_sample_icon, null, true));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sliding_menu);
		initMenuItems();
		actionBar = getSupportActionBar();
		drawerFrame = findViewById(R.id.drawer_frame);
		menuDrawerList = (ListView) findViewById(R.id.left_drawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close);
		
		
		initActionBar();
		initSlidingMenu();

		drawerLayout.setDrawerListener(drawerToggle);
	}

	private void initSlidingMenu() {
		menuDrawerList.setAdapter(new SlidingMenuAdapterView(getApplicationContext(), R.layout.listitem_sliding_menu, menuItems));
		menuDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
	}
	
	
	private void initActionBar() {
		ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
		View view = getLayoutInflater()
				.inflate(R.layout.actionbar_title, null);
		actionBarTitle = (TextView) view.findViewById(R.id.action_bar_title);
		actionBar.setCustomView(view, lp);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setLogo(R.drawable.ic_drawer2);
		actionBar.setDisplayShowHomeEnabled(true);// show button
		actionBar.setHomeButtonEnabled(true);// enable button
	}
	
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
			int childCount = parent.getChildCount();
			for(int i = 0; i < childCount; i++) {
				View item = parent.getChildAt(i);
				if(!item.isEnabled()) {
					continue;
				}
				
				if(item == view) {
					item.setBackgroundColor(getResources().getColor(R.color.menu_selected));
				} else {
					item.setBackgroundColor(getResources().getColor(R.color.menu_unselected));
				}
			}
			drawerLayout.closeDrawer(drawerFrame);
		}
	}

	private void selectItem(int position) {
		SlidingMenuItemBean slidingMenuItemBean = menuItems.get(position);
		Fragment fragment = slidingMenuItemBean.getFragment();
		if(fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment, "content").commit();
		}
		setTitle(getResources().getString(slidingMenuItemBean.getMenuNameRes()));
	}

	@Override
	public void setTitle(CharSequence title) {
		actionBarTitle.setText(title);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
