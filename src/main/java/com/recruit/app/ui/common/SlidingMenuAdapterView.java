package com.recruit.app.ui.common;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.recruit.R;

public class SlidingMenuAdapterView extends ArrayAdapter<SlidingMenuItemBean> {
	private int resourceId;
	
	
	public SlidingMenuAdapterView(Context context, int textViewResourceId, List<SlidingMenuItemBean> items) {
		super(context, textViewResourceId, items);
		this.resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout view;
		if(convertView == null) {
			view = new LinearLayout(getContext());
			LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layoutInflater.inflate(resourceId, view, true);
		} else {
			view = (LinearLayout)convertView;
		}
		
		SlidingMenuItemBean item = getItem(position);
		int menuNameRes = item.getMenuNameRes();
		boolean hasEvent = item.isHasEvent();
		int iconDrawableRes = item.getIconDrawableRes();
		
		TextView nameView = (TextView)view.findViewById(R.id.menu_name_view);
		nameView.setText(view.getResources().getString(menuNameRes));
		
		if(iconDrawableRes != 0) {
			nameView.setCompoundDrawablesWithIntrinsicBounds(view.getResources().getDrawable(iconDrawableRes), null, null, null);
		}
		LinearLayout lly = (LinearLayout)view.findViewById(R.id.menu_item_linear);
		
		if(!hasEvent) {
			view.setEnabled(false);
			lly.setBackgroundColor(view.getResources().getColor(R.color.menu_unselectable));
			nameView.setTextSize(view.getResources().getDimension(R.dimen.unselectable_menu_name_size));
			nameView.setPadding(15, nameView.getPaddingTop(), nameView.getPaddingRight(), nameView.getPaddingBottom());
			nameView.setTextColor(view.getResources().getColor(R.color.menu_unselectable_font));
			return view;
		}
		
		//这里也做一次背景色调整，如果只是在SlidingMenuActivity.DrawerItemClickListener中做的话，隐藏的那部分item的背景色不会改变
		if(item.isSelected()) {
			lly.setBackgroundColor(view.getResources().getColor(R.color.menu_selected));
            nameView.setTextColor(view.getResources().getColor(R.color.menu_selected_font));
        } else {
        	lly.setBackgroundColor(view.getResources().getColor(R.color.menu_unselected));
            nameView.setTextColor(view.getResources().getColor(R.color.menu_unselected_font));
        }
		return view;
	}
	
	@Override
	public boolean isEnabled(int position) {
		return getItem(position).isHasEvent();
	}
	
	public static interface OnSlidingMenuItemSelectedListener {
		public void onSlidingMenuItemSelected(View view, int position);
	}
}
