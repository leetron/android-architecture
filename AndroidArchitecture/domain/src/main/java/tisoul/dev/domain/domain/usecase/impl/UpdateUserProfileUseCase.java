package tisoul.dev.domain.domain.usecase.impl;


import io.reactivex.Observable;
import tisoul.dev.domain.domain.usecase.UpdateUserProfile;
import tisoul.dev.domain.model.UserProfile;
import tisoul.dev.domain.repository.ProfileRepository;
import tisoul.dev.domain.repository.model.ResultCallback;

public class UpdateUserProfileUseCase
        implements UpdateUserProfile {
    ProfileRepository profileRepository;

    public UpdateUserProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Observable<Void> execute(final UserProfile userProfile) {
        return Observable.create(emitter -> profileRepository
                .saveProfile(userProfile, new ResultCallback<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        emitter.onComplete();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Update profile error");
                        emitter.onError(throwable);
                    }
                }));
    }
}
