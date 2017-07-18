package tisoul.dev.androidarchitecture;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import tisoul.dev.androidarchitecture.mvp.MVPProfileFragment;
import tisoul.dev.androidarchitecture.mvp.ProfilePresenter;
import tisoul.dev.androidarchitecture.mvvm.MVVMProfileFragment;
import tisoul.dev.androidarchitecture.mvvm.ProfileViewModel;
import tisoul.dev.data.repository.ProfileRepositoryImpl;
import tisoul.dev.domain.domain.usecase.impl.GetUserProfileUseCase;
import tisoul.dev.domain.domain.usecase.impl.UpdateUserProfileUseCase;

public class ProfileActivity extends Activity {

    public static final String MODEL_TYPE = "model_type";

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        type = getIntent().getStringExtra(MODEL_TYPE);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        if ("mvp".equals(type)) {
            MVPProfileFragment fragment = new MVPProfileFragment();
            transaction.replace(R.id.frag_contain, fragment);
            transaction.commit();

            new ProfilePresenter(
                    fragment,
                    new GetUserProfileUseCase(
                            ProfileRepositoryImpl.getInstance()),
                    new UpdateUserProfileUseCase(
                            ProfileRepositoryImpl.getInstance()));
        } else if ("mvvm".equals(type)) {
            MVVMProfileFragment fragment = new MVVMProfileFragment();
            transaction.replace(R.id.frag_contain, fragment);
            transaction.commit();

            fragment
                    .setViewModel(
                            new ProfileViewModel(
                                    new GetUserProfileUseCase(
                                            ProfileRepositoryImpl.getInstance()),
                                    new UpdateUserProfileUseCase(
                                            ProfileRepositoryImpl.getInstance())));
        }
    }

}
