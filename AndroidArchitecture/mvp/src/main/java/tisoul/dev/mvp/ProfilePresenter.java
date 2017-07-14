package tisoul.dev.mvp;


import tisoul.dev.data.ProfileRepository;
import tisoul.dev.data.model.UserProfile;

public class ProfilePresenter
        implements Profile.Presenter {

    private Profile.View view;
    private ProfileRepository profileRepository;

    public ProfilePresenter(Profile.View view,
                            ProfileRepository profileRepository) {
        this.view = view;
        this.profileRepository = profileRepository;
    }

    @Override
    public void start() {
        UserProfile userProfile = profileRepository.getProfile();

        view.setName(userProfile.name);
        view.setEmail(userProfile.email);
    }

    @Override
    public void update(CharSequence name, CharSequence email) {
        profileRepository
                .saveProfile(
                        new UserProfile(
                                name,
                                email));
    }
}
