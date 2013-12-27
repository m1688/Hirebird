package com.recruit.app.ui.job;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recruit.R;

public class PositionInfoFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.position_info_fragment,
				container, false);

		rootView.findViewById(R.id.demo_collection_button).setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View view) {
						Intent intent = new Intent(getActivity(),
								PositionCompanyFragment.class);
						startActivity(intent);
					}
				});

		rootView.findViewById(R.id.demo_external_activity).setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View view) {
						Intent externalActivityIntent = new Intent(
								Intent.ACTION_PICK);
						externalActivityIntent.setType("image/*");
						externalActivityIntent
								.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
						startActivity(externalActivityIntent);
					}
				});

		return rootView;
	}
}
