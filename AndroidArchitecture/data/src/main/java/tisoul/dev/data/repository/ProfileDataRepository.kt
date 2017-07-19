package tisoul.dev.data.repository


import tisoul.dev.domain.model.UserProfile
import tisoul.dev.domain.repository.ProfileRepository
import tisoul.dev.domain.repository.model.ResultCallback
import javax.inject.Inject

class ProfileDataRepository @Inject
constructor() : ProfileRepository {

    private var userProfile: UserProfile? = null

    init {
        this.userProfile = UserProfile("Nguyen Cao Tai", "nguyencaotai@gmail.com")
    }

    override fun getProfile(result: ResultCallback<UserProfile>) {
        //perform async task here
        result.onSuccess(userProfile!!)
    }

    override fun saveProfile(userProfile: UserProfile, resultCallback: ResultCallback<Boolean>) {
        //perform async task here
        this.userProfile = userProfile
        resultCallback.onSuccess(true)
    }
}
