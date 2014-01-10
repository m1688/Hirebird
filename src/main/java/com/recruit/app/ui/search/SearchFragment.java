package com.recruit.app.ui.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.recruit.R;
import com.recruit.app.service.factory.SQLiteServiceFactory;

public class SearchFragment extends Fragment{
	
	private EditText searchEditText;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
        View view = inflater.inflate(R.layout.activity_search, null);
		
		searchEditText = (EditText)view.findViewById(R.id.search_input);
		
		initViews();
		
		return view;
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

	
	public void search(){
		String keywords = searchEditText.getText().toString();
		Intent it = new Intent(getActivity(), SearchListActivity.class);
		it.putExtra("keywords", keywords);
		startActivity(it);
	}

}
