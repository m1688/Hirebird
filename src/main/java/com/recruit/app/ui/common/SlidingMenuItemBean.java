package com.recruit.app.ui.common;

import com.recruit.app.ui.common.SlidingMenuAdapterView.OnSlidingMenuItemSelectedListener;

import android.support.v4.app.Fragment;


/**
 * hasEvent为true时才会做出响应，包括两部分：
 * 1、fragment不为null，替换主界面的Fragment；
 * 2、onSlidingMenuItemSelectedListener不为null，调用其中的onSlidingMenuItemSelected方法.
 * @author Administrator
 *
 */
class SlidingMenuItemBean {
	private int menuNameRes;
	private boolean hasEvent;
	private int iconDrawableRes;
	private Fragment fragment;
	private OnSlidingMenuItemSelectedListener onSlidingMenuItemSelectedListener;
	private boolean isSelected;
	private boolean isSelectable = true;//选择是是否高亮
	
	public SlidingMenuItemBean(int menuNameRes, int iconDrawableRes, Fragment fragment, boolean hasEvent) {
		this.menuNameRes = menuNameRes;
		this.hasEvent = hasEvent;
		this.fragment = fragment;
		this.iconDrawableRes = iconDrawableRes;
	}
	
	public SlidingMenuItemBean(int menuNameRes, int iconDrawableRes, Fragment fragment, boolean hasEvent, OnSlidingMenuItemSelectedListener onSlidingMenuItemSelectedListener) {
		this.menuNameRes = menuNameRes;
		this.hasEvent = hasEvent;
		this.fragment = fragment;
		this.iconDrawableRes = iconDrawableRes;
		this.onSlidingMenuItemSelectedListener = onSlidingMenuItemSelectedListener;
	}
	
	public SlidingMenuItemBean(int menuNameRes, int iconDrawableRes, Fragment fragment, boolean hasEvent, OnSlidingMenuItemSelectedListener onSlidingMenuItemSelectedListener, boolean isSelectable) {
	    this.menuNameRes = menuNameRes;
	    this.hasEvent = hasEvent;
	    this.fragment = fragment;
	    this.iconDrawableRes = iconDrawableRes;
	    this.onSlidingMenuItemSelectedListener = onSlidingMenuItemSelectedListener;
	    this.isSelectable = isSelectable;
	}
	
	public SlidingMenuItemBean(int menuNameRes, boolean hasEvent) {
		this.menuNameRes = menuNameRes;
		this.hasEvent = hasEvent;
	}
	
	public SlidingMenuItemBean(int menuNameRes, boolean hasEvent, OnSlidingMenuItemSelectedListener onSlidingMenuItemSelectedListener, boolean isSelectable) {
		this.menuNameRes = menuNameRes;
		this.hasEvent = hasEvent;
		this.onSlidingMenuItemSelectedListener = onSlidingMenuItemSelectedListener;
		this.isSelectable = isSelectable;
	}
	
	public SlidingMenuItemBean(int menuNameRes, boolean hasEvent, OnSlidingMenuItemSelectedListener onSlidingMenuItemSelectedListener) {
	    this.menuNameRes = menuNameRes;
	    this.hasEvent = hasEvent;
	    this.onSlidingMenuItemSelectedListener = onSlidingMenuItemSelectedListener;
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

	public OnSlidingMenuItemSelectedListener getOnSlidingMenuItemSelectedListener() {
		return onSlidingMenuItemSelectedListener;
	}

	public void setOnSlidingMenuItemSelectedListener(
			OnSlidingMenuItemSelectedListener onSlidingMenuItemSelectedListener) {
		this.onSlidingMenuItemSelectedListener = onSlidingMenuItemSelectedListener;
	}
    
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    public boolean isSelectable() {
        return isSelectable;
    }
    
    public void setSelectable(boolean isSelectable) {
        this.isSelectable = isSelectable;
    }
}
