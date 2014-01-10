package com.recruit.app.ui.common;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


import com.recruit.app.ui.Injector;

import javax.inject.Inject;

import butterknife.Views;

/**
 * Base Activities that need fragments.
 */
public class AbstractFragmentActivity extends ActionBarActivity {

    @Inject
    protected com.squareup.otto.Bus eventBus;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Injector.inject(this);
    }

    @Override
    public void setContentView(final int layoutResId) {
        super.setContentView(layoutResId);

        Views.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventBus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        eventBus.unregister(this);
    }

}
