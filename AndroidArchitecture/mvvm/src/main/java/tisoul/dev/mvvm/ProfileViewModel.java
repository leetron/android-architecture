package tisoul.dev.mvvm;


import android.databinding.ObservableField;

import tisoul.dev.data.ProfileRepository;
import tisoul.dev.data.model.UserProfile;

public class ProfileViewModel {
    public final ObservableField<CharSequence> name = new ObservableField<>();
    public final ObservableField<CharSequence> email = new ObservableField<>();

    ProfileRepository profileRepository;

    public ProfileViewModel(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void subscribe() {
        UserProfile userProfile = profileRepository.getProfile();

        name.set(userProfile.name);
        email.set(userProfile.email);
    }

    public void onUpdateClick() {
        profileRepository
                .saveProfile(
                        new UserProfile(
                                name.get(),
                                email.get()));
    }
}
