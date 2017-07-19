package tisoul.dev.androidarchitecture.mvp


import io.reactivex.disposables.CompositeDisposable
import tisoul.dev.domain.domain.usecase.GetUserProfile
import tisoul.dev.domain.domain.usecase.UpdateUserProfile
import tisoul.dev.domain.model.UserProfile
import javax.inject.Inject

class ProfilePresenter
@Inject constructor(
        private val getUserProfile: GetUserProfile,
        private val updateUserProfile: UpdateUserProfile)
    : Profile.Presenter {

    private var view: Profile.View? = null

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun setView(view: Profile.View) {
        this.view = view
    }

    override fun subscribe() {
        disposables.add(
                getUserProfile
                        .execute(false)
                        .subscribe({
                            view!!.setName(it.name)
                            view!!.setEmail(it.email)
                        }
                        ) { println("Get Profile error") })
    }

    override fun unSubscribe() = disposables.clear()

    override fun update(name: CharSequence, email: CharSequence) {
        disposables.add(
                updateUserProfile
                        .execute(
                                UserProfile(
                                        name,
                                        email))
                        .subscribe(
                                { println("Update success") }
                        ) { println("Update error") })
    }
}
