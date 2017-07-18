package tisoul.dev.androidarchitecture.di.component;

import dagger.Component;
import tisoul.dev.androidarchitecture.di.module.ProfileModule;
import tisoul.dev.androidarchitecture.di.scope.PerActivity;
import tisoul.dev.androidarchitecture.mvp.MVPProfileFragment;
import tisoul.dev.androidarchitecture.mvvm.MVVMProfileFragment;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ProfileModule.class})
public interface ProfileComponent {
    void inject(MVVMProfileFragment mvvmProfileFragment);

    void inject(MVPProfileFragment mvpProfileFragment);
}
