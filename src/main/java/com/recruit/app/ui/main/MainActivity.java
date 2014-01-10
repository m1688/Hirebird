package com.recruit.app.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.recruit.R;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.ui.common.SlidingMenuActivity;
import com.recruit.app.ui.job.PostJobActivity;

public class MainActivity extends SlidingMenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RecruitSQLiteOpenHelper.init(getApplicationContext());
		SampleDatas.init();	//去掉注释生成例子数据，只需要生成一次即可，除非手动将数据库文件删掉了才需要再次生成
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
	
//  返回键退出
  private long exitTime = 0;
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
      if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
          if((System.currentTimeMillis()-exitTime) > 2000){  
              Toast.makeText(getApplicationContext(), this.getString(R.string.app_exit), Toast.LENGTH_SHORT).show();                                
              exitTime = System.currentTimeMillis();   
          } else {
              finish();
              System.exit(0);
          }
          return true;   
      }
      return super.onKeyDown(keyCode, event);
  }

}
