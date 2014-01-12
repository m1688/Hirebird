package com.recruit.app.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.recruit.R;
import com.recruit.app.ui.common.SlidingMenuActivity;
import com.recruit.app.ui.common.SlidingMenuAdapterView.OnSlidingMenuItemSelectedListener;
import com.recruit.app.ui.common.SlidingMenuItemBean;
import com.recruit.app.ui.job.PostJobActivity;
import com.recruit.app.ui.job.PostPositionFragment;
import com.recruit.app.ui.me.MessageListFragement;
import com.recruit.app.ui.search.SearchFragment;

public class MainActivity extends SlidingMenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		//保存当前用户信息到首选项,假设当前用户userId=20
		SharedPreferences sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sharedPreferences.edit();//获取编辑器
		editor.putLong("userId", 20L);
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.new_position:
			Intent intent = new Intent(this, PostJobActivity.class);
			startActivity(intent);
		}
		
		return super.onOptionsItemSelected(item);
	}

	//初始化菜单，需要按照想要的顺序排列
	@Override
	protected void initMenuItems() {
		menuItems.add(new SlidingMenuItemBean(R.string.begin_search, R.drawable.ic_menu_sample_icon, new SearchFragment(), true));
		menuItems.add(new SlidingMenuItemBean(R.string.search_record, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.my_center, false));
		menuItems.add(new SlidingMenuItemBean(R.string.my_resume, R.drawable.ic_menu_sample_icon, null, true));
		menuItems.add(new SlidingMenuItemBean(R.string.my_message, R.drawable.ic_menu_sample_icon, new MessageListFragement(), true));
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
		}, false));
	}
	
	//应用启动默认展现哪个菜单
	@Override
	protected int getDefaultSelection() {
		return 0;
	}
}
