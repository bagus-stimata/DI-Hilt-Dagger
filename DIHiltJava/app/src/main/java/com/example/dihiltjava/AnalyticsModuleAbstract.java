package com.example.dihiltjava;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class AnalyticsModuleAbstract {
    @Binds
    public abstract AnalyticsService bindAnalyticsService(
            AnalyticsServiceImpl analyticsServiceImpl
    );
}
