package tisoul.dev.androidarchitecture

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class WelcomeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        findViewById(R.id.bt_mvp)
                .setOnClickListener { view -> startActivity(getIntent(view, "mvp")) }

        findViewById(R.id.bt_mvvm)
                .setOnClickListener { view -> startActivity(getIntent(view, "mvvm")) }
    }

    private fun getIntent(view: View, type: String): Intent {
        val intent = Intent(view.context, ProfileActivity::class.java)
        intent.putExtra(ProfileActivity.Companion.MODEL_TYPE, type)

        return intent
    }
}
