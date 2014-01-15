package com.recruit.app.ui.search;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.SearchView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.recruit.R;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {
	
	private EditText searchEditText;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_search, null);
		
//		searchEditText = (EditText)view.findViewById(R.id.search_input);
		
		initViews(view);
		return view;
	}
	
	
	private void initViews(View view) {
		SearchView searchView=(SearchView) view.findViewById(R.id.search_view);
        //为该SearchView组件设置事件监听器
		searchView.setOnQueryTextListener(this);
//        searchView.setOnSuggestionListener(this);
//		
		// 输入框的回车事件
//		searchEditText.setOnEditorActionListener(new OnEditorActionListener() {
//          
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                search();
//                return true;
//            }
//        });
	}

	
	
	//用户输入字符时激发该方法
    @Override
    public boolean onQueryTextChange(String newText) {
//        // TODO Auto-generated method stub
//        if(TextUtils.isEmpty(newText))
//        {
//            //清楚ListView的过滤
//            lv.clearTextFilter();
//        }
//        else
//        {
//            //使用用户输入的内容对ListView的列表项进行过滤
//            lv.setFilterText(newText);
//        
//        }
        return true;
    }
    
    //单击搜索按钮时激发该方法
   @Override
   public boolean onQueryTextSubmit(String query) {
       // TODO Auto-generated method stub
       //实际应用中应该在该方法内执行实际查询
	   search(query);
       return true;
   }
   
   public void search(String query){
		String keywords = query;
		Intent it = new Intent(getActivity(), SearchListActivity.class);
		it.putExtra("keywords", keywords);
		startActivity(it);
	}
}
