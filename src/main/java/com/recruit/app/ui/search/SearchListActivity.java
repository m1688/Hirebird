package com.recruit.app.ui.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
//		RecruitSQLiteOpenHelper.init(getApplicationContext());
//		SampleDatas.init();	//去掉注释生成例子数据，只需要生成一次即可，除非手动将数据库文件删掉了才需要再次生成
		
		initViews();
	}
	
	
	
	private void initViews() {
		String keywords="";
		Bundle extras = getIntent().getExtras();
        
        if (extras != null) {
        	keywords = extras.getString("keywords");
            setTitle("搜索："+keywords);
        }
        ListView listView = (ListView)findViewById(R.id.search_listview);
		listView.setAdapter(new SimpleAdapter(
				this,				
				positionList(), 
				R.layout.postion_list_item, 
				new String[]{"name", "company", "address", "postDate"}, 
				new int[]{R.id.positionName, R.id.companyName, R.id.address, R.id.postDate}));
//		 List<PositionModel> positionList =	serviceFactory.getPositionService().queryList(title);
//		 positionList.size();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private List<Map<String, String>> positionList(){
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(int i = 0; i < 10; i++) {
			Map<String, String> map  = new HashMap<String, String>();
			map.put("name", "java工程师");
			map.put("company", "阿里巴巴技股份有限公司");
			map.put("address", "浙江,杭州");
			map.put("postDate", "2013-12-12");
			list.add(map);
		}
		
		return list;
	}
}
