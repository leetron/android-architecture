package tisoul.dev.domain.domain.usecase.impl


import io.reactivex.Observable
import tisoul.dev.domain.domain.usecase.GetUserProfile
import tisoul.dev.domain.model.UserProfile
import tisoul.dev.domain.repository.ProfileRepository
import tisoul.dev.domain.repository.model.ResultCallback
import javax.inject.Inject

class GetUserProfileUseCase
@Inject constructor(private val profileRepository: ProfileRepository) : GetUserProfile {

    override fun execute(p: Boolean): Observable<UserProfile> = Observable.create<UserProfile> {
        profileRepository
                .getProfile(
                        object : ResultCallback<UserProfile> {
                            override fun onSuccess(d: UserProfile) {
                                it.onNext(d)
                                it.onComplete()
                            }

                            override fun onError(throwable: Throwable) {
                                it.onError(throwable)
                            }
                        })
    }
}
