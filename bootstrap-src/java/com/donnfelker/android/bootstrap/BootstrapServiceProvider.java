
package main.donnfelker.android.bootstrap;

import android.accounts.AccountsException;
import android.app.Activity;

import main.donnfelker.android.bootstrap.authenticator.ApiKeyProvider;
import main.donnfelker.android.bootstrap.core.BootstrapService;
import main.donnfelker.android.bootstrap.core.UserAgentProvider;

import java.io.IOException;

import javax.inject.Inject;

/**
 * Provider for a {@link main.donnfelker.android.bootstrap.core.BootstrapService} instance
 */
public class BootstrapServiceProvider {

    @Inject ApiKeyProvider keyProvider;
    @Inject UserAgentProvider userAgentProvider;

    /**
     * Get service for configured key provider
     * <p/>
     * This method gets an auth key and so it blocks and shouldn't be called on the main thread.
     *
     * @return bootstrap service
     * @throws IOException
     * @throws AccountsException
     */
    public BootstrapService getService(final Activity activity)
            throws IOException, AccountsException {
        return new BootstrapService(keyProvider.getAuthKey(activity), userAgentProvider);
    }
}
