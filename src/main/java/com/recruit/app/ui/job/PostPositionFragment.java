package com.recruit.app.ui.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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
		listView.setAdapter(new ListItemAdaptor(getActivity()));
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
			int count = new Random().nextInt(10);
			map.put("count", String.valueOf(count));
			Log.d("number", count + "");
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
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		List<Integer> colors = Arrays.asList(
				Color.rgb(051, 153, 204),
				Color.rgb(153, 153, 051),
				Color.rgb(102, 102, 255),
				Color.rgb(052, 101, 052),
				Color.rgb(153, 051, 153),
				Color.rgb(153, 102, 0),
				Color.rgb(153, 051, 051),
				Color.rgb(102, 153, 255),
				Color.rgb(102, 153, 0),
				Color.rgb(153, 051, 102));

		public float dipToPixels(Context context, float dipValue) {
		    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
		}
		
		@Override
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
				paint.setColor(colors.get(Integer.parseInt(map.get("count"))));
				int size = (int)dipToPixels(getActivity(), 40);
				Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565);
				Canvas canvas = new Canvas(bitmap);
				canvas.drawRect(0, 0, size, size, paint);
				
				paint.setColor(Color.WHITE);
				int fontSize = (int)dipToPixels(getActivity(), 30);
				paint.setTextSize(fontSize);
				paint.setTextAlign(Align.CENTER);
				int height = size;
				int width = size;
				FontMetrics fontMetrics = paint.getFontMetrics(); 
				// 计算文字高度 
				float fontHeight = fontMetrics.bottom - fontMetrics.top; 
				// 计算文字baseline 
				float textBaseY = height - (height - fontHeight) / 2 - fontMetrics.bottom; 
				canvas.drawText(map.get("count"), width / 2, textBaseY, paint);

				imageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
			}
			return convertView;
		}
		
	}

	public static class PositionListListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			
		}
		
	}
}
