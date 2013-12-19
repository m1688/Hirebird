package com.recruit.app;

import dagger.Module;

/**
 * Add all the other modules to this one.
 */
@Module(
        includes = {
                AndroidModule.class,
                BootstrapModule.class
        },
        library = true
)
public class RootModule {
}
