package tisoul.dev.androidarchitecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import static tisoul.dev.androidarchitecture.ProfileActivity.MODEL_TYPE;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.bt_mvp)
                .setOnClickListener(view -> startActivity(getIntent(view, "mvp")));

        findViewById(R.id.bt_mvvm)
                .setOnClickListener(view -> startActivity(getIntent(view, "mvvm")));
    }

    @NonNull
    private Intent getIntent(View view, String type) {
        Intent intent = new Intent(view.getContext(), ProfileActivity.class);
        intent.putExtra(MODEL_TYPE, type);

        return intent;
    }
}
