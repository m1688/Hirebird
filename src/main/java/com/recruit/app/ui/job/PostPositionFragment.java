package com.recruit.app.ui.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.recruit.R;

/**
 * 发布职位
 * @author Administrator
 *
 */
public class PostPositionFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_post_position, container, false);
		ListView listView = (ListView)view.findViewById(R.id.testList);
		listView.setAdapter(new SimpleAdapter(
				getActivity(),				
				positionList(), 
				R.layout.postion_list_item, 
				new String[]{"name", "company", "address", "postDate"}, 
				new int[]{R.id.positionName, R.id.companyName, R.id.address, R.id.postDate}));

		setHasOptionsMenu(true);
		
		return view;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.postion_list_menu, menu);
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
	
	
	
	
	public static class PositionListListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			
		}
		
	}
}
