package com.recruit.app.ui.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.recruit.R;
import com.recruit.app.service.factory.SQLiteServiceFactory;

public class SearchActivity extends Activity{
	
	private EditText searchEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		searchEditText = (EditText)findViewById(R.id.search_input);
		
		initViews();
	}
	
	
	
	private void initViews() {
		
		// 输入框的回车事件
		searchEditText.setOnEditorActionListener(new OnEditorActionListener() {
          
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                search();
                return true;
            }
        });
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void search(){
		String keywords = searchEditText.getText().toString();
		Intent it = new Intent(this, SearchListActivity.class);
		it.putExtra("keywords", keywords);
		startActivity(it);
	}

}
