package tisoul.dev.androidarchitecture.di.module


import android.content.Context
import dagger.Module
import dagger.Provides
import tisoul.dev.androidarchitecture.AppApplication
import tisoul.dev.data.repository.ProfileDataRepository
import tisoul.dev.domain.repository.ProfileRepository
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AppApplication) {

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return this.application
    }

    @Provides
    @Singleton
    internal fun provideProfileRepository(profileRepository: ProfileDataRepository): ProfileRepository {
        return profileRepository
    }
}
