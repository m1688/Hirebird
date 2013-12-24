
package com.recruit.app.ui;

import android.accounts.AccountsException;
import android.app.Activity;

import com.recruit.app.ui.common.HireBirdService;

import java.io.IOException;

/**
 * Provider for HireBirdService
 */
public class HireBirdServiceProvider {


    /**
     * Get service for configured key provider
     * <p/>
     * This method gets an auth key and so it blocks and shouldn't be called on the main thread.
     *
     * @return bootstrap service
     * @throws java.io.IOException
     * @throws android.accounts.AccountsException
     */
    public HireBirdService getService(Activity activity) throws IOException, AccountsException {
        return new HireBirdService();
    }
}
