package tisoul.dev.androidarchitecture.mvvm


import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.jakewharton.rxbinding2.widget.RxTextView
import tisoul.dev.androidarchitecture.BR
import tisoul.dev.androidarchitecture.ProfileActivity
import tisoul.dev.androidarchitecture.R
import tisoul.dev.androidarchitecture.databinding.FragmentProfileMvvmBinding
import javax.inject.Inject

class MVVMProfileFragment : Fragment() {

    @Inject
    lateinit var viewModel: ProfileViewModel

    internal var dataBinding: FragmentProfileMvvmBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpInjector()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle): View? {
        dataBinding = DataBindingUtil
                .inflate<FragmentProfileMvvmBinding>(
                        inflater,
                        R.layout.fragment_profile_mvvm,
                        container,
                        false)

        return dataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding?.setVariable(BR.profile, viewModel)
        dataBinding?.executePendingBindings()

        getDataStream(dataBinding!!.tvName)
                .subscribe { name -> viewModel.name.set(name) }
        getDataStream(dataBinding!!.tvEmail)
                .subscribe { email -> viewModel.email.set(email) }
    }

    override fun onStart() {
        super.onStart()

        viewModel.subscribe()
    }

    override fun onStop() {
        super.onStop()

        viewModel.unSubscribe()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        dataBinding?.unbind()
    }

    private fun getDataStream(view: EditText): io.reactivex.Observable<String> {
        return RxTextView
                .afterTextChangeEvents(view)
                .skipInitialValue()
                .map { it.view().editableText }
                .map(Editable::toString)
    }

    private fun setUpInjector() {
        (activity as ProfileActivity)
                .profileComponent!!
                .inject(this)
    }
}
