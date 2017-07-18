package tisoul.dev.androidarchitecture.di.module;

import dagger.Module;
import dagger.Provides;
import tisoul.dev.androidarchitecture.di.scope.PerActivity;
import tisoul.dev.androidarchitecture.mvp.Profile;
import tisoul.dev.androidarchitecture.mvp.ProfilePresenter;
import tisoul.dev.domain.domain.usecase.GetUserProfile;
import tisoul.dev.domain.domain.usecase.UpdateUserProfile;
import tisoul.dev.domain.domain.usecase.impl.GetUserProfileUseCase;
import tisoul.dev.domain.domain.usecase.impl.UpdateUserProfileUseCase;

@Module
public class ProfileModule {

    @Provides
    @PerActivity
    GetUserProfile provideGetUserProfileUseCase(GetUserProfileUseCase getUserListUseCase) {
        return getUserListUseCase;
    }

    @Provides
    @PerActivity
    UpdateUserProfile provideUpdateUserProfileUseCase(UpdateUserProfileUseCase updateUserProfileUseCase) {
        return updateUserProfileUseCase;
    }

    @Provides
    @PerActivity
    Profile.Presenter provideProfilePresenter(ProfilePresenter profilePresenter) {
        return profilePresenter;
    }
}
