package com.recruit.app.ui;

import com.recruit.app.ui.common.NavigationDrawerFragment;
import com.recruit.app.ui.main.MainActivity;
import com.recruit.app.ui.me.MessageActivity;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
        (
                complete = false,

                injects = {
                        HireBirdApplication.class,
                        NavigationDrawerFragment.class,
                        MessageActivity.class,
                        MainActivity.class
                }

        )
public class HireBirdModule {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

//    @Provides
//    @Singleton
//    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
//        return new LogoutService(context, accountManager);
//    }

}
