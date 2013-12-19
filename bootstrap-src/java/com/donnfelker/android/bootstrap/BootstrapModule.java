package main.donnfelker.android.bootstrap;

import android.accounts.AccountManager;
import android.content.Context;

import main.donnfelker.android.bootstrap.authenticator.BootstrapAuthenticatorActivity;
import main.donnfelker.android.bootstrap.authenticator.LogoutService;
import main.donnfelker.android.bootstrap.core.TimerService;
import main.donnfelker.android.bootstrap.ui.BootstrapTimerActivity;
import main.donnfelker.android.bootstrap.ui.MainActivity;
import main.donnfelker.android.bootstrap.ui.CheckInsListFragment;
import main.donnfelker.android.bootstrap.ui.NavigationDrawerFragment;
import main.donnfelker.android.bootstrap.ui.NewsActivity;
import main.donnfelker.android.bootstrap.ui.NewsListFragment;
import main.donnfelker.android.bootstrap.ui.UserActivity;
import main.donnfelker.android.bootstrap.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                MainActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NavigationDrawerFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }
)
public class BootstrapModule {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
