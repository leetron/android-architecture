package tisoul.dev.androidarchitecture.mvvm;


import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;

import tisoul.dev.androidarchitecture.BR;
import tisoul.dev.androidarchitecture.R;
import tisoul.dev.androidarchitecture.databinding.FragmentProfileMvvmBinding;

public class MVVMProfileFragment
        extends Fragment {

    ProfileViewModel viewModel;

    FragmentProfileMvvmBinding dataBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataBinding = DataBindingUtil
                .inflate(
                        inflater,
                        R.layout.fragment_profile_mvvm,
                        container,
                        false);

        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataBinding.setVariable(BR.profile, viewModel);
        dataBinding.executePendingBindings();

        getDataStream(dataBinding.tvName)
                .subscribe(name -> viewModel.name.set(name));
        getDataStream(dataBinding.tvEmail)
                .subscribe(email -> viewModel.email.set(email));
    }

    @Override
    public void onStart() {
        super.onStart();

        viewModel.subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();

        viewModel.unSubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        dataBinding.unbind();
    }

    public void setViewModel(ProfileViewModel viewModel) {
        this.viewModel = viewModel;
    }

    private io.reactivex.Observable<String> getDataStream(TextView view){
        return RxTextView
                .afterTextChangeEvents(view)
                .skipInitialValue()
                .map(TextViewAfterTextChangeEvent::editable)
                .map(Editable::toString);
    }
}
