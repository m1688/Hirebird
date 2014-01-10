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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.recruit.R;
import com.recruit.app.ui.common.SlidingMenuAdapterView.OnSlidingMenuItemSelectedListener;
import com.recruit.app.ui.job.PostPositionFragment;
import com.recruit.app.ui.search.SearchFragment;

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
	protected void initMenuItems() {
		menuItems.add(new SlidingMenuItemBean(R.string.begin_search, R.drawable.ic_menu_sample_icon, new SearchFragment(), true));
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
//		menuItems.add(new SlidingMenuItemBean(R.string.check_for_update, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.check_for_update, R.drawable.ic_menu_sample_icon, null, true, new OnSlidingMenuItemSelectedListener(){
			public void onSlidingMenuItemSelected(View view, int position) {
				Toast.makeText(getApplicationContext(), "The app is currently neweast", Toast.LENGTH_SHORT).show();
			}
		}));
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
				R.drawable.ic_navigation_drawer, R.string.drawer_open,
				R.string.drawer_close);
		
		
		initActionBar();
		initSlidingMenu();
		drawerLayout.setDrawerListener(drawerToggle);
	}

	private void initSlidingMenu() {
		menuDrawerList.setAdapter(new SlidingMenuAdapterView(getApplicationContext(), R.layout.listitem_sliding_menu, menuItems));
		menuDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		menuDrawerList.performItemClick(menuDrawerList, getDefaultSelection(), menuDrawerList.getItemIdAtPosition(getDefaultSelection()));
	}
	
	/**
	 * 子类重写这个方法指定默认选中哪一个选项
	 * @return
	 */
	protected int getDefaultSelection() {
		return 0;
	}
	
	private void initActionBar() {
		ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
		View view = getLayoutInflater()
				.inflate(R.layout.actionbar_title, null);
		actionBarTitle = (TextView) view.findViewById(R.id.action_bar_title);
//		actionBar.setCustomView(view, lp);
		actionBar.setDisplayHomeAsUpEnabled(true);
//		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowTitleEnabled(true);
//		actionBar.setLogo(R.drawable.ic_drawer2);
		actionBar.setDisplayShowHomeEnabled(true);// show button
		actionBar.setHomeButtonEnabled(true);// enable button
	}
	
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
		    unSelectAll();
			selectItem(view, position);
			int childCount = parent.getChildCount();
			for(int i = 0; i < childCount; i++) {
				View item = parent.getChildAt(i);
				if(!item.isEnabled()) {
					continue;
				}
				
				TextView nameView = (TextView)item.findViewById(R.id.menu_name_view);
				LinearLayout lly = (LinearLayout)item.findViewById(R.id.menu_item_linear);
				if(item == view) {
					lly.setBackgroundColor(getResources().getColor(R.color.menu_selected));
					nameView.setTextColor(getResources().getColor(R.color.menu_selected_font));
				} else if(item.isEnabled()) {
					lly.setBackgroundColor(getResources().getColor(R.color.menu_unselected));
					nameView.setTextColor(getResources().getColor(R.color.menu_unselected_font));
				}
			}
			menuItems.get(position).setSelected(true);
			drawerLayout.closeDrawer(drawerFrame);
		}
	}
	
	private void unSelectAll() {
	    for(int i = 0; i < menuItems.size(); i++) {
	        menuItems.get(i).setSelected(false);
	    }
	}
	private void selectItem(View view, int position) {
		SlidingMenuItemBean slidingMenuItemBean = menuItems.get(position);
		Fragment fragment = slidingMenuItemBean.getFragment();
		if(fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment, "content").commit();
		}
		OnSlidingMenuItemSelectedListener onSlidingMenuItemSelectedListener = slidingMenuItemBean.getOnSlidingMenuItemSelectedListener();
		if(onSlidingMenuItemSelectedListener != null) {
			onSlidingMenuItemSelectedListener.onSlidingMenuItemSelected(view, position);
		}
		setTitle(getResources().getString(slidingMenuItemBean.getMenuNameRes()));
	}

	@Override
	public void setTitle(CharSequence title) {
		actionBarTitle.setText(title);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
