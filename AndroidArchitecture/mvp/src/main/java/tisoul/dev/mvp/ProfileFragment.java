package tisoul.dev.mvp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ProfileFragment
        extends Fragment
        implements Profile.View {

    @BindView(R2.id.tv_name)
    EditText tvName;

    @BindView(R2.id.tv_email)
    EditText tvEmail;

    Unbinder unbinder;

    Profile.Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(Profile.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setName(CharSequence name) {
        tvName.setText(name);
    }

    @Override
    public void setEmail(CharSequence email) {
        tvEmail.setText(email);
    }

    @OnClick(R2.id.bt_update)
    public void onUpdateClick() {
        presenter
                .update(
                        tvName.getText(),
                        tvName.getText());
    }
}
