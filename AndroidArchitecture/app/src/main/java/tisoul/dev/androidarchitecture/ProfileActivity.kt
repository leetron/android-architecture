package tisoul.dev.androidarchitecture

import android.app.Activity
import android.os.Bundle
import tisoul.dev.androidarchitecture.di.component.DaggerProfileComponent

import tisoul.dev.androidarchitecture.di.component.ProfileComponent
import tisoul.dev.androidarchitecture.mvp.MVPProfileFragment
import tisoul.dev.androidarchitecture.mvvm.MVVMProfileFragment

class ProfileActivity : Activity() {

    internal var type: String = ""

    var profileComponent: ProfileComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        type = intent.getStringExtra(MODEL_TYPE)

        profileComponent = component

        val transaction = fragmentManager.beginTransaction()

        if ("mvp" == type) {
            transaction.replace(R.id.frag_contain, MVPProfileFragment())
        } else if ("mvvm" == type) {
            transaction.replace(R.id.frag_contain, MVVMProfileFragment())
        }

        transaction.commit()
    }

    private val component: ProfileComponent
        get() = DaggerProfileComponent
                .builder()
                .applicationComponent((application as AppApplication)
                        .applicationComponent)
                .build()

    companion object {

        val MODEL_TYPE = "model_type"
    }
}
