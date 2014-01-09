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
import com.recruit.app.domain.model.Company;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.domain.model.User;

@SuppressLint("ValidFragment")
public class PositionCompanyFragment extends Fragment {
	public static final String ARG_SECTION_NUMBER = "section_number";

	private User currentUser;
	private PositionModel position;

	public PositionCompanyFragment() {
	}

	public PositionCompanyFragment(User currentUser, PositionModel position) {
		this.currentUser = currentUser;
		this.position = position;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.position_company_fragment,
				container, false);
		initData(rootView);
		return rootView;
	}

	public void initData(View rootView) {
		if (position != null && position.getCompany() != null) {
			Company company = position.getCompany();
			Log.i("position_detail", "title===" + position.getTitle());
			TextView companyName = (TextView) rootView
					.findViewById(R.id.company_name);
			companyName.setText(company.getName());
			TextView companyIndustry = (TextView) rootView.findViewById(R.id.company_industry);
			companyIndustry.setText(company.getIndustry());
			TextView companyType = (TextView) rootView
					.findViewById(R.id.company_type);
			companyType.setText(company.getScale());
			TextView companyScale = (TextView) rootView.findViewById(R.id.company_scale);
			companyScale.setText(company.getStructure());
			TextView companyAddress = (TextView) rootView.findViewById(R.id.company_address);
			companyAddress.setText(company.getAddress());
			TextView companyDetail = (TextView) rootView.findViewById(R.id.company_detail);
			companyDetail.setText(company.getAddress());
		}
	}
}
