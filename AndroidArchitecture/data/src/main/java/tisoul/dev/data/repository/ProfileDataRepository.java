package tisoul.dev.data.repository;


import javax.inject.Inject;

import tisoul.dev.domain.model.UserProfile;
import tisoul.dev.domain.repository.ProfileRepository;
import tisoul.dev.domain.repository.model.ResultCallback;

public class ProfileDataRepository
        implements ProfileRepository {

    private UserProfile userProfile;

    @Inject
    public ProfileDataRepository() {
        this.userProfile = new UserProfile("Nguyen Cao Tai", "nguyencaotai@gmail.com");
    }

    @Override
    public void getProfile(ResultCallback<UserProfile> result) {
        //perform async task here
        result.onSuccess(userProfile);
    }

    @Override
    public void saveProfile(UserProfile userProfile, ResultCallback<Void> resultCallback) {
        //perform async task here
        this.userProfile = userProfile;
        resultCallback.onSuccess(null);
    }
}
