package tisoul.dev.data.repository;


import tisoul.dev.domain.model.UserProfile;
import tisoul.dev.domain.repository.ProfileRepository;
import tisoul.dev.domain.repository.model.ResultCallback;

public class ProfileRepositoryImpl
        implements ProfileRepository {

    private static ProfileRepositoryImpl mInstance;
    private UserProfile userProfile;

    private ProfileRepositoryImpl(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public static ProfileRepositoryImpl getInstance() {
        if (mInstance == null) {
            mInstance = new ProfileRepositoryImpl(
                    new UserProfile("Nguyen Cao Tai", "nguyencaotai@gmail.com"));
        }
        return mInstance;
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
