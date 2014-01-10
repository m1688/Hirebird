package com.recruit.app.ui.event;

/**
 * Pub/Sub event used to communicate between fragment and activity.
 *
 */
public class NavItemSelectedEvent {
    private int itemPosition;

    public NavItemSelectedEvent(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public int getItemPosition() {
        return itemPosition;
    }
}
