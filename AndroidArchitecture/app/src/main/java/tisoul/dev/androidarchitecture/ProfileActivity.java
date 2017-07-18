package tisoul.dev.androidarchitecture;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import tisoul.dev.androidarchitecture.di.component.DaggerProfileComponent;
import tisoul.dev.androidarchitecture.di.component.ProfileComponent;
import tisoul.dev.androidarchitecture.mvp.MVPProfileFragment;
import tisoul.dev.androidarchitecture.mvvm.MVVMProfileFragment;

public class ProfileActivity extends Activity {

    public static final String MODEL_TYPE = "model_type";

    String type;

    public ProfileComponent profileComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        type = getIntent().getStringExtra(MODEL_TYPE);

        profileComponent = getComponent();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        if ("mvp".equals(type)) {
            transaction.replace(R.id.frag_contain, new MVPProfileFragment());
        } else if ("mvvm".equals(type)) {
            transaction.replace(R.id.frag_contain, new MVVMProfileFragment());
        }

        transaction.commit();
    }

    private ProfileComponent getComponent() {
        return DaggerProfileComponent
                .builder()
                .applicationComponent(((AppApplication) getApplication())
                        .getApplicationComponent())
                .build();
    }
}
