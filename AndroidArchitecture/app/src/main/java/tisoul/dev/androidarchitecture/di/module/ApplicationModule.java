package tisoul.dev.androidarchitecture.di.module;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tisoul.dev.androidarchitecture.AppApplication;
import tisoul.dev.data.repository.ProfileDataRepository;
import tisoul.dev.domain.repository.ProfileRepository;

@Module
public class ApplicationModule {
    private final AppApplication application;

    public ApplicationModule(AppApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ProfileRepository provideProfileRepository(ProfileDataRepository profileRepository) {
        return profileRepository;
    }
}
