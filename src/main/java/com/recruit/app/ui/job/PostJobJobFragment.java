package com.recruit.app.ui.job;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

import com.recruit.R;
import com.recruit.app.service.sqlite.SQLitePositionService;

public class PostJobJobFragment extends PostJobFragment {
	private FragmentActivity activity;
	
	private EditText location;
	
	private EditText year;
	
	private EditText salary;
	
	private EditText education;
	
	private EditText requirement;
	
	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.activity = getActivity();
		
		ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.post_job_info, null);
		
		location = (EditText)rootView.findViewById(R.id.workLocation);
		year = (EditText)rootView.findViewById(R.id.workYear);
		salary = (EditText)rootView.findViewById(R.id.workSalary);
		education = (EditText)rootView.findViewById(R.id.educationLevel);
		requirement = (EditText)rootView.findViewById(R.id.jobFunction);

		rootView.findViewById(R.id.previousBtn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = activity.getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				Fragment fragment = fm.findFragmentByTag(PostJobActivity.COMPANY_TAB);
				if(fragment == null) {
					fragment = Fragment.instantiate(activity, PostJobCompanyFragment.class.getName());
					ft.add(android.R.id.content, fragment, PostJobActivity.COMPANY_TAB);
				} else {
					ft.attach(fragment);
					ft.show(fragment);
				}
				ft.hide(PostJobJobFragment.this);
				ft.commit();
			}
		});
		
		rootView.findViewById(R.id.saveBtn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				retrieveValue();
				SQLitePositionService service = new SQLitePositionService();
				service.addPosition(position);
				
				getActivity().finish();
			}
		});
		return rootView;
	}
	
	private void retrieveValue() {
		if(location.getText() != null){
			position.setLocation(location.getText().toString());
		}
		try{
			position.setWorkYear(Integer.parseInt(year.getText().toString()));
		}catch(Exception e){}

		if(salary.getText() != null){
			position.setSalary(salary.getText().toString());
		}

		if(requirement.getText() != null) {
			position.setSkill(requirement.getText().toString());
		}

		if(education.getText() != null) {
			position.setLowestDegree(education.getText().toString());
		}
	}
}
