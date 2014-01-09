package com.recruit.app.ui.search;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.recruit.R;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.service.factory.SQLiteServiceFactory;
import com.recruit.app.ui.main.SampleDatas;

public class SearchListActivity extends Activity{
	SQLiteServiceFactory serviceFactory = new SQLiteServiceFactory();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchlist);
//		init Data
		RecruitSQLiteOpenHelper.init(getApplicationContext());
		SampleDatas.init();	//去掉注释生成例子数据，只需要生成一次即可，除非手动将数据库文件删掉了才需要再次生成
		
		initViews();
	}
	
	
	
	private void initViews() {
		String title="";
		 List<PositionModel> positionList =	serviceFactory.getPositionService().queryList(title);
		 positionList.size();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
