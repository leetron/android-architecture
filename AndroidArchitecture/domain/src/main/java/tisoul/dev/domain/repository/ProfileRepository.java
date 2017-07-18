package tisoul.dev.domain.repository;


import tisoul.dev.domain.model.UserProfile;
import tisoul.dev.domain.repository.model.ResultCallback;

public interface ProfileRepository {
    void getProfile(ResultCallback<UserProfile> result);

    void saveProfile(UserProfile userProfile, ResultCallback<Void> resultCallback);
}
