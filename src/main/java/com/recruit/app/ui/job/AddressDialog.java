package com.recruit.app.ui.job;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.recruit.R;

public class AddressDialog extends DialogFragment {
	private int[] cityIds = { R.array.beijing, R.array.tianjing,
			R.array.heibei, R.array.shanxi, R.array.neimenggu,
			R.array.liaoning, R.array.qilin, R.array.heilongjiang,
			R.array.shanghai, R.array.jiangsu, R.array.zhejiang, R.array.anhui,
			R.array.fujian, R.array.jiangxi, R.array.shandong, R.array.henan,
			R.array.hubei, R.array.hunan, R.array.guangdong, R.array.guangxi,
			R.array.hainan, R.array.chongqing, R.array.sichuan,
			R.array.guizhou, R.array.yunnan, R.array.xizang, R.array.shanxixi,
			R.array.gansu, R.array.qinhai, R.array.ningxia, R.array.xinjiang,
			R.array.taiwan, R.array.xianggang, R.array.aomen };
	private WheelView province;
	private WheelView city;

	private String[] citys;

	private boolean scrolling = false;

	private TextView address;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		address = (TextView) getActivity().findViewById(R.id.companyAddress);

		LayoutInflater inflater = LayoutInflater.from(getActivity());
		View view = inflater.inflate(R.layout.address_choose, null);

		builder.setView(view);

		province = (WheelView) view.findViewById(R.id.choose_province);
		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(
				getActivity(), getResources().getStringArray(R.array.province));
		adapter.setTextSize(18);
		province.setViewAdapter(adapter);

		city = (WheelView) view.findViewById(R.id.choose_city);

		province.setVisibleItems(5);
		city.setVisibleItems(5);

		province.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if (!scrolling) {
					updateCities(city, newValue);
				}
			}
		});

		province.addScrollingListener(new OnWheelScrollListener() {
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			}

			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;
				updateCities(city, province.getCurrentItem());
			}
		});

		builder.setPositiveButton(R.string.save,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						int provinceIndex = province.getCurrentItem();
						int cityIndex = city.getCurrentItem();
						String province = getResources().getStringArray(
								R.array.province)[provinceIndex];
						String city = citys[cityIndex];

						address.setText(province + city);
					}
				}).setNegativeButton(R.string.cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						AddressDialog.this.getDialog().cancel();
					}
				});
		return builder.create();
	}

	private void updateCities(WheelView city, int index) {
		citys = getResources().getStringArray(cityIds[index]);
		ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(
				getActivity(), getResources().getStringArray(cityIds[index]));
		adapter.setTextSize(18);
		city.setViewAdapter(adapter);
		city.setCurrentItem(0);
	}

}
