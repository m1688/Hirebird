package com.recruit.app.ui.common;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.recruit.R;
import com.recruit.app.ui.job.PostPositionFragment;
import com.recruit.app.util.StringUtils;

/**
 * 慢慢重构
 * @author Administrator
 *
 */
public class SlidingMenuActivity extends ActionBarActivity {
	private static final Map<String, Object> menuMap = new HashMap<String, Object>();
	private ActionBarDrawerToggle drawerToggle;
	
	protected ActionBar actionBar;
	protected String[] menuTitls;
	protected DrawerLayout drawerLayout;
	protected ListView menuDrawerList;
	protected TextView actionBarTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sliding_menu);
		
		actionBar = getSupportActionBar();
		menuDrawerList = (ListView) findViewById(R.id.left_drawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		menuTitls = new String[]{"发布职位","发布职位","发布职位"};
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close);
		
		
		initActionBar();
		initSlidingMenu();

		drawerLayout.setDrawerListener(drawerToggle);
	}

	private void initSlidingMenu() {
		menuDrawerList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menuTitls));
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
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
			int childCount = parent.getChildCount();
			for(int i = 0; i < childCount; i++) {
				View item = parent.getChildAt(i);
				if(item == view) {
					item.setSelected(true);
					item.setBackgroundColor(getResources().getColor(R.color.menu_selected));
				} else {
					item.setSelected(false);
					item.setBackgroundColor(getResources().getColor(R.color.menu_unselected));
				}
			}
			
		}
	}

	private void selectItem(int position) {
		switch (position) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			PostPositionFragment positionFragment = new PostPositionFragment();
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, positionFragment, "position").commit();
		}
		menuDrawerList.setItemChecked(position, true);
		setTitle(menuTitls[position]);
		drawerLayout.closeDrawer(menuDrawerList);
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
	
	public static void addMenu(String menuTitle, Fragment fragment) {
		if(StringUtils.isBlank(menuTitle)) {
			throw new IllegalArgumentException("menu title connot be null or empty");
		}
		if(fragment == null) {
			throw new IllegalArgumentException("fragment connot be null");
		}
		
		menuMap.put(menuTitle, fragment);
	}
	
	public static void addMenu(String menuTitle, Intent activityStartIntent) {
		if(StringUtils.isBlank(menuTitle)) {
			throw new IllegalArgumentException("menu title connot be null or empty");
		}
		if(activityStartIntent == null) {
			throw new IllegalArgumentException("intent connot be null");
		}
		menuMap.put(menuTitle, activityStartIntent);
	}
}
