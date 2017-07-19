package tisoul.dev.androidarchitecture.di.component

import dagger.Component
import tisoul.dev.androidarchitecture.di.module.ProfileModule
import tisoul.dev.androidarchitecture.di.scope.PerActivity
import tisoul.dev.androidarchitecture.mvp.MVPProfileFragment
import tisoul.dev.androidarchitecture.mvvm.MVVMProfileFragment

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ProfileModule::class))
interface ProfileComponent {
    fun inject(mvvmProfileFragment: MVVMProfileFragment)

    fun inject(mvpProfileFragment: MVPProfileFragment)
}
