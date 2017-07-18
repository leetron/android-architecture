package tisoul.dev.androidarchitecture;


import android.app.Application;

import tisoul.dev.androidarchitecture.di.component.ApplicationComponent;
import tisoul.dev.androidarchitecture.di.component.DaggerApplicationComponent;
import tisoul.dev.androidarchitecture.di.module.ApplicationModule;

public class AppApplication
        extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
