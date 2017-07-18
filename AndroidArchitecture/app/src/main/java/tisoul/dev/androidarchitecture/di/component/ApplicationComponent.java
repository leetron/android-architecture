package tisoul.dev.androidarchitecture.di.component;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import tisoul.dev.androidarchitecture.di.module.ApplicationModule;
import tisoul.dev.domain.repository.ProfileRepository;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();

    ProfileRepository profileRepository();
}
