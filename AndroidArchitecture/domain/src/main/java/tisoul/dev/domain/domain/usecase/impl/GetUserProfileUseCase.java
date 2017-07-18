package tisoul.dev.domain.domain.usecase.impl;


import javax.inject.Inject;

import io.reactivex.Observable;
import tisoul.dev.domain.domain.usecase.GetUserProfile;
import tisoul.dev.domain.model.UserProfile;
import tisoul.dev.domain.repository.ProfileRepository;
import tisoul.dev.domain.repository.model.ResultCallback;

public class GetUserProfileUseCase
        implements GetUserProfile {

    private ProfileRepository profileRepository;

    @Inject
    public GetUserProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Observable<UserProfile> execute(Void aVoid) {
        return Observable
                .create(emitter -> profileRepository
                        .getProfile(
                                new ResultCallback<UserProfile>() {
                                    @Override
                                    public void onSuccess(UserProfile userProfile) {
                                        emitter.onNext(userProfile);
                                        emitter.onComplete();
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                        emitter.onError(throwable);
                                    }
                                }));
    }
}
