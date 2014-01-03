package com.recruit.app.ui.job;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.recruit.R;

public class PostJobActivity extends FragmentActivity {
	protected static final String COMPANY_TAB = "companyInfo";
	protected static final String JOB_TAB = "jobInfo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment fragment = Fragment.instantiate(this, PostJobCompanyFragment.class.getName());
		ft.add(android.R.id.content, fragment, COMPANY_TAB);
		ft.commit();
		

	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
