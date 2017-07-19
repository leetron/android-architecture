package tisoul.dev.androidarchitecture.di.component


import android.content.Context
import dagger.Component
import tisoul.dev.androidarchitecture.di.module.ApplicationModule
import tisoul.dev.domain.repository.ProfileRepository
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun context(): Context

    fun profileRepository(): ProfileRepository
}
