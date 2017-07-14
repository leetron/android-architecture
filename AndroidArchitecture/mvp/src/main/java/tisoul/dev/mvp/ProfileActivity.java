package tisoul.dev.mvp;

import android.os.Bundle;
import android.app.Activity;

import tisoul.dev.data.ProfileRepositoryImpl;

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        new ProfilePresenter(
                (ProfileFragment) getFragmentManager().findFragmentById(R.id.fragment),
                new ProfileRepositoryImpl());
    }
}
