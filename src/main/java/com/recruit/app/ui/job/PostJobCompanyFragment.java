package com.recruit.app.ui.job;




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
import android.widget.Spinner;

import com.recruit.R;
import com.recruit.app.domain.model.Company;
import com.recruit.app.domain.model.PositionModel;




public class PostJobCompanyFragment extends PostJobFragment {
	private FragmentActivity activity;
	
	private EditText mName;
	
	private EditText mAddress;
	
	private EditText mIndustry;
	
	private Spinner	 mStructure;
	
	private Spinner mScale;
	
	private static final String NAME = "name";
	private static final String ADDRESS = "address";
	private static final String INDUSTRY = "industry";
	private static final String STRUCTURE = "structure";
	private static final String SCALE = "scale";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.post_job_company_info_fragment, null);
		
		mName = (EditText)rootView.findViewById(R.id.companyName);
		mAddress = (EditText)rootView.findViewById(R.id.companyAddress);
		mIndustry = (EditText)rootView.findViewById(R.id.companyIndustry);
		mStructure = (Spinner)rootView.findViewById(R.id.companyStructureSpinner);
		mScale = (Spinner)rootView.findViewById(R.id.companyScaleSpinner);
		
		activity = getActivity();
		
		rootView.findViewById(R.id.nextStepBtn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				retrieveValue();
				FragmentManager fm = activity.getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				Fragment fragment = fm.findFragmentByTag(PostJobActivity.JOB_TAB);
				if(fragment != null) {
					ft.show(fragment);
				}
				else {
					fragment = Fragment.instantiate(activity, PostJobJobFragment.class.getName(), null);
					ft.add(android.R.id.content, fragment, PostJobActivity.JOB_TAB);
				}

				ft.hide(PostJobCompanyFragment.this);
				
				ft.commit();
			}
		});
		return rootView;
	}
	
	private void retrieveValue() {
		Company company = new Company();
		if(mName.getText() != null)
			company.setName(mName.getText().toString());
		if(mAddress.getText() != null)
			company.setAddress(mAddress.getText().toString());
		if(mIndustry.getText() !=  null)
			company.setIndustry(mIndustry.getText().toString());
		company.setScale(mScale.toString());
		company.setStructure(mStructure.toString());
		position.setCompany(company);
	}
	
	@Override
	public void onDetach() {
		if(this.position == null) {
			position = new PositionModel();
		}
		
		Company company = new Company();
		company.setName(mName.getText().toString());
		company.setAddress(mAddress.getText().toString());
		company.setIndustry(mIndustry.getText().toString());
		company.setScale(mScale.toString());
		company.setStructure(mStructure.toString());
		
		super.onDetach();
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putString(NAME, mName.getText().toString());
		outState.putString(ADDRESS, mAddress.getText().toString());
		outState.putString(INDUSTRY, mIndustry.getText().toString());
		outState.putString(STRUCTURE, mStructure.toString());
		outState.putString(SCALE, mScale.toString());
		super.onSaveInstanceState(outState);
	}
	
}
