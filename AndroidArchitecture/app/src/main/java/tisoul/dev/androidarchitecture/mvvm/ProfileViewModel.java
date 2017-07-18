package tisoul.dev.androidarchitecture.mvvm;


import android.databinding.ObservableField;

import io.reactivex.disposables.CompositeDisposable;
import tisoul.dev.domain.domain.usecase.GetUserProfile;
import tisoul.dev.domain.domain.usecase.UpdateUserProfile;
import tisoul.dev.domain.model.UserProfile;

public class ProfileViewModel {
    public final ObservableField<CharSequence> name = new ObservableField<>();
    public final ObservableField<CharSequence> email = new ObservableField<>();

    private GetUserProfile getUserProfile;
    private UpdateUserProfile updateUserProfile;

    private CompositeDisposable disposables;

    public ProfileViewModel(GetUserProfile getUserProfile,
                            UpdateUserProfile updateUserProfile) {
        this.getUserProfile = getUserProfile;
        this.updateUserProfile = updateUserProfile;

        disposables = new CompositeDisposable();
    }

    public void subscribe() {
        disposables.add(
                getUserProfile
                        .execute(null)
                        .subscribe(userProfile -> {
                            name.set(userProfile.name);
                            email.set(userProfile.email);
                        }));
    }

    public void unSubscribe() {
        disposables.clear();
    }

    public void onUpdateClick() {
        disposables.add(
                updateUserProfile
                        .execute(
                                new UserProfile(
                                        name.get(),
                                        email.get()))
                        .subscribe(
                                aVoid -> System.out.println("Update success"),
                                error -> System.out.println("Update error")
                        ));
    }
}
