package com.recruit.app.ui.job;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
		listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new String[]{"好","很好啊"}));
		return view;
	}
}
