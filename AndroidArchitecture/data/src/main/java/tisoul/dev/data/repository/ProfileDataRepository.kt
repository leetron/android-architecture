package tisoul.dev.data.repository


import io.reactivex.Observable
import tisoul.dev.domain.model.UserProfile
import tisoul.dev.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileDataRepository
@Inject constructor()
    : ProfileRepository {

    private var userProfile: UserProfile? = null

    init {
        this.userProfile = UserProfile("Nguyen Cao Tai", "nguyencaotai@gmail.com")
    }

    override fun getProfile(): Observable<UserProfile>
            = Observable.just(userProfile!!)

    override fun saveProfile(userProfile: UserProfile): Observable<UserProfile> {
        this.userProfile = userProfile
        return Observable.just(this.userProfile)
    }
}
