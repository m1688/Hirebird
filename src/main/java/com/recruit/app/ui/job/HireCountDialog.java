package com.recruit.app.ui.job;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.recruit.R;

public class HireCountDialog extends DialogFragment {
	private TextView hireCount;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		
		hireCount = (TextView)getActivity().findViewById(R.id.companyScaleSpinner);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.company_structure, null);
		builder.setView(view).setMessage(R.string.hire_count_lable);
		builder.setPositiveButton(R.string.save,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						
					}
				}).setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
				
					}

				});
			
		return builder.create();
	}
}
