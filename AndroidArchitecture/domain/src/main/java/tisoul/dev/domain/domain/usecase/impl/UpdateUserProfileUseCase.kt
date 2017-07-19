package tisoul.dev.domain.domain.usecase.impl


import io.reactivex.Observable
import tisoul.dev.domain.domain.usecase.UpdateUserProfile
import tisoul.dev.domain.model.UserProfile
import tisoul.dev.domain.repository.ProfileRepository
import tisoul.dev.domain.repository.model.ResultCallback
import javax.inject.Inject

class UpdateUserProfileUseCase
@Inject constructor(private val profileRepository: ProfileRepository) : UpdateUserProfile {

    override fun execute(p: UserProfile): Observable<Boolean> = Observable.create<Boolean> {
        profileRepository
                .saveProfile(p, object : ResultCallback<Boolean> {
                    override fun onSuccess(d: Boolean) {
                        it.onNext(true)
                        it.onComplete()
                    }

                    override fun onError(throwable: Throwable) {
                        println("Update profile error")
                        it.onError(throwable)
                    }
                })
    }
}
