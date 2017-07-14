package tisoul.dev.androidarchitecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tisoul.dev.mvp.ProfileActivity;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(android.R.id.content)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(
                                        new Intent(
                                                view.getContext(),
                                                ProfileActivity.class)
                                );
                            }
                        }
                );
    }
}
