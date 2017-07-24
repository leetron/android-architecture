package tisoul.dev.androidarchitecture.mvp


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import tisoul.dev.androidarchitecture.ProfileActivity
import tisoul.dev.androidarchitecture.R
import tisoul.dev.androidarchitecture.commons.inflate
import javax.inject.Inject

class MVPProfileFragment : Fragment()
        , Profile.View {

    internal var tvName: EditText? = null
    internal var tvEmail: EditText? = null

    @Inject
    lateinit var presenter: Profile.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpInjector()

        presenter.setView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_profile_mvp)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView(view)
    }

    override fun onStart() {
        super.onStart()

        presenter.subscribe()
    }

    override fun onStop() {
        super.onStop()

        presenter.unSubscribe()
    }

    override fun setName(name: CharSequence) {
        tvName?.setText(name)
    }

    override fun setEmail(email: CharSequence) {
        tvEmail?.setText(email)
    }

    fun onUpdateClick() {
        presenter
                .update(
                        tvName?.text!!.toString(),
                        tvEmail?.text!!.toString())
    }

    private fun setUpView(view: View) {
        tvName = view.findViewById(R.id.tv_name) as EditText
        tvEmail = view.findViewById(R.id.tv_email) as EditText

        view.findViewById(R.id.bt_update)
                .setOnClickListener({ onUpdateClick() })
    }

    private fun setUpInjector() {
        (activity as ProfileActivity)
                .profileComponent!!
                .inject(this)
    }
}
