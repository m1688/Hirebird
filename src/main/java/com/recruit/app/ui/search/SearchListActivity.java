package com.recruit.app.ui.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.recruit.R;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.service.factory.SQLiteServiceFactory;
import com.recruit.app.ui.common.SearchSuggestionProvider;
import com.recruit.app.ui.main.SampleDatas;

public class SearchListActivity extends Activity{
	SQLiteServiceFactory serviceFactory = new SQLiteServiceFactory();
	private SearchView searchView;
	MenuItem searchMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchlist);
		getActionBar().setDisplayHomeAsUpEnabled(true); 
		initViews();
	}
	
	
	@Override
	protected void onNewIntent(Intent intent) {
		doQuery(intent);
	}
	
	private void initViews() {
		Intent intent = getIntent();
		doQuery(intent);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		searchMenu = menu.findItem(R.id.search);
		SearchManager searchManager = (SearchManager) getSystemService(this.SEARCH_SERVICE);
	    searchView = (SearchView) searchMenu.getActionView();
	    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
	    searchView.setIconifiedByDefault(false);
	    searchView.requestFocusFromTouch();
	    
		return true;
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        	case android.R.id.home:
        		this.finish();
        		return true;
        	default:
        		return super.onOptionsItemSelected(item);
        }
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
	
	private void doQuery(Intent intent){
		String keywords="";
		Bundle extras = intent.getExtras();
        
        if (extras != null) {
        	keywords = extras.getString("keywords");
            setTitle("搜索："+keywords);
        }
//        通过searchview触发
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
  	      String query = intent.getStringExtra(SearchManager.QUERY);
  	      setTitle("搜索："+query);
//  	      saving query
  	      SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                SearchSuggestionProvider.AUTHORITY, SearchSuggestionProvider.MODE);
  	      suggestions.saveRecentQuery(query, null);
  	    }
//        默认收起搜索框
        if(searchView!=null&&!searchView.isIconified()){
//        	searchView.setIconified(true);
        	MenuItemCompat.collapseActionView(searchMenu);
        }
        
        
        ListView listView = (ListView)findViewById(R.id.search_listview);
		listView.setAdapter(new SimpleAdapter(
				this,				
				positionList(), 
				R.layout.postion_list_item, 
				new String[]{"name", "company", "address", "postDate"}, 
				new int[]{R.id.positionName, R.id.companyName, R.id.address, R.id.postDate}));
	}
	
//	清除历史搜索
//	public static void clearSearchHistory(){
//		SearchRecentSuggestions suggestions = new SearchRecentSuggestions(Context,
//				SearchSuggestionProvider.AUTHORITY, SearchSuggestionProvider.MODE);
//		suggestions.clearHistory();
//	}
}
