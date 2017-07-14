package tisoul.dev.mvvm;


import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment
        extends Fragment {

    ProfileViewModel viewModel;

    ViewDataBinding dataBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataBinding = DataBindingUtil
                .inflate(
                        inflater,
                        R.layout.fragment_profile,
                        container,
                        false);

        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataBinding.setVariable(BR.profile, viewModel);
        dataBinding.executePendingBindings();
    }

    @Override
    public void onStart() {
        super.onStart();

        viewModel.subscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        dataBinding.unbind();
    }
}
