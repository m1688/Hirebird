package com.recruit.app.ui.common;

import android.support.v4.app.Fragment;


class SlidingMenuItemBean {
	private int menuNameRes;
	private boolean hasEvent;
	private int iconDrawableRes;
	private Fragment fragment;
	
	public SlidingMenuItemBean(int menuNameRes, int iconDrawableRes, Fragment fragment, boolean hasEvent) {
		this.menuNameRes = menuNameRes;
		this.hasEvent = hasEvent;
		this.fragment = fragment;
		this.iconDrawableRes = iconDrawableRes;
	}
	
	public SlidingMenuItemBean(int menuNameRes, boolean hasEvent) {
		this.menuNameRes = menuNameRes;
		this.hasEvent = hasEvent;
	}

	public int getMenuNameRes() {
		return menuNameRes;
	}

	public void setMenuNameRes(int menuNameRes) {
		this.menuNameRes = menuNameRes;
	}

	public boolean isHasEvent() {
		return hasEvent;
	}

	public void setHasEvent(boolean hasEvent) {
		this.hasEvent = hasEvent;
	}

	public int getIconDrawableRes() {
		return iconDrawableRes;
	}

	public void setIconDrawableRes(int iconDrawableRes) {
		this.iconDrawableRes = iconDrawableRes;
	}

	public Fragment getFragment() {
		return fragment;
	}

	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}
}
