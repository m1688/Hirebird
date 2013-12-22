package com.recruit.app.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.recruit.R;
import com.recruit.app.db.RecruitSQLiteOpenHelper;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RecruitSQLiteOpenHelper.init(getApplicationContext());
		SampleDatas.init();	//去掉注释生成例子数据，只需要生成一次即可，除非手动将数据库文件删掉了才需要再次生成
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
