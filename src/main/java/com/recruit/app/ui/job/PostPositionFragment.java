package com.recruit.app.ui.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
		listView.setOnItemClickListener(new ListView.OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(PostPositionFragment.this.getActivity(), PositionDetailActivity.class);
			    intent.putExtra("positionId", Long.valueOf(position));
			    startActivity(intent);
			}
		});
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
			map.put("address", "阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司阿里巴巴技股份有限公司");
//			map.put("address", "浙江,杭州");
			map.put("postDate", "2013-12-12");
			list.add(map);
		}
		
		return list;
	}
	
	class ListItemAdaptor extends BaseAdapter {
		private List<Map<String, String>> list = positionList();
		
		private LayoutInflater inflater;
		public ListItemAdaptor(Context context){
			inflater = LayoutInflater.from(context);
		}
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null) {
				convertView = inflater.inflate(R.layout.postion_list_item, null);

				Map<String, String> map = list.get(position);
				TextView positionName = (TextView)convertView.findViewById(R.id.positionName);
				positionName.setText(map.get("name"));
				TextView postDate = (TextView)convertView.findViewById(R.id.postDate);
				postDate.setText(map.get("postDate"));
				TextView address = (TextView)convertView.findViewById(R.id.address);
				address.setText(map.get("address"));
				
				ImageView imageView = (ImageView)convertView.findViewById(R.id.requestCount);
				
				Paint paint = new Paint();
				paint.setColor(Color.RED);
				
				Bitmap bitmap = Bitmap.createBitmap(60, 60, Bitmap.Config.RGB_565);
				Canvas canvas = new Canvas(bitmap);
				canvas.drawRect(0, 0, 60, 60, paint);
				
				paint.setColor(Color.WHITE);
				paint.setTextSize(40);
				canvas.drawText("2", 30, 30, paint);

				imageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
			}
			return convertView;
		}
		
	}

	public static class PositionListListener implements ListView.OnItemClickListener{

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
		}
		
	}
}
