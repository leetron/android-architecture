package tisoul.dev.data;


import tisoul.dev.data.model.UserProfile;

public interface ProfileRepository {
    UserProfile getProfile();

    void saveProfile(UserProfile userProfile);
}
