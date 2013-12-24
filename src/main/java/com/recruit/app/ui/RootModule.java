package com.recruit.app.ui;

import dagger.Module;

/**
 * Add all the other modules to this one.
 */
@Module
(
    includes = {
            AndroidModule.class,
            HireBirdModule.class
    }
)
public class RootModule {
}
