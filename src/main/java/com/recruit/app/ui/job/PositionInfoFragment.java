package com.recruit.app.ui.job;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recruit.R;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.domain.model.User;
import com.recruit.app.util.DateUtil;

@SuppressLint("ValidFragment")
public class PositionInfoFragment extends Fragment {
	private User currentUser;
	private PositionModel position;

	public PositionInfoFragment() {
	}

	public PositionInfoFragment(User currentUser, PositionModel position) {
		this.currentUser = currentUser;
		this.position = position;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.position_info_fragment,
				container, false);
		initData(rootView);
		return rootView;
	}
	
	public void initData(View rootView){
		if(position != null){
			Log.i("position_detail", "title==="+position.getTitle());
			TextView positionName = (TextView)rootView.findViewById(R.id.positionName);
			positionName.setText(position.getTitle());
			TextView postDate = (TextView)rootView.findViewById(R.id.postDate);
			postDate.setText(DateUtil.formatDate(position.getPostDate()));
			TextView companyName = (TextView)rootView.findViewById(R.id.companyName);
			companyName.setText(position.getCompany().getName());
			TextView degree = (TextView)rootView.findViewById(R.id.degree);
			degree.setText(position.getLowestDegree());
			TextView salary = (TextView)rootView.findViewById(R.id.salary);
			salary.setText(position.getSalary());
			TextView workYear = (TextView)rootView.findViewById(R.id.workYear);
			workYear.setText(position.getWorkYear()+"年");
			TextView positionType = (TextView)rootView.findViewById(R.id.positionType);
			positionType.setText(position.getFunction());
			TextView detail = (TextView)rootView.findViewById(R.id.detail);
			detail.setText(position.getDetail());
		}
		
	}
}
