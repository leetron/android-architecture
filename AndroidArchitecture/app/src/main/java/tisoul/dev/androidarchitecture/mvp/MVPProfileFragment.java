package tisoul.dev.androidarchitecture.mvp;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import javax.inject.Inject;

import tisoul.dev.androidarchitecture.ProfileActivity;
import tisoul.dev.androidarchitecture.R;

public class MVPProfileFragment
        extends Fragment
        implements Profile.View {

    EditText tvName;
    EditText tvEmail;

    @Inject
    Profile.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpInjector();

        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_mvp, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpView(view);
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();

        presenter.unSubscribe();
    }

    @Override
    public void setName(CharSequence name) {
        tvName.setText(name);
    }

    @Override
    public void setEmail(CharSequence email) {
        tvEmail.setText(email);
    }

    public void onUpdateClick(View view) {
        presenter
                .update(
                        tvName.getText(),
                        tvEmail.getText());
    }

    private void setUpView(View view) {
        tvName = (EditText) view.findViewById(R.id.tv_name);
        tvEmail = (EditText) view.findViewById(R.id.tv_email);

        view.findViewById(R.id.bt_update)
                .setOnClickListener(this::onUpdateClick);
    }

    private void setUpInjector() {
        ((ProfileActivity) getActivity())
                .profileComponent
                .inject(this);
    }
}
