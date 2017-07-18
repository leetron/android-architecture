package tisoul.dev.androidarchitecture.mvp;


import io.reactivex.disposables.CompositeDisposable;
import tisoul.dev.domain.domain.usecase.GetUserProfile;
import tisoul.dev.domain.domain.usecase.UpdateUserProfile;
import tisoul.dev.domain.model.UserProfile;

public class ProfilePresenter
        implements Profile.Presenter {

    private Profile.View view;

    private final GetUserProfile getUserProfile;
    private final UpdateUserProfile updateUserProfile;

    private final CompositeDisposable disposables;

    public ProfilePresenter(Profile.View view,
                            GetUserProfile getUserProfile,
                            UpdateUserProfile updateUserProfile) {
        this.view = view;
        this.getUserProfile = getUserProfile;
        this.updateUserProfile = updateUserProfile;

        this.view.setPresenter(this);
        disposables = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        disposables.add(
                getUserProfile
                        .execute(null)
                        .subscribe(
                                userProfile -> {
                                    view.setName(userProfile.name);
                                    view.setEmail(userProfile.email);
                                },
                                error -> System.out.println("Get Profile error")));
    }

    @Override
    public void unSubscribe() {
        disposables.clear();
    }

    @Override
    public void update(CharSequence name, CharSequence email) {
        disposables.add(
                updateUserProfile
                        .execute(
                                new UserProfile(
                                        name,
                                        email))
                        .subscribe(
                                aVoid -> System.out.println("Update success"),
                                error -> System.out.println("Update error")
                        ));
    }
}
