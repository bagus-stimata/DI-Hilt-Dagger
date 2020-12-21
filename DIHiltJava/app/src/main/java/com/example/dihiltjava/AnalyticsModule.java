package com.example.dihiltjava;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(ActivityComponent.class)
public class AnalyticsModule {
    @Provides
    public static AnalyticsService provideAnalyticsService(
            // Potential dependencies of this type
    ) {
        return new Retrofit.Builder()
                .baseUrl("https://example.com")
                .build()
                .create(AnalyticsService.class);
    }
}
