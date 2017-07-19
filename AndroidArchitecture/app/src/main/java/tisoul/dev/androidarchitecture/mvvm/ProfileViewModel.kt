package tisoul.dev.androidarchitecture.mvvm


import android.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import tisoul.dev.domain.domain.usecase.GetUserProfile
import tisoul.dev.domain.domain.usecase.UpdateUserProfile
import tisoul.dev.domain.model.UserProfile
import javax.inject.Inject

class ProfileViewModel
@Inject constructor(
        private val getUserProfile: GetUserProfile,
        private val updateUserProfile: UpdateUserProfile) {

    val name = ObservableField<CharSequence>()
    val email = ObservableField<CharSequence>()

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun subscribe() {
        disposables.add(
                getUserProfile
                        .execute(false)
                        .subscribe { userProfile ->
                            name.set(userProfile.name)
                            email.set(userProfile.email)
                        })
    }

    fun unSubscribe() {
        disposables.clear()
    }

    fun onUpdateClick() {
        disposables.add(
                updateUserProfile
                        .execute(
                                UserProfile(
                                        name.get(),
                                        email.get()))
                        .subscribe(
                                { println("Update success") }
                        ) { println("Update error") })
    }
}
