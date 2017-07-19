package tisoul.dev.androidarchitecture.di.module

import dagger.Binds
import dagger.Module
import tisoul.dev.androidarchitecture.di.scope.PerActivity
import tisoul.dev.androidarchitecture.mvp.Profile
import tisoul.dev.androidarchitecture.mvp.ProfilePresenter
import tisoul.dev.domain.domain.usecase.GetUserProfile
import tisoul.dev.domain.domain.usecase.UpdateUserProfile
import tisoul.dev.domain.domain.usecase.impl.GetUserProfileUseCase
import tisoul.dev.domain.domain.usecase.impl.UpdateUserProfileUseCase

@Module
abstract class ProfileModule {

//    @Provides
    @PerActivity
    @Binds
    abstract fun provideGetUserProfileUseCase(getUserListUseCase: GetUserProfileUseCase): GetUserProfile

//    @Provides
    @PerActivity
    @Binds
    abstract fun provideUpdateUserProfileUseCase(updateUserProfileUseCase: UpdateUserProfileUseCase): UpdateUserProfile

//    @Provides
    @PerActivity
    @Binds
    abstract fun provideProfilePresenter(profilePresenter: ProfilePresenter): Profile.Presenter
}
